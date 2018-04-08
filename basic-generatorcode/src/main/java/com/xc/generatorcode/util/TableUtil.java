package com.xc.generatorcode.util;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.xc.generatorcode.model.TableBean;
import com.xc.generatorcode.model.TableColumn;
public class TableUtil {
	/**
	 * 数据库工具类
	 */
	private DbHelper dh = null;
	/**
	 * 数据库表工具类
	 */
	private static TableUtil tableBeanUtil ;
	
	/**
	 * 表属性列表
	 */
	public static List<TableBean> tableBeans ;
	private TableUtil(){
		dh = DbHelper.getDbHelperInstance();
	}
	/**
	 * <p>Description:初始化tableutil<p>
	 * @return
	 * @author wanglei 2018年1月21日
	 */
	public static TableUtil getTableBeanUtilInstance() {
		if (null == tableBeanUtil) {
			synchronized (TableUtil.class) {
				// 该同步代码块是为了解决多线程状态下 获取单例对象为null的问题
				tableBeanUtil = new TableUtil();
				//获取所有的表属性列表
				try {
					tableBeans = tableBeanUtil.getTales();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return tableBeanUtil;
	}
	
	/**
	 * <p>Description:获取表属性<p>
	 * @return
	 * @throws SQLException
	 * @author wanglei 2018年1月21日
	 */
	private List<TableBean> getTales() throws SQLException {
		//数据库表列表
		List<TableBean> tableBeans = new ArrayList<TableBean>();
		//获取表配置
		DatabaseMetaData dbmd = dh.getConnection().getMetaData();
		//数据库
		String catalog = dh.getConnection().getCatalog();
		//获取表对象
		ResultSet rs = dbmd.getTables(catalog, "%","%",new String[]{"TABLE"}); 
		//表对象
		TableBean tbaleBean = null ;
		while(rs.next()) {
			tbaleBean = new TableBean();
			String columnName =null; 
			String columnType =null; 
			String currentTableName= rs.getString("TABLE_NAME");
			String remarkes = rs.getString("REMARKS");
			//赋值表名
			tbaleBean.setTableName(currentTableName);
			tbaleBean.setTableContent(remarkes);
			tbaleBean.setTableCatalog(catalog);
			
			ResultSet colRet = dbmd.getColumns(null,"%",currentTableName ,"%"); 
			//赋值表属性
			//获取主键
			ResultSet pkrs = dbmd.getPrimaryKeys(catalog, null, currentTableName);
			String pkName  = null;
			while(pkrs.next()){ 
				 pkName = pkrs.getString("COLUMN_NAME");
			}
			//设置主键
			tbaleBean.setTbalePk(pkName);
			List<TableColumn> tableColumns = new ArrayList<TableColumn>();
			while(colRet.next()){ 
				TableColumn tableColumn = new TableColumn();
			    columnName = colRet.getString("COLUMN_NAME"); 
			    tableColumn.setColumnName(columnName);
				columnType = colRet.getString("TYPE_NAME"); 
				tableColumn.setColumnType(columnType);
				int datasize = colRet.getInt("COLUMN_SIZE"); 
				tableColumn.setColumnSize(datasize);
				int digits = colRet.getInt("DECIMAL_DIGITS");
				tableColumn.setColumnDecimalDigits(digits);
				int nullable = colRet.getInt("NULLABLE"); 
				tableColumn.setColumnIsnull(nullable);
				String REMARKS  = colRet.getString("REMARKS"); 
				tableColumn.setColumnRmark(REMARKS);
				tableColumns.add(tableColumn);
			}
			tbaleBean.setTableColumn(tableColumns);
			tableBeans.add(tbaleBean);
	   }
		return tableBeans;
	} 
	/**
	 * <p>Description:根据表名获取表属性<p>
	 * @param tableName
	 * @return
	 * @author wanglei 2018年1月21日
	 */
	public TableBean getTableBeanByTableName(String tableName){
		TableBean tableBean = null;
		//遍历获取表的bean对象
		for(TableBean tempTableBean : tableBeans){
			if(tempTableBean.getTableName().equals(tableName)){
				tableBean = tempTableBean;
				break;
			}
		}
		return tableBean ;
	}
	/**
	 * <p>Description:根据配置获取实体类<p>
	 * @param tableName 
	 * @return
	 * @author wanglei 2018年1月21日
	 */
	@SuppressWarnings("static-access")
	public List<TableBean> getTableBeanByTable(TableBean temTableBean){
		List<TableBean> tableBeans = new ArrayList<TableBean>();
		//遍历获取表的bean对象
		if(temTableBean!=null){
			String tableName =temTableBean.getTableName();
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
		return tableBeans ;
	}
}
