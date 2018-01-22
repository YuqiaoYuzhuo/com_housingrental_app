package com.xc.generatorcode.util;

import java.util.ArrayList;
import java.util.List;

import com.xc.generatorcode.model.BeanModel;
import com.xc.generatorcode.model.HibernateCf;
import com.xc.generatorcode.model.TableBean;

/**
 * <p>Title: 生成model和hibernate配置文件的工具类</p>
 * <p>Description: </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月22日
 */
public class GeneraltorModeAndHibernateCfgUtil {
	/**
	 * <p>Description:生成实体类的方法<p>
	 * @param isCreateHcfg 是否生成hibernate配置文件
	 * @param tableBean 要生成实体类的表名，
	 * 如果为null则生成数据库所有表；
	 * 如果tablebean的tableColumn 
	 * 为空则生成所有数据列，如果有值则要生成制定列；
	 * @param packageNameStr
	 * @author wanglei 2018年1月22日
	 */
	public static void createModelFile(boolean isCreateHcfg,TableBean tableBean,String packageNameStr,String outPath){
		//初始化bean实体类
		List<BeanModel> beanModels = CreateBeanModelUtils.intJavabean(tableBean, packageNameStr);
		//创建实体bean文件
		CreateBeanModelUtils.createModelJavafile(outPath, packageNameStr,beanModels);
		if(isCreateHcfg){
			//数据表的工具初始化
			TableUtil tableBeanUtil = TableUtil.getTableBeanUtilInstance();
			List<TableBean> tableBeans =tableBeanUtil.getTableBeanByTable(tableBean);
			//配置文件生成
			createHibenateCfgFile(tableBeans,beanModels,packageNameStr,outPath);
		}
	}
	/**
	 * <p>Description:创建model的hibernate配置文件<p>
	 * @param tableBeans 数据表的集合类
	 * @param beanModels 数据model的集合
	 * @param packageNameStr 包名
	 * @param outPath 配置文存放路径
	 * @author wanglei 2018年1月22日
	 */
	public static void createHibenateCfgFile(List<TableBean> tableBeans, List<BeanModel> beanModels,String packageNameStr,String outPath){
		//配置文件列表
		List<HibernateCf> hibernateCfs = new ArrayList<>();
		for(int i=0;i<tableBeans.size();i++){
			HibernateCf hcf = CreateHibernateCfgUtil.inintHibernateCfgBean(tableBeans.get(i), beanModels.get(i));
			hibernateCfs.add(hcf);
		}
		// 生成实体类的hibernate配置文件
		CreateHibernateCfgUtil.createModelCfgfile(outPath, packageNameStr, hibernateCfs);
	}
}
