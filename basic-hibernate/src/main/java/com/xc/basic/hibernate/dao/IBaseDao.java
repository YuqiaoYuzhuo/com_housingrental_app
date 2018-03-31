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
	 * <p>Description:根据hql语句删除<p>
	 * @param hql hql语句
	 * @author wanglei 2018年3月11日
	 */
	public void excByHql(String hql);
	/**
	 * <p>Description:批量删除<p>
	 * @param ids 主键列表
	 * @author wanglei 2018年3月11日
	 */
	public void batchDele(String ids);
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
	/**
	 * <p>Description:根据hql名字获取hql语句<p>
	 * @param hqlName hql语句名字
	 * @return hql语句
	 * @author wanglei 2018年1月27日
	 */
	public String getHqlByHqlName(String hqlName);
	/**
	 * <p>Description:根据sql语句名字获取sql语句<p>
	 * @param sqlName sql语句名字
	 * @return SQL语句
	 * @author wanglei 2018年1月27日
	 */
	public String getSqlBySqlName(String sqlName);
	/**
	 * <p>Description:根据获取获取删除条件参数<p>
	 * @param ids
	 * @return
	 * @author wanglei 2018年3月11日
	 */
	public String getHqlCondition(String ids);
	/**
	 * <p>Description:根据条件执行sql<p>
	 * @param sql
	 * @param args
	 * @author wanglei 2018年3月14日
	 */
	public void  excSqlWithArgs(String sql,Object[] args);
	/**
	 * <p>Description:根据一个参数执行sql<p>
	 * @param sql
	 * @param args
	 * @author wanglei 2018年3月14日
	 */
	public void  excSqlWithArg(String sql,Object arg);
	/**
	 * <p>Description:执行sql<p>
	 * @param sql SQL语句
	 * @author wanglei 2018年3月14日
	 */
	public void excSql(String sql);
	/**
	 * <p>Description:根据","分割的参数获取条件值<p>
	 * @param ids 条件
	 * @return
	 * @author wanglei 2018年3月14日
	 */
	public Object[] getParmsByString (String ids);
}
