package com.xc.generatorcode.model;

import java.util.List;

/**
 * <p>Title: hibernate 配置文件的实体类</p>
 * <p>Description:hibernate 配置文件的实体类 </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月21日
 */
public class HibernateCf {
	/**
	 * 配置文件类名
	 */
	private String cfgClassName;
	/**
	 * 表名
	 */
	private String cfgTableName;
	/**
	 * 主键
	 */
	private String cfgTablePk;
	/**
	 * 数据库名
	 */
	private String cfgTableCatlog;
	/**
	 * 实体类名
	 */
	private String beanName;
	/**
	 * 主键
	 */
	private String id;
	/**
	 * hql 语句
	 */
	private HqlModel HqlModel;
	/**
	 * sql语句
	 */
	private SqlModel SqlModel;
	/**
	 * 配置属性表
	 */
	private List<CfgProperty> cfgProperty;
	public String getCfgClassName() {
		return cfgClassName;
	}
	public void setCfgClassName(String cfgClassName) {
		this.cfgClassName = cfgClassName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public HqlModel getHqlModel() {
		return HqlModel;
	}
	public void setHqlModel(HqlModel hqlModel) {
		HqlModel = hqlModel;
	}
	public SqlModel getSqlModel() {
		return SqlModel;
	}
	public void setSqlModel(SqlModel sqlModel) {
		SqlModel = sqlModel;
	}
	
	public List<CfgProperty> getCfgProperty() {
		return cfgProperty;
	}
	public void setCfgProperty(List<CfgProperty> cfgProperty) {
		this.cfgProperty = cfgProperty;
	}
	
	public String getCfgTableName() {
		return cfgTableName;
	}
	public void setCfgTableName(String cfgTableName) {
		this.cfgTableName = cfgTableName;
	}
	public String getCfgTablePk() {
		return cfgTablePk;
	}
	public void setCfgTablePk(String cfgTablePk) {
		this.cfgTablePk = cfgTablePk;
	}
	public HibernateCf() {
		super();
	}
	
	public String getCfgTableCatlog() {
		return cfgTableCatlog;
	}
	public void setCfgTableCatlog(String cfgTableCatlog) {
		this.cfgTableCatlog = cfgTableCatlog;
	}
	
	public String getBeanName() {
		return beanName;
	}
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	@Override
	public String toString() {
		return "HibernateCf [cfgClassName=" + cfgClassName + ", cfgTableName="
				+ cfgTableName + ", cfgTablePk=" + cfgTablePk
				+ ", cfgTableCatlog=" + cfgTableCatlog + ", beanName="
				+ beanName + ", id=" + id + ", HqlModel=" + HqlModel
				+ ", SqlModel=" + SqlModel + ", cfgProperty=" + cfgProperty
				+ "]";
	}
	
	
}
