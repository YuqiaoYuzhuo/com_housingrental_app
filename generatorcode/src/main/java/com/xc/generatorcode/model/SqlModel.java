package com.xc.generatorcode.model;

/**
 * <p>Title: 默认sql语句的实体类</p>
 * <p>Description:默认sql语句的实体类 </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月21日
 */
public class SqlModel {
	/**
	 * sql标示
	 */
	private String sqlName;
	/**
	 * sql语句
	 */
	private String sql;
	/**
	 * 别名
	 */
	private String alias;
	/**
	 * 类名
	 */
	private String className;
	public String getSqlName() {
		return sqlName;
	}
	public void setSqlName(String sqlName) {
		this.sqlName = sqlName;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	public SqlModel() {
		super();
	}
	@Override
	public String toString() {
		return "SqlModel [sqlName=" + sqlName + ", sql=" + sql + ", alias="
				+ alias + ", className=" + className + "]";
	}
	
}
