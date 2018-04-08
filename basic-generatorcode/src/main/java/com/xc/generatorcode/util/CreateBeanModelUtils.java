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
import com.xc.generatorcode.model.TableBean;
import com.xc.generatorcode.model.TableColumn;

/**
 * <p>Title:生成实体类的工具里 </p>
 * <p>Description:生成实体类的工具里 </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月21日
 */
public class CreateBeanModelUtils {
	//bean对象列表
	/**
	 * <p>Description:根据表属性和实体类属性生成javabean<p>
	 * @param tableBean 表格的bean
	 * @param bm 实体类属性
	 * @author wanglei 2018年1月21日
	 */
	@SuppressWarnings("static-access")
	public  static  List<BeanModel> intJavabean(TableBean tableBean,String packageNameStr){
		 List<BeanModel> beanModels = new ArrayList<BeanModel>();
		if(StringUtils.isBlank(packageNameStr)){
			throw new BusinessException("指定包名不存在不能生成实体类"); 
		}
		//初始化数据表工具
		TableUtil tableBeanUtil = TableUtil.getTableBeanUtilInstance();
		//数据表对象列表
		List<TableBean> tableBeans = new ArrayList<TableBean>();
		if(tableBean!=null){
			String tableName =tableBean.getTableName();
			if(StringUtils.isNotBlank(tableName)){
				//table对象
				TableBean temtableBean = tableBeanUtil.getTableBeanByTableName(tableName);
				tableBeans.add(temtableBean);
			}else{
				tableBeans =tableBeanUtil.tableBeans;
			}
		}else{
			tableBeans =tableBeanUtil.tableBeans;
		}
		//如果存在则将表格封装成model对象列表
		if(tableBeans.size()>0){
			
			//如果指定表格名为空则默认生成全部的属性
			BeanModel beanModel = null;
			List<TableColumn> inittableColumns = null;
			if(tableBean!=null){
			 inittableColumns = tableBean.getTableColumn();
			}
			if(null == inittableColumns){
				//生成全部属性
				for(TableBean temtableBean:tableBeans){
					beanModel=new BeanModel ();
					List<TableColumn> tableColumns = temtableBean.getTableColumn();
					String beanName = ColumnToPropertyUtil.getBeanNameByTableName(temtableBean.getTableName());
					beanModel.setBeanName(beanName);
					beanModel.setPackageNameStr(packageNameStr);
					List<BeanProperties> beanProperties = intJavaProperByTableColumnName(tableColumns);
					beanModel.setColumns(beanProperties);
					beanModel.setBeanContent(temtableBean.getTableContent());
					beanModel.setImportStrs(ColumnToPropertyUtil.getImportStrByBeanProperType(beanProperties));
					//System.out.println(beanModel);
					beanModels.add(beanModel);
				}
			}else{
				//生成指定属性列
				for(TableBean temtableBean:tableBeans){
					List<TableColumn> tableColumns = temtableBean.getTableColumn();
					for(TableColumn inittableColumn :inittableColumns){
						if(!tableColumns.contains(inittableColumn)){
							tableColumns.remove(tableColumns);
						}
					}
					String beanName = ColumnToPropertyUtil.getBeanNameByTableName(temtableBean.getTableName());
					beanModel=new BeanModel ();
					beanModel.setBeanName(beanName);
					beanModel.setPackageNameStr(packageNameStr);
					List<BeanProperties> beanProperties = intJavaProperByTableColumnName(tableColumns);
					beanModel.setColumns(beanProperties);
					beanModel.setBeanContent(temtableBean.getTableContent());
					beanModel.setImportStrs(ColumnToPropertyUtil.getImportStrByBeanProperType(beanProperties));
					beanModels.add(beanModel);
				}
			}
		}
		return beanModels;
	}
	/**
	 * <p>Description:根据列名初始化javabean的实体属性<p>
	 * @param tableColumnName
	 * @return
	 * @author wanglei 2018年1月21日
	 */
	public static List<BeanProperties> intJavaProperByTableColumnName(List<TableColumn> tableColumns){
		List<BeanProperties> beanPropertieses = new ArrayList<BeanProperties>();
		if(null!=tableColumns && tableColumns.size()>0){
			BeanProperties beanProperties = null;
			for(TableColumn tableColumn: tableColumns){
				beanProperties = new BeanProperties();
				String columnName = ColumnToPropertyUtil.camelName(tableColumn.getColumnName());
				beanProperties.setPropertName(ColumnToPropertyUtil.camelName(columnName));
				beanProperties.setPropertComment(tableColumn.getColumnRmark());
				beanProperties.setPropertType(ColumnToPropertyUtil.getBenaPropertiesTypeByTableColumn(tableColumn.getColumnType()));
				beanProperties.setPropertNameUpCase(StringUtils.capitalize(columnName));	
				beanPropertieses.add(beanProperties);
			}
		}
		return beanPropertieses;
	}
	/**
	 * <p>Description:根据ftl生成实体类<p>
	 * @param outPath 生成代码路径
	 * @param packageStr 包名
	 * @author wanglei 2018年1月21日
	 */
	public static void createModelJavafile(String outPath,String packageStr,List<BeanModel> beanModels) {
		if(StringUtils.isBlank(outPath)){throw new BusinessException("生成路径不存在，不能生成实体类"); }
		if(StringUtils.isBlank(packageStr)){throw new BusinessException("指定包名为空不能生成实体类"); }
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
	    	for(BeanModel beanModel:beanModels){
	    		dataModel.put("Paramss", beanModel);
		    	ftlu.fprintTemplate(dataModel, "/modelbean.ftl", outPath, beanModel.getBeanName()+".java");
	        }
	    }
	}
}
