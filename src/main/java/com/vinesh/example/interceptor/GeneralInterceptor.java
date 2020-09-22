package com.vinesh.example.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import com.vinesh.example.util.HttpServletReqUtil;
import com.vinesh.example.util.MyHttpServletRequestWrapper;

@Component
public class GeneralInterceptor implements HandlerInterceptor {

	@Autowired
	private HttpServletReqUtil reqUtil;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		final MyHttpServletRequestWrapper wrappedRequest = new MyHttpServletRequestWrapper(request);
		System.out.println("Pre handle method has been called");
		System.out.println("User IP address: " + reqUtil.getRemoteAddress(wrappedRequest));
		System.out.println("Request Params: " + reqUtil.getRequestParams(wrappedRequest));
		System.out.println("Request Payload: " + reqUtil.getPayLoad(wrappedRequest));
		System.out.println("Exiting Pre handle method");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		   System.out.println("Post handle method has been called");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {
		   System.out.println("After Completion method has been called");
	}
}
