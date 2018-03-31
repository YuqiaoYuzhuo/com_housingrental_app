package com.xc.systemmanage_core.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xc.basic.hibernate.dao.BaseDao;
import com.xc.basic.model.Pager;
import com.xc.basic.util.ReflectUtils;
import com.xc.systemmanage_core.dao.AttahcMentDao;
import com.xc.systemmanage_core.model.Attachment;
@Repository("attahcMentDao")
public class AttachMentDaoImpl extends BaseDao <Attachment> implements AttahcMentDao   {
	
	@Override
	public void deleteAttachmentByIds(String ids) {
		this.batchDele(ids);
	}

	@Override
	public List<Attachment> findAttachmentList(Attachment attachment) {
		String hql = this.getHqlByHqlName("defaultHqlAttachment");
		return this.listByhqlWithAlias(hql, ReflectUtils.getBeanProperty(attachment));
	}

	@Override
	public Pager<Attachment> findAttachmentPager( Pager<Attachment> pager) {
		String hql = this.getHqlByHqlName("defaultHqlAttachment");
		return this.findByHqlWithalias(hql, pager.getQueryParams());
	}

	@Override
	public void deleteAttachmentByBusinessIds(String businessIds) {
		String sql = "delete from tb_attachment  where ATTACH_UUID in (select tbar.ATTACH_UUID from tb_business_attachment_rel tbar where tbar.BUSINESS_UUID='?')";
		 this.excSqlWithArg(sql, this.getParmsByString(businessIds));
	}

	@Override
	public List<Attachment> findBybusinessId(String businessId) {
		String hql = this.getHqlByHqlName("listByBussinessId");
		Map<String,Object> ails = new HashMap<String,Object>();
		ails.put("businessId", businessId);
		return this.listByhqlWithAlias(hql,ails);
	}

}
