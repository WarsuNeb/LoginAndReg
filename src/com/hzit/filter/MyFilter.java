package com.hzit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {
	private String encoding;

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// 设置全局编码
		arg1.setContentType("text/html;charset=" + encoding);
		arg0.setCharacterEncoding(encoding);
		// 使过滤器继续走下去
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// 获取前端参数
		encoding = arg0.getInitParameter("encoding");
	}
}
