package com.xc.systemmanage_core.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xc.basic.hibernate.dao.BaseDao;
import com.xc.basic.model.Pager;
import com.xc.basic.util.ReflectUtils;
import com.xc.systemmanage_core.dao.BusinessAttchmentRelDao;
import com.xc.systemmanage_core.model.BusinessAttachmentRel;

/**
 * <p>Title:业务类和附件关联关系的dao </p>
 * <p>Description: </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年3月11日
 */
@Repository("businessAttchmentRelDao")
public class BusinessAttachmentRelDaoImpl extends 
	BaseDao<BusinessAttachmentRel> implements BusinessAttchmentRelDao {

	@Override
	public void deleteByUuids(String uuids) {
		this.batchDele(uuids);
	}

	@Override
	public void deleteByBussinessUuids(String bids) {
		String hql = "delete from BusinessAttachmentRel where businessUuid ";
		this.excByHql(hql+this.getHqlCondition(bids));
	}

	@Override
	public void deleteByAttachmentIds(String aids) {
		String hql = "delete from BusinessAttachmentRel where attachUuid ";
		this.excByHql(hql+this.getHqlCondition(aids));
	}

	@Override
	public List<BusinessAttachmentRel> findBylist(
			BusinessAttachmentRel businessAttachmentRel) {
		String hql = this.getHqlByHqlName("defaultHqlBusinessAttachmentRel");
		return this.listByhqlWithAlias(hql,ReflectUtils.getBeanProperty(businessAttachmentRel));
	}

	@Override
	public Pager<BusinessAttachmentRel> findByPager(
			Pager<BusinessAttachmentRel> pager) {
		String hql = this.getHqlByHqlName("defaultHqlBusinessAttachmentRel");
		return this.findByHqlWithalias(hql, pager.getQueryParams());
	}

	public static void main(String[] args) {
		new BusinessAttachmentRelDaoImpl().deleteByUuids("1,2,3");
	}

}
