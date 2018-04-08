package com.xc.generatorcode.model;

/**
 * <p>Title:hql 语句model </p>
 * <p>Description: hql 语句model</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月21日
 */
public class HqlModel {
	/**
	 * 配置文件的hql 语句名字
	 */
	private String hqlName;
	/**
	 * hql语句
	 */
	private String hql;
	public String getHqlName() {
		return hqlName;
	}
	public void setHqlName(String hqlName) {
		this.hqlName = hqlName;
	}
	public String getHql() {
		return hql;
	}
	public void setHql(String hql) {
		this.hql = hql;
	}
	@Override
	public String toString() {
		return "HqlModel [hqlName=" + hqlName + ", hql=" + hql + "]";
	}
	public HqlModel() {
		super();
	}
	
}
