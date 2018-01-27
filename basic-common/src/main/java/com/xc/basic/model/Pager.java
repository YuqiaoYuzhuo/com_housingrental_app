package com.xc.basic.model;

import java.util.List;
import java.util.Map;
/**
 * <p>Title:公共的分页信息 </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright wanglei(c) 2017</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">WangLei</a>
 * @version 1.0
 * @history:
 * Created by WangLei 2017年1月8日
 */
public class Pager<T> {
	/**
	 *页的大小
	 */
	private int size;
	
	/**
	 * 分页其实页
	 */
	private int offset;
	/**
	 * 总的记录数
	 */
	private long total;
	
	/**
	 * 分页的数据
	 */
	private List<T> datas;
	/**
	 * 分页参数
	 */
	private Map<String,Object> queryParams;
	public int getSize() {
		return size;
	}

	public int getOffset() {
		return offset;
	}

	public long getTotal() {
		return total;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	
	public Map<String, Object> getQueryParams() {
		return queryParams;
	}

	public void setQueryParams(Map<String, Object> queryParams) {
		this.queryParams = queryParams;
	}

	public Pager() {
		super();
	}

}
