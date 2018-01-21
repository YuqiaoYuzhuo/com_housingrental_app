package com.xc.generatorcode.model;

/**
 * <p>Title:hibernate 配置属性实体 </p>
 * <p>Description: hibernate 配置属性实体</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月21日
 */
public class CfgProperty {
	/**
	 * 属性名
	 */
	private String propertyName;
	/**
	 * 属性类型
	 */
	private String propertyType;
	/**
	 * 列名
	 */
	private String columnName;
	/**
	 * 列属性
	 */
	private String columnType;
	/**
	 * 注解
	 */
	private String comment;
	/**
	 * 列长度
	 */
	private String columnNameLength;
	/**
	 * 小数点位数
	 */
	private String doubleScale;
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getColumnType() {
		return columnType;
	}
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getColumnNameLength() {
		return columnNameLength;
	}
	public void setColumnNameLength(String columnNameLength) {
		this.columnNameLength = columnNameLength;
	}
	
	public String getDoubleScale() {
		return doubleScale;
	}
	public void setDoubleScale(String doubleScale) {
		this.doubleScale = doubleScale;
	}
	
	@Override
	public String toString() {
		return "CfgProperty [propertyName=" + propertyName + ", propertyType="
				+ propertyType + ", columnName=" + columnName + ", columnType="
				+ columnType + ", comment=" + comment + ", columnNameLength="
				+ columnNameLength +  ", doubleScale=" + doubleScale + "]";
	}
	public CfgProperty() {
		super();
	}
	
}
