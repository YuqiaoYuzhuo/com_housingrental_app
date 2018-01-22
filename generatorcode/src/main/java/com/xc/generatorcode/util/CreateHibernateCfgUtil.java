package com.xc.generatorcode.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.xc.basic.exception.BusinessException;
import com.xc.generatorcode.model.BeanModel;
import com.xc.generatorcode.model.BeanProperties;
import com.xc.generatorcode.model.CfgProperty;
import com.xc.generatorcode.model.HibernateCf;
import com.xc.generatorcode.model.HqlModel;
import com.xc.generatorcode.model.SqlModel;
import com.xc.generatorcode.model.TableBean;
import com.xc.generatorcode.model.TableColumn;

/**
 * <p>Title:初始化hibernate配置文件类 </p>
 * <p>Description: </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月21日
 */
public class CreateHibernateCfgUtil {
	/**
	 * <p>Description:初始化hibernate配置文件实体类<p>
	 * @param tbale 表实体类
	 * @param beanModel 实体类bean
	 * @return
	 * @author wanglei 2018年1月21日
	 */
	public static HibernateCf inintHibernateCfgBean(TableBean tbale, BeanModel beanModel){
		HibernateCf hibernateCf = new HibernateCf();
		//设置表相关属性
		hibernateCf.setCfgTableCatlog(tbale.getTableCatalog());
		hibernateCf.setCfgTableName(tbale.getTableName());
		hibernateCf.setCfgTablePk(tbale.getTbalePk());
		hibernateCf.setBeanName(beanModel.getBeanName());
		hibernateCf.setCfgClassName(beanModel.getPackageNameStr()+"."+beanModel.getBeanName()+"");
		List<CfgProperty> cfgPropertys = new ArrayList<>();
		List<TableColumn> tcs = tbale.getTableColumn();
		List<BeanProperties> bps = beanModel.getColumns();
		//设置默认 hql
		HqlModel hqm = new HqlModel();
		hqm.setHql(" from " + beanModel.getBeanName() + " where 1=1 ");
		hqm.setHqlName("defaultHql");
		hibernateCf.setHqlModel(hqm);
		//设置表属性
		CfgProperty cfgProperty = null;
		StringBuffer sqlbf = new StringBuffer("SELECT ");
		int index = 0;
		for(int i=0;i<tcs.size();i++){
			cfgProperty = new CfgProperty();
			cfgProperty.setColumnName(tcs.get(i).getColumnName());
			sqlbf.append(tcs.get(i).getColumnName());
			//如果不是最后一个属性列拼接逗号
			if(index < tcs.size()-1){
				sqlbf.append(",");
			}
			cfgProperty.setColumnType(tcs.get(i).getColumnType());
			cfgProperty.setComment(tcs.get(i).getColumnRmark());
			cfgProperty.setPropertyName(bps.get(i).getPropertName());
			cfgProperty.setColumnNameLength(String.valueOf(tcs.get(i).getColumnSize()));
			cfgProperty.setDoubleScale(String.valueOf((tcs.get(i).getColumnDecimalDigits())));
			cfgProperty.setPropertyType(ColumnToPropertyUtil.getProperTypeClassName(bps.get(i).getPropertType()));
			//System.out.println(cfgProperty);
			index ++ ;
			cfgPropertys.add(cfgProperty);
		}
		sqlbf.append(" FROM "+tbale.getTableName()+" WHERE 1=1 ");
		//初始化默认的sql语句
		SqlModel sqlm = new  SqlModel();
		sqlm.setSqlName("defaultsql");
		//sqlm.setAlias(beanModel.getBeanName().substring(0,1));
		sqlm.setSql(sqlbf.toString());
		//sqlm.setClassName(beanModel.getPackageNameStr()+"."+beanModel.getBeanName()+"");
		hibernateCf.setCfgProperty(cfgPropertys);
		hibernateCf.setSqlModel(sqlm);
		//System.out.println(hibernateCf);
		return hibernateCf;
	}
	/**
	 * <p>Description:根据ftl生成实体类<p>
	 * @param outPath 生成代码路径
	 * @param packageStr 包名
	 * @author wanglei 2018年1月21日
	 */
	public static void createModelCfgfile(String outPath,String packageStr,List<HibernateCf> hibernateCfs) {
		if(StringUtils.isBlank(outPath)){throw new BusinessException("生成路径不存在，不能生成实体类"); }
		if(null == hibernateCfs){throw new BusinessException("配置文件类错误"); }
		//将包名转换成文件路径
		String packageFilePath = packageStr.replace(".", "\\");
		//代码最终路径
	    outPath = outPath + packageFilePath +"\\";
	    File destFile = new File(outPath);
	    boolean  pathHave  = false;
	    if (!destFile.exists()) {
	       pathHave = destFile.mkdirs();
	    }else{
	    	pathHave = true;
	    }
	    if(pathHave){
	    	PropertiesUtils.loadPropertiesInit("generator.properties");
	    	String templatePath = PropertiesUtils.getTemplatepath();
	    	FreemarkUtil ftlu = FreemarkUtil.getInstance("2.3.23",templatePath);
	    	Map<String,Object> dataModel = new HashMap<>();
	    	for(HibernateCf hc:hibernateCfs){
	    		dataModel.put("cfgPram", hc);
		    	ftlu.fprintTemplate(dataModel, "/hibernate-cfg.ftl", outPath, hc.getBeanName()+"-hbm.xml");
	        }
	    }
	}
}
