package com.xc.generatorcode.model;

import java.util.List;

/**
 * <p>Title:数据库表实体类 </p>
 * <p>Description:数据库表实体类 </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月21日
 */
public class TableBean {
	/**
	 * 表名
	 */
	private String tableName;
	/**
	 * 表注释
	 */
	private String tableContent;
	/**
	 * 数据库
	 */
	private String tableCatalog;
	/**
	 * 表属性
	 */
	private List<TableColumn> tableColumn;
	/**
	 * 表主键名
	 */
	private String tbalePk;
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public List<TableColumn> getTableColumn() {
		return tableColumn;
	}

	public void setTableColumn(List<TableColumn> tableColumn) {
		this.tableColumn = tableColumn;
	}
	
	public String getTableContent() {
		return tableContent;
	}

	public void setTableContent(String tableContent) {
		this.tableContent = tableContent;
	}
	
	public String getTableCatalog() {
		return tableCatalog;
	}

	public void setTableCatalog(String tableCatalog) {
		this.tableCatalog = tableCatalog;
	}
	

	public String getTbalePk() {
		return tbalePk;
	}

	public void setTbalePk(String tbalePk) {
		this.tbalePk = tbalePk;
	}

	@Override
	public String toString() {
		return "TableBean [tableName=" + tableName + ", tableContent="
				+ tableContent + ", tableCatalog=" + tableCatalog
				+ ", tableColumn=" + tableColumn + ", tbalePk=" + tbalePk + "]";
	}

	
	
}
