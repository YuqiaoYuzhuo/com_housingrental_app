package com.xc.houserental.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.lang.StringUtils;

import com.xc.basic.model.SystemContext;

/**
 * <p>Title: 初始化分页信息的过滤器</p>
 * <p>Description:初始化分页信息的过滤器 </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月14日
 */
public class SystemContextFilter implements Filter {
	private Integer pageSize ;
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		Integer offset = 0;
		try {
			offset = Integer.parseInt(req.getParameter("pager.offset"));
		} catch (NumberFormatException e) {
		}
		try {
			SystemContext .setOrder(req.getParameter("pager.order"));
			SystemContext.setPageOffset(offset);
			String _pageSize = req.getParameter("pageSize");
			String pager_pageSize = req.getParameter("size");
			if(StringUtils.isNotBlank(_pageSize)){
				pager_pageSize =_pageSize;
			}if(StringUtils.isNotBlank(pager_pageSize)){
				SystemContext.setPageSize(Integer.parseInt(pager_pageSize));
			}else{
				SystemContext.setPageSize(pageSize);
			} 
			SystemContext.setSort(req.getParameter("sort"));
			chain.doFilter(req, res);
		} finally{
			SystemContext.removeOrder();
			SystemContext.removePageOffset();
			SystemContext.removePageSize();
			SystemContext.removeSort();
			
		}
	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		try {
			pageSize = Integer.parseInt(cfg.getInitParameter("pageSize"));
		} catch (NumberFormatException e) {
			pageSize = 10;
		}
	}

}
