package com.xc.systemmanage_core.dao;

import java.util.List;

import com.xc.basic.hibernate.dao.IBaseDao;
import com.xc.basic.model.Pager;
import com.xc.systemmanage_core.model.Attachment;

public interface AttahcMentDao extends IBaseDao<Attachment>  {
	/**
	 * <p>Description:根据附件标示删除附件<p>
	 * @param ids
	 * @author wanglei 2018年3月11日
	 */
	public void deleteAttachmentByIds(String ids);
    /**
	 * <p>Description:查找附件列表<p>
	 * @param attachment 附件
	 * @return
	 * @author wanglei 2018年3月11日
	 */
	public List<Attachment> findAttachmentList(Attachment attachment );
	/**
	 * <p>Description:查找附件分页信息<p>
	 * @param attachment
	 * @return
	 * @author wanglei 2018年3月11日
	 */
	public Pager<Attachment> findAttachmentPager(Pager<Attachment> pager);
	/**
	 * <p>Description:根据业务id删除附件<p>
	 * @param businessIds
	 * @author wanglei 2018年3月14日
	 */
	public void deleteAttachmentByBusinessIds(String businessIds);
	/**
	 * <p>Description:根据业务主键查询附件<p>
	 * @param businessId
	 * @return
	 * @author wanglei 2018年3月14日
	 */
	public List<Attachment> findBybusinessId(String businessId);
}
