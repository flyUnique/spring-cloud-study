package com.cfoom.springcloudzuul.filter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by fly on 2017/10/14.
 */
@Component
@Slf4j
public class ErrorFilter extends ZuulFilter {
	@Override
	public String filterType() {
		return "error";
	}

	@Override
	public int filterOrder() {
		return 10;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext context = RequestContext.getCurrentContext();
		Throwable throwable = context.getThrowable();
		log.error("error happend {}", throwable.getCause().getMessage());

		context.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		context.set("error.exception", throwable.getCause());
		return null;
	}
}
