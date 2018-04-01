package com.xc.generatorcode;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.xc.generatorcode.model.BeanModel;
import com.xc.generatorcode.model.HibernateCf;
import com.xc.generatorcode.model.TableBean;
import com.xc.generatorcode.util.CreateBeanModelUtils;
import com.xc.generatorcode.util.CreateHibernateCfgUtil;
import com.xc.generatorcode.util.GeneraltorModeAndHibernateCfgUtil;
import com.xc.generatorcode.util.TableUtil;



public class GeneratorCodeTest {
	private TableUtil tableBeanUtil;
	@Before
	public void inint(){
		tableBeanUtil = TableUtil.getTableBeanUtilInstance();
	}
	@SuppressWarnings("static-access")
	public void testGetTaleCoulm() throws SQLException{
		System.out.println(tableBeanUtil.tableBeans);
		System.out.println(tableBeanUtil.getTableBeanByTableName("tb_back_money_certificate"));
	}
	public void testInitJavabean(){
		TableBean tableBean = new TableBean();
		tableBean.setTableName("tb_back_money_certificate");
		CreateBeanModelUtils.intJavabean(null, "com.model");
	}
	public void testCreateBeanfile(){
		TableBean tableBean = new TableBean();
		tableBean.setTableName("tb_back_money_certificate");
		List<BeanModel> beanModels = CreateBeanModelUtils.intJavabean(null, "com.model");
		CreateBeanModelUtils.createModelJavafile("D:\\testmodel\\", "com.model",beanModels);
	}
	
	public void testCfgInit(){
		List<BeanModel> beanModels = CreateBeanModelUtils.intJavabean(null, "com.model");
		List<TableBean> tableBean =tableBeanUtil.getTableBeanByTable(null);
		for(int i=0;i<tableBean.size();i++){
			CreateHibernateCfgUtil.inintHibernateCfgBean(tableBean.get(i), beanModels.get(i));
		}
	}
	public void testCreateBean(){
		List<BeanModel> beanModels = CreateBeanModelUtils.intJavabean(null, "com.model");
		List<TableBean> tableBean =tableBeanUtil.getTableBeanByTable(null);
		List<HibernateCf> hibernateCfs = new ArrayList<>();
		for(int i=0;i<tableBean.size();i++){
			HibernateCf hcf = CreateHibernateCfgUtil.inintHibernateCfgBean(tableBean.get(i), beanModels.get(i));
			hibernateCfs.add(hcf);
		}
		CreateHibernateCfgUtil.createModelCfgfile("D:\\testmodel\\", "com.model", hibernateCfs);
	}
	@Test
	public void testGenertorUtils(){
//		TableBean tablebean = new TableBean();
//		tablebean.setTableName("tb_role_menu_rel");
//		GeneraltorModeAndHibernateCfgUtil.createModelFile(true, tablebean, "com.xc.systemmanage_core.model", "D:\\javawork\\mywokspace\\com_housingrental_app\\basic-systemmanage-core\\src\\main\\java\\");
	}
}
