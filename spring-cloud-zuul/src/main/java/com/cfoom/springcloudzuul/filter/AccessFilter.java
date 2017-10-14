package com.cfoom.springcloudzuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by fly on 2017/10/13.
 */
@Component
@Slf4j
public class AccessFilter extends ZuulFilter {
    @Override
	public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        log.info("send {} to request {}", request.getMethod(), request.getRequestURL().toString());

        String token = WebUtils.findParameterValue(request, "token");
        if (StringUtils.isBlank(token)) {
            log.warn("access token is empty!!!");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            return null;
        }
        log.info("access pass!!!");
        return null;
    }
}
