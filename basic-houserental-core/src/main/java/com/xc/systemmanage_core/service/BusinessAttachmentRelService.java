package com.xc.systemmanage_core.service;

import java.util.List;

import com.xc.basic.model.Pager;
import com.xc.systemmanage_core.model.BusinessAttachmentRel;

/**
 * <p>Title:附件业务关联关系service </p>
 * <p>Description: </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年3月11日
 */
public interface BusinessAttachmentRelService {
	/**
	 * <p>Description:根据主键查询关联关系<p>
	 * @param uuid 主键
	 * @return
	 * @author wanglei 2018年3月14日
	 */
	public BusinessAttachmentRel finByid(String uuid);
	/**
	 * <p>Description:增加关联关系<p>
	 * @param businessAttachmentRel
	 * @author wanglei 2018年3月11日
	 */
	public void addBusinessAttachmentRel(BusinessAttachmentRel businessAttachmentRel);
	/**
	 * <p>Description:根据关系id删除<p>
	 * @param ids
	 * @author wanglei 2018年3月11日
	 */
	public void deleteBusinessAttachmentRelBuyUuids(String ids);
	/**
	 * <p>Description:根据业务信息删除关联关系<p>
	 * @param bids 业务主键
	 * @author wanglei 2018年3月11日
	 */
	public void deleteBusinessAttachmentRelByBusinessUuid(String bids);
	/**
	 * <p>Description:根据附件id删除关联关系<p>
	 * @param attachUuids
	 * @author wanglei 2018年3月11日
	 */
	public void deleteBusinessAttachmentRelByAttachUuids(String attachUuids);
	/**
	 * <p>Description:更新关联关系<p>
	 * @param businessAttachmentRel
	 * @author wanglei 2018年3月11日
	 */
	public void updateBusinessAttachmentRel(BusinessAttachmentRel businessAttachmentRel);
	/**
	 * <p>Description:查找关系列表<p>
	 * @param businessAttachmentRel
	 * @return
	 * @author wanglei 2018年3月11日
	 */
	public List<BusinessAttachmentRel> findBusinessAttachmentRelList(BusinessAttachmentRel businessAttachmentRel);
	/**
	 * <p>Description:查找关联关系分页信息<p>
	 * @param businessAttachmentRel
	 * @return
	 * @author wanglei 2018年3月11日
	 */
	public Pager<BusinessAttachmentRel> findBusinessAttachmentRelPager(Pager<BusinessAttachmentRel> pager);
	
}
