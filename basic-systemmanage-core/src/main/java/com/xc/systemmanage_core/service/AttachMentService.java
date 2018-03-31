package com.xc.systemmanage_core.service;

import java.util.List;

import com.xc.basic.model.Pager;
import com.xc.basic.model.UploadFileModel;
import com.xc.systemmanage_core.model.Attachment;
import com.xc.systemmanage_core.model.BusinessAttachmentRel;

/**
 * <p>Title:附件信息业务接口 </p>
 * <p>Description: 实现附件信息的增删改查</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年3月11日
 */
public interface AttachMentService {
	public Attachment findByid(String uuid);
	/**
	 * <p>Description:新增附件<p>
	 * @param attachment 附件
	 * @param businessAttachmentRel 附件业务关联关系
	 * @author wanglei 2018年3月11日
	 */
	public Attachment addAttachment(UploadFileModel upf,String bussinessId);
	/**
	 * <p>Description:根据附件标示删除附件<p>
	 * @param ids
	 * @author wanglei 2018年3月11日
	 */
	public void deleteAttachmentByIds(String ids);
	/**
	 * <p>Description:根据业务主键删除附件<p>
	 * @param businessIds
	 * @author wanglei 2018年3月11日
	 */
	public void deleteAttachmentByBusinessIds(String businessIds);
	/**
	 * <p>Description:更新附件信息<p>
	 * @param attachment 附件
	 * @param businessAttachmentRel
	 * @author wanglei 2018年3月11日
	 */
	public void updateAttachment(Attachment attachment ,BusinessAttachmentRel businessAttachmentRel);
	/**
	 * <p>Description:查找附件列表<p>
	 * @param attachment 附件
	 * @return
	 * @author wanglei 2018年3月11日
	 */
	public List<Attachment> findAttachmentList(Attachment attachment );
	/**
	 * <p>Description:根据业务id查询所有附件<p>
	 * @param businessuuid 业务主键
	 * @return
	 * @author wanglei 2018年3月31日
	 */
	public List<Attachment> findAttachmentBusinessUuid(String businessuuid );
	/**
	 * <p>Description:查找附件分页信息<p>
	 * @param attachment
	 * @return
	 * @author wanglei 2018年3月11日
	 */
	public Pager<Attachment> findAttachmentPager(Pager<Attachment> pager);
}
