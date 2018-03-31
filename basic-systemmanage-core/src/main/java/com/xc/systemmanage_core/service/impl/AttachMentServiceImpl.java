package com.xc.systemmanage_core.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xc.basic.model.Pager;
import com.xc.basic.model.UploadFileModel;
import com.xc.basic.util.DateUtil;
import com.xc.basic.util.FtpUtil;
import com.xc.basic.util.UUIDGenerator;
import com.xc.systemmanage_core.dao.AttahcMentDao;
import com.xc.systemmanage_core.model.Attachment;
import com.xc.systemmanage_core.model.BusinessAttachmentRel;
import com.xc.systemmanage_core.service.AttachMentService;
import com.xc.systemmanage_core.service.BusinessAttachmentRelService;
@Service("attachMentService")
public class AttachMentServiceImpl implements AttachMentService{
	@Autowired
	private AttahcMentDao attahcMentDao;
	@Autowired
	private BusinessAttachmentRelService businessAttachmentRelService;
	@Override
	public Attachment addAttachment(UploadFileModel upf,String bussinessId) {
		String attachUuid = UUIDGenerator.createUUID();
		FtpUtil ftu = FtpUtil.getFtputil();
		String filepath = null;
		try {
			filepath = ftu.uploadFile(upf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//TODO 实现附件存储数据库
		Attachment attachment = new Attachment();
		attachment.setAttachEtc(upf.getSuffix());
		attachment.setAttachRealName(upf.getFileRealName());
		attachment.setAttachSize(Double.parseDouble(upf.getFileSize()));
		attachment.setAttachSysName(upf.getFileSystemName());
		attachment.setAttachSysPath(filepath);
		attachment.setAttachUpPath(upf.getFile_upload_real_path());
		//attachment.setAttachUpPerson(userService.getCurentLoginUser().getUserInfo().getUserUuid());
		attachment.setAttachUpTime(DateUtil.getCurrentTimstamp());
		attachment.setAttachUuid(attachUuid);
		attachment.setAttachModifyTime(DateUtil.getCurrentTimstamp());
		attahcMentDao.add(attachment);
		BusinessAttachmentRel businessAttachmentRel = new BusinessAttachmentRel();
		businessAttachmentRel.setAttachUuid(attachUuid);
		businessAttachmentRel.setBusinessUuid(bussinessId);
		businessAttachmentRelService.addBusinessAttachmentRel(businessAttachmentRel);
		return attachment;
	}

	@Override
	public void deleteAttachmentByIds(String ids) {
		//删除关联关系
		businessAttachmentRelService.deleteBusinessAttachmentRelByAttachUuids(ids);
		//删除附件
		attahcMentDao.deleteAttachmentByIds(ids);
	}

	@Override
	public void deleteAttachmentByBusinessIds(String businessIds) {
		//删除与本业务有关的附件
		attahcMentDao.deleteAttachmentByBusinessIds(businessIds);
		//删除关联关系
		businessAttachmentRelService.deleteBusinessAttachmentRelByBusinessUuid(businessIds);
	}

	@Override
	public void updateAttachment(Attachment attachment,
			BusinessAttachmentRel businessAttachmentRel) {
		attachment.setAttachModifyTime(DateUtil.getCurrentTimstamp());
		attahcMentDao.update(attachment);
		businessAttachmentRelService.updateBusinessAttachmentRel(businessAttachmentRel);
	}

	@Override
	public List<Attachment> findAttachmentList(Attachment attachment) {
		return attahcMentDao.findAttachmentList(attachment);
	}

	@Override
	public Pager<Attachment> findAttachmentPager(Pager<Attachment> pager) {
		return attahcMentDao.findAttachmentPager(pager);
	}

	@Override
	public Attachment findByid(String uuid) {
		return attahcMentDao.load(uuid);
	}

	@Override
	public List<Attachment> findAttachmentBusinessUuid(String businessuuid) {
		return attahcMentDao.findBybusinessId(businessuuid);
	}

}
