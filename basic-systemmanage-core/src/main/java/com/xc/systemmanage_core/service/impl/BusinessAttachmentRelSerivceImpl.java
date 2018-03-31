package com.xc.systemmanage_core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xc.basic.model.Pager;
import com.xc.basic.util.DateUtil;
import com.xc.basic.util.UUIDGenerator;
import com.xc.systemmanage_core.dao.BusinessAttchmentRelDao;
import com.xc.systemmanage_core.model.BusinessAttachmentRel;
import com.xc.systemmanage_core.service.BusinessAttachmentRelService;
@Service("businessAttachmentRelService")
public class BusinessAttachmentRelSerivceImpl implements BusinessAttachmentRelService {
	@Autowired
	private BusinessAttchmentRelDao businessAttchmentRelDao;
	@Override
	public void addBusinessAttachmentRel(
			BusinessAttachmentRel businessAttachmentRel) {
		String attachRelUuid = UUIDGenerator.createUUID();
		businessAttachmentRel.setAttachRelUuid(attachRelUuid);
		businessAttachmentRel.setAttachRelLastmodifyTime(DateUtil.getCurrentTimstamp());
		businessAttchmentRelDao.add(businessAttachmentRel);
	}

	@Override
	public void deleteBusinessAttachmentRelBuyUuids(String ids) {
		businessAttchmentRelDao.delete(ids);
	}

	@Override
	public void deleteBusinessAttachmentRelByBusinessUuid(String bids) {
		businessAttchmentRelDao.deleteByBussinessUuids(bids);
	}

	@Override
	public void deleteBusinessAttachmentRelByAttachUuids(String attachUuids) {
		businessAttchmentRelDao.deleteByAttachmentIds(attachUuids);
	}

	@Override
	public void updateBusinessAttachmentRel(
			BusinessAttachmentRel businessAttachmentRel) {
		businessAttachmentRel.setAttachRelLastmodifyTime(DateUtil.getCurrentTimstamp());
		businessAttchmentRelDao.update(businessAttachmentRel);		
	}

	@Override
	public List<BusinessAttachmentRel> findBusinessAttachmentRelList(
			BusinessAttachmentRel businessAttachmentRel) {
		return businessAttchmentRelDao.findBylist(businessAttachmentRel);
	}

	@Override
	public Pager<BusinessAttachmentRel> findBusinessAttachmentRelPager(
			Pager<BusinessAttachmentRel> pager) {
		return businessAttchmentRelDao.findByPager(pager);
	}

	@Override
	public BusinessAttachmentRel finByid(String uuid) {
		return businessAttchmentRelDao.load(uuid);
	}

}
