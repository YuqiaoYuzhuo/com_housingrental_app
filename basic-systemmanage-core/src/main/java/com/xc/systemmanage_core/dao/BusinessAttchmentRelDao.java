package com.xc.systemmanage_core.dao;

import java.util.List;

import com.xc.basic.hibernate.dao.IBaseDao;
import com.xc.basic.model.Pager;
import com.xc.systemmanage_core.model.BusinessAttachmentRel;

public interface BusinessAttchmentRelDao extends IBaseDao<BusinessAttachmentRel> {
	/**
	 * <p>Description:根据主键删除<p>
	 * @param uuids
	 * @author wanglei 2018年3月11日
	 */
	public void deleteByUuids(String uuids);
	/**
	 * <p>Description:根据业务主键删除<p>
	 * @param bids
	 * @author wanglei 2018年3月11日
	 */
	public void deleteByBussinessUuids(String bids);
	/**
	 * <p>Description:根据附件主键删除<p>
	 * @param aids
	 * @author wanglei 2018年3月11日
	 */
	public void deleteByAttachmentIds(String aids);
	/**
	 * <p>Description:查询附件关联关系集合<p>
	 * @param businessAttachmentRel
	 * @return
	 * @author wanglei 2018年3月11日
	 */
	public List<BusinessAttachmentRel> findBylist(BusinessAttachmentRel businessAttachmentRel);
	/**
	 * <p>Description:查询附件关联关系分页信息<p>
	 * @param pager
	 * @return
	 * @author wanglei 2018年3月11日
	 */
	public Pager<BusinessAttachmentRel> findByPager(Pager<BusinessAttachmentRel> pager);
}
