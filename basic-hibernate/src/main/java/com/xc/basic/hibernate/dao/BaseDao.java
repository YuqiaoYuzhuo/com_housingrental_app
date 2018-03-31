package com.xc.basic.hibernate.dao;

import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.transform.Transformers;

import com.xc.basic.exception.BusinessException;
import com.xc.basic.model.Pager;
import com.xc.basic.model.SystemContext;

/**
 * <p>Title: 基于Hibernate 4.2.0 的BaseDao</p>
 * <p>Description: 包含了使用SQL、HQL、增删改查方法</p>
 * <p>Copyright: Copyright wanglei(c) 2017</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">WangLei</a>
 * @version 1.0
 * @history:
 * Created by WangLei 2017年1月8日
 */
@SuppressWarnings("unchecked")
public class BaseDao<T>  implements IBaseDao<T> {
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	/**
	 * <p>Description:注入sessionFactory<p>
	 * @param sessionFactory
	 * @author WangLei 2017年1月9日
	 */
	@Inject
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * <p>Description:获取打开的session<p>
	 * @return
	 * @author WangLei 2017年1月9日
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	/**
	 * 根据模板T获取class
	 */
	private Class<T> clz;
	public Class<T> getClz(){
		if(clz==null) {
			//获取泛型的Class对象
		clz = ((Class<T>)(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
		}
		return clz;
	}
	/**
	 * <p>Description: 初始化排序方法<p>
	 * @param hql hql语句
	 * @return 添加好排序的hql
	 * @author WangLei 2017年1月9日
	 */
	private String inintSort(String hql){
		//设置排序
		String order = SystemContext.getOrder();
		String sort = SystemContext.getSort();
		if(null != sort && !"".equals(sort.trim())){
			hql+=" order by "+order;
		if( !"desc".equals(sort)) hql+=" asc";
		else hql += " desc";
		}
		
		return hql;
	}
	@SuppressWarnings("rawtypes")
	private void setAilasParameter(Query query,Map<String ,Object> alias){
		//设置别名
		if(null != alias){
			Set<String> keys = alias.keySet();
			for(String key :keys){
				Object val = alias.get(key);
				if(val instanceof Collection ){
					//查询条件是列表
					query.setParameterList(key, (Collection)val );
				}else{
					query.setParameter(key, val);
				}
			}
		}
	}
	/**
	 * <p>Description:设置参数<p>
	 * @param query query查询
	 * @param args 参数
	 * @author WangLei 2017年1月11日
	 */
	private void setParameter(Query query,Object []args){
		//设置参数
		if(null != args && args.length>0){
			int index = 0;
			for(Object arg :args){
				query.setParameter( index ++, arg);
			}
		}
	}
	/**
	 * <p>Description:初始化分页信息<p>
	 * @param quer
	 * @author WangLei 2017年1月9日
	 */
	@SuppressWarnings("rawtypes")
	private void setPagers(Query query,Pager pages){
		Integer pageSize = SystemContext.getPageSize();
		Integer pageOffset = SystemContext.getPageOffset();
		if(null == pageOffset || pageOffset<0){
			pageOffset=0;
		}
		if(null == pageSize || pageSize<0  ){
			pageSize = 15;
		}
		query.setFirstResult(pageOffset);
		query.setMaxResults(pageSize); 
		
		pages.setOffset(pageOffset);
		pages.setSize(pageSize);
	}
	/**
	 * <p>Description:获取记录数的hql<p>
	 * @param hql hql语句
	 * @param isFetch 是否抓取
	 * @return
	 * @author WangLei 2017年1月9日
	 */
	private String getCountHql(String hql,boolean isFetch){
		String endstr=hql.substring(hql.indexOf("from"));
		String c = "select count(*) " +endstr;
		if(isFetch){ //是否抓取
			c.replaceAll("fetch", "");
		}
		return c;
	}
	@Override
	public T add(T t) {
		getSession().save(t);
		return t;
	}
	@Override
	public void update(T t) {
		getSession().update(t);
	}
	@Override
	public void delete(String id) {
		getSession().delete(this.load(id));
	}
	
	@Override
	public void delete(Integer id) {
		getSession().delete(this.load(id));
	}
	@Override
	public T load(String id) {
		return (T)getSession().load(getClz(), id);
	}
	@Override
	public T load(Integer id) {
		return (T)getSession().load(getClz(), id);
	}
	/**
	 * <p>Description:根据hql 语句查询对象<p>
	 * @param hql hql语句
	 * @param args 参数
	 * @return
	 * @author WangLei 2017年1月8日
	 */
	public List<T> listByhqlWithParams(String hql, Object[] args) {
		return this.listByhqlWithAliasAndParams(hql, args, null);
	}
	/**
	 * <p>Description:根据hql 查询<p>
	 * @param hql hql 语句
	 * @param args 参数
	 * @return
	 * @author WangLei 2017年1月8日
	 */
	public List<T> listByhqlWithParam(String hql, Object args) {
		return listByhqlWithParams(hql,new Object[]{args});
	}
	/**
	 * <p>Description:根据 hql 语句查询<p>
	 * @param hql
	 * @return
	 * @author WangLei 2017年1月8日
	 */
	public List<T> listByhql(String hql) {
		return listByhqlWithParams(hql,null);
	}
	/**
	 * <p>Description:命名hql和参数混合查询<p>
	 * @param hql hql语句
	 * @param args 非命名参数
	 * @param alias 命名参数 Map<String ,Object> 名称 ，参数
	 * @return
	 * @author WangLei 2017年1月8日
	 */
	public List<T> listByhqlWithAliasAndParams(String hql, Object[] args, Map<String, Object> alias) {
		hql = this.inintSort(hql);
		Query query = getSession().createQuery(hql);
		this.setParameter(query,args);
		this.setAilasParameter(query, alias);
		return query.list();
	}
	/**
	 * <p>Description:<p>
	 * @param hql hql 语句
	 * @param alias 命名参数  Map<String ,Object> 名称 ，参数
	 * @return
	 * @author WangLei 2017年1月8日
	 */
	public List<T> listByhqlWithAlias(String hql, Map<String, Object> alias) {
		return listByhqlWithAliasAndParams(hql, null, alias);
	}
	/**
	 * <p>Description:通过hql 查询分页对象<p>
	 * @param hql
	 * @param args
	 * @return
	 * @author WangLei 2017年1月8日
	 */
	public Pager<T> findByhqlWithParams(String hql, Object[] args) {
		return this.findByHqlWithParamsAndalias(hql,args,null);
	}
	/**
	 * <p>Description:通过hql 查询分页对象<p>
	 * @param hql hql 语句
	 * @param args 参数
	 * @return
	 * @author WangLei 2017年1月8日
	 */
	public Pager<T> findByhqlWithParam(String hql, Object args) {
		return this.findByhqlWithParams(hql,new Object[]{args});
	}
	/**
	 * <p>Description:通过hql 查询分页对象<p>
	 * @param hql
	 * @return
	 * @author WangLei 2017年1月8日
	 */
	public Pager<T> findByhql(String hql) {
		return this.findByhqlWithParams(hql,null);
	}
	/**
	 * <p>Description:通过hql 查询分页对象<p>
	 * @param hql hql语句
	 * @param args 非命名参数
	 * @param alias 命名参数 Map<String ,Object> 名称 ，参数
	 * @return
	 * @author WangLei 2017年1月8日
	 */
	public Pager<T> findByHqlWithParamsAndalias(String hql, Object[] args, Map<String, Object> alias) {
		hql = this.inintSort(hql);
		// 获取记录数的sql
		String cq = this.getCountHql(hql,true);
		Query query = getSession().createQuery(hql);
		Query cquery = getSession().createQuery(cq);
		//设置参数和别名（命名）
		this.setAilasParameter(query, alias);
		this.setParameter(query, args);
		this.setAilasParameter(cquery, alias);
		this.setParameter(cquery, args);
		Pager<T> pages = new Pager<T>();
		this.setPagers(query,pages);
		List<T> datas = query.list();
		long total = (Long)cquery.uniqueResult();
            pages.setDatas(datas);
		pages.setTotal(total);
		return pages;
	}
	/**
	 * <p>Description:通过hql 查询分页对象<p>
	 * @param hql hql 语句
	 * @param alias 命名参数  Map<String ,Object> 名称 ，参数
	 * @return
	 * @author WangLei 2017年1月8日
	 */
	public Pager<T> findByHqlWithalias(String hql, Map<String, Object> alias) {
		return this.findByHqlWithParamsAndalias(hql, null, alias);
	}
	/**
	 * <p>Description:根据hql 语句返回一个对象<p>
	 * @param hql hql 语句 
	 * @param args 参数
	 * @return
	 * @author WangLei 2017年1月8日
	 */
	public Object queryObjectByHqlWithParams(String hql, Object[] args) {
		return this.queryObjectByHqlWithParamsAndaials(hql, args, null);
	}
	/**
	 * <p>Description:根据hql 语句返回一个对象<p>
	 * @param hql
	 * @param args 参数
	 * @param alias 别名 <String ,Object> key 和参数
	 * @return 对象
	 * @author WangLei 2017年1月9日
	 */
	public Object queryObjectByHqlWithParam(String hql, Object args) {
		return this.queryObjectByHqlWithParams(hql, new Object []{args});
	}
	/**
	 * <p>Description:根据hql 语句返回一个对象<p>
	 * @param hql 
	 * @param alias 别名 <String ,Object> key 和参数
	 * @return 对象
	 * @author WangLei 2017年1月9日
	 */
	public Object queryObjectByHqlWithParamsAndaials(String hql, Object[] args, Map<String, Object> alias) {
		Query query = getSession().createQuery(hql);
		this.setAilasParameter(query, alias);
		this.setParameter(query, args);
		return query.uniqueResult();
	}
	/**
	 * <p>Description:<p>
	 * @param hql hql 语句
	 * @param args 参数
	 * @return
	 * @author WangLei 2017年1月8日
	 */
	public Object queryObjectByHqlWithParamsAndaials(String hql, Map<String, Object> alias) {
		return this.queryObjectByHqlWithParamsAndaials(hql, null, alias);
	}
	/**
	 * <p>Description:根据hql 语句返回一个对象<p>
	 * @param hql hql语句
	 * @return
	 * @author WangLei 2017年1月8日
	 */
	public Object queryObjectByHql(String hql) {
		return this.queryObjectByHqlWithParams(hql, null);
	}
	/**
	 * <p>Description:根据Hql 语句 更新对象<p>
	 * @param hql hql 语句
	 * @param args 参数
	 * @return
	 * @author WangLei 2017年1月8日
	 */
	public Object updateByHqlWithParams(String hql, Object[] args) {
		Query query = getSession().createQuery(hql);
		this.setParameter(query , args);
		return query.executeUpdate();
	}
	/**
	 * <p>Description:根据hql语句更新对象<p>
	 * @param hql hql语句
	 * @param args 参数
	 * @return
	 * @author WangLei 2017年1月8日
	 */
	public Object updateByHqlWithParam(String hql, Object args) {
		return this.updateByHqlWithParams(hql, new Object[]{args});
	}
	/**
	 * <p>Description:根据hql语句更新对象<p>
	 * @param hql hql语句
	 * @return
	 * @author WangLei 2017年1月8日
	 */
	public Object updateByHql(String hql) {
		return updateByHqlWithParam(hql,null);
	}
	/**
	 * <p>Description:根据sql 查询对象 不包含关联对象<p>
	 * @param sql sql 语句
	 * @param args 参数
	 * @param clazz 实体类class
	 * @param hasEntity 是否是一个hibernate管理实体  如果不是需要采用setResultTransform查询
	 * @return 对象列表
	 * @author WangLei 2017年1月8日
	 */
	public <N extends Object>List<N> listBysql(String sql,  Class<?> clazz, boolean hasEntity) {
		return this.listBysqlWithParams(sql, null, clazz, hasEntity);
	}
	/**
	 * <p>Description:根据sql 查询对象 不包含关联对象<p>
	 * @param sql sql 语句
	 * @param args 参数
	 * @param clazz 实体类class
	 * @param hasEntity 是否是一个hibernate管理实体  如果不是需要采用setResultTransform查询
	 * @return 对象列表
	 * @author WangLei 2017年1月8日
	 */
	public <N extends Object> List<N> listBysqlWithParamsAndalias(String sql, Object[] args, Map<String, Object> alias, Class<?> clazz, boolean hasEntity) {
		sql = this.inintSort(sql);
		SQLQuery sqquery =  getSession().createSQLQuery(sql);
		setAilasParameter(sqquery, alias);
		setParameter(sqquery, args);
		if(hasEntity){
			sqquery.addEntity(getClz());
		}else{//如果不是hibernate转换的实体类要转化成实体类
			sqquery.setResultTransformer(Transformers.aliasToBean(clazz));  
		}
		return sqquery.list();
	}
	/**
	 * <p>Description:根据sql 查询对象 不包含关联对象<p>
	 * @param sql sql 语句
	 * @param clazz 实体类class
	 * @param hasEntity 是否是一个hibernate管理实体  如果不是需要采用setResultTransform查询
	 * @return 对象列表
	 * @author WangLei 2017年1月8日
	 */
	public <N extends Object>List<N> listBysqlWithParams(String sql, Object[] args, Class<?> clazz, boolean hasEntity) {
		return this.listBysqlWithParamsAndalias(sql, args, null, clazz, hasEntity);
	}
	/**
	 * <p>Description:通过sql 查询对象<p>
	 * @param sql sql语句
	 * @param args 非命名参数
	 * @param alias 命名参数 Map<String ,Object> 名称 ，参数
	 *@param hasEntity 是否是一个hibernate管理实体  如果不是需要采用setResultTransform查询
	 * @return
	 * @author WangLei 2017年1月8日
	 */
	public <N extends Object>List<N> listBysqlWithParam(String sql, Object args, Class<?> clazz, boolean hasEntity) {
		return this.listBysqlWithParams(sql, new Object[]{args}, clazz,  hasEntity);
	}
	/**
	 * <p>Description:通过sql 查询对象<p>
	 * @param sql sql语句
	 * @param alias 命名参数 Map<String ,Object> 名称 ，参数
	 *@param hasEntity 是否是一个hibernate管理实体  如果不是需要采用setResultTransform查询
	 * @return
	 * @author WangLei 2017年1月8日
	 */
	public <N extends Object>List<N> listBysqlWithalias(String sql, Map<String, Object> alias, Class<?> clazz, boolean hasEntity) {
		return this.listBysqlWithParamsAndalias(sql, null, alias, clazz, hasEntity);
	}

	/**
	 * <p>Description:根据sql 查询对象<p>
	 * @param sql sql语句
	 * @param args 参数
	 * @param clazz 对象class
	 * @param hasEntity 是否是一个hibernate管理实体  如果不是需要采用setResultTransform查询
	 * @return
	 * @author WangLei 2017年1月8日
	 */
	public <N extends Object> Pager<N> findBysqlWithParams(String sql, Object[] args, Class<?> clazz, boolean hasEntity) {
		return findBysqlWithParamsAndalias(sql, args, null, clazz, hasEntity);
	}
	/**
	 * <p>Description:根据sql 查询分页对象<p>
	 * @param sql sql语句
	 * @param args 参数
	 * @param clazz 对象class
	 * @param hasEntity 是否是一个hibernate管理实体  如果不是需要采用setResultTransform查询
	 * @return
	 * @author WangLei 2017年1月8日
	 */
	public <N extends Object> Pager<N> findBysqlWithParam(String sql, Object args, Class<?> clazz, boolean hasEntity) {
		return findBysqlWithParams(sql, new Object[]{args}, clazz, hasEntity);
	}
	/**
	 * <p>Description:根据sql 查询分页对象<p>
	 * @param sql sql语句
	 * @param clazz 对象class
	 * @param hasEntity 是否是一个hibernate管理实体  如果不是需要采用setResultTransform查询
	 * @return
	 * @author WangLei 2017年1月8日
	 */
	public  <N extends Object> Pager<N> findBysql(String sql, Class<?> clazz, boolean hasEntity) {
		return findBysqlWithParam(sql, null, clazz, hasEntity);
	}
	/**
	 * <p>Description:通过sql 查询分页对象<p>
	 * @param sql sql语句
	 * @param alias 命名参数 Map<String ,Object> 名称 ，参数
	 * @param hasEntity 是否是一个hibernate管理实体  如果不是需要采用setResultTransform查询
	 * @return
	 * @author WangLei 2017年1月8日
	 */
	public  <N extends Object> Pager<N> findBysqlWithParamsAndalias(String sql, Object[] args, Map<String, Object> alias, Class<?> clazz, boolean hasEntity) {
		String cq = getCountHql(sql,false);
		sql = inintSort(sql);
		SQLQuery sq = getSession().createSQLQuery(sql);
		SQLQuery cquery = getSession().createSQLQuery(cq);
		setParameter( sq, args);
		setAilasParameter(sq, alias);
		setParameter( cquery, args);
		setAilasParameter(cquery, alias);
		Pager<N> pages = new Pager<N>();
		setPagers(sq, pages);
		if(hasEntity){
			sq.addEntity(getClz());
			BigInteger bg =(BigInteger)cquery.uniqueResult();
			long total = bg==null?0:bg.longValue();
			pages.setTotal(total);
		}else{//如果不是hibernate转换的实体类要转化成实体类
			BigInteger bg =(BigInteger)cquery.uniqueResult();
			long total = bg==null?0:bg.longValue();
			cquery.setResultTransformer(Transformers.aliasToBean(clazz));  
			pages.setTotal(total);
			
		}
		pages.setDatas( sq.list());
		return pages;
	}
	/**
	 * <p>Description:通过sql 查询分页对象<p>
	 * @param sql sql语句
	 * @param alias 命名参数 Map<String ,Object> 名称 ，参数
	 *@param hasEntity 是否是一个hibernate管理实体  如果不是需要采用setResultTransform查询
	  * @return
	 * @author WangLei 2017年1月8日
	 */
	public <N extends Object> Pager<N> findBysqlWithalias(String sql, Map<String, Object> alias, Class<?> clazz, boolean hasEntity) {
		return findBysqlWithParamsAndalias(sql, null, alias, clazz, hasEntity);
	}
	/**
	 * <p>Description:根据SQL查询object列表<p>
	 * @param hql
	 * @param alias
	 * @param args
	 * @return
	 * @author WangLei 2017年2月9日
	 */
	public <N extends Object>List<N> listObj(String hql,Map<String,Object> alias,Object ...args) {
		hql = inintSort(hql);
		Query query = getSession().createQuery(hql);
		setAilasParameter(query, alias);
		setParameter(query, args);
		return query.list();
	}
	public <N extends Object>List<N> listObj(String hql,Object ...args) {
		return this.listObj(hql,null, args);
	}

	public int getMaxOrder(Integer pid,String clz) {
		String hql = "select max(o.orderNum) from "+clz+" o where o.parent.id="+pid;
		if(pid==null||pid==0) hql = "select max(o.orderNum) from "+clz+" o where o.parent is null";
		Object obj = this.queryObjectByHql(hql);
		if(obj==null) return 0;
		return (Integer)obj;
	}
	
	public int getMaxOrder(String clz) {
		String hql = "select max(o.orderNum) from "+clz+" o ";
		Object obj = this.queryObjectByHql(hql);
		if(obj==null) return 0;
		return (Integer)obj;
	}
	@Override
	public String getHqlByHqlName(String hqlName) {
		return sessionFactory.openSession().getNamedQuery(hqlName).getQueryString();
	}
	@Override
	public String getSqlBySqlName(String sqlName) {
		return sessionFactory.openSession().getNamedQuery(sqlName).getQueryString();
	}
	@Override
	public void excByHql(String hql) {
		sessionFactory.openSession().createQuery(hql).executeUpdate();
	}
	@Override
	public String getHqlCondition(String ids) {
		if(StringUtils.isBlank(ids)) throw new BusinessException("条件不能为空!");
		String [] idsArr = ids.split(","); 
		StringBuffer sbf = new  StringBuffer(" in ( ");
		int index = 0 ;
		for(String id:idsArr){
			index ++;
			sbf.append("'"+id+"'");
			if(index <=idsArr.length-1){
				sbf.append(", ");
			}
			if(index ==idsArr.length){
				sbf.append(" )");
			}
		}
		
		return sbf.toString();
	}
	@Override
	public void batchDele(String ids) {
		ClassMetadata meta = sessionFactory.getClassMetadata(getClz()); 
		//主键名称  
		String pkName = meta.getIdentifierPropertyName();
		String hql = "delete from "+getClz().getSimpleName()+" where "+pkName+this.getHqlCondition(ids);
		this.excByHql(hql);
	}
	@Override
	public void excSqlWithArgs(String sql, Object[] args) {
		Query sqlquery = this.getSession().createSQLQuery(sql);
		setParameter(sqlquery, args);
		sqlquery.executeUpdate();
	}
	@Override
	public void excSql(String sql) {
		this.excSqlWithArgs(sql, null);
	}
	@Override
	public void excSqlWithArg(String sql, Object arg) {
		this.excSqlWithArgs(sql, new Object[]{arg});
	}
	@Override
	public Object[] getParmsByString(String ids) {
		if(StringUtils.isBlank(ids)) throw new BusinessException("条件不能为空!");
		String [] idsArr = ids.split(","); 
		return idsArr;
	}
	
}
