package com.vinesh.example.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.vinesh.example.util.HttpServletReqUtil;
import com.vinesh.example.util.MyHttpServletRequestWrapper;

@Component
@Order(1)
public class TransactionFilter implements Filter {

	@Autowired
	private HttpServletReqUtil reqUtil;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		final MyHttpServletRequestWrapper wrappedRequest = new MyHttpServletRequestWrapper(
				(HttpServletRequest) request);
		System.out.println("Inside Servlet Filter");
		System.out.println("User IP address: " + reqUtil.getRemoteAddress(wrappedRequest));
		System.out.println("Request Params: " + reqUtil.getRequestParams(wrappedRequest));
		System.out.println("Request Payload: " + reqUtil.getPayLoad(wrappedRequest));
		System.out.println("Exiting Servlet Filter");
		chain.doFilter(wrappedRequest, response);
	}
}
