package com.xc.basic.hibernate.dao;


/**
 * <p>Title: 公共的dao处理方法 </p>
 * <p>Description:包含了hibernate的所有基本操作和对sql的操作 </p>
 * <p>Copyright: Copyright wanglei(c) 2017</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">WangLei</a>
 * @version 1.0
 * @history:
 * Created by WangLei 2017年1月8日
 */
public interface IBaseDao <T>{
	/**
	 * <p>Description:添加对象<p>
	 * @param t
	 * @return
	 * @author WangLei 2017年1月8日
	 */
	public T add (T t);
	/**
	 * <p>Description:根据 id 更新对象<p>
	 * @param t
	 * @author WangLei 2017年1月8日
	 */
	public void update (T t);
	/**
	 * <p>Description:删除对象<p>
	 * @param t
	 * @author WangLei 2017年1月8日
	 */
	public void delete (String id);
	/**
	 * <p>Description:根据id查询对象<p>
	 * @param id
	 * @return
	 * @author WangLei 2017年1月8日
	 */
	public T load(String id);
	/**
	 * <p>Description:根据int主键查询<p>
	 * @param id 主键
	 * @return
	 * @author wanglei 2018年1月13日
	 */
	public T load(Integer id);
	/**
	 * <p>Description:根据int主键删除<p>
	 * @param id
	 * @author wanglei 2018年1月13日
	 */
	public void delete(Integer id);
	
}
