package filter.pre

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext

import javax.servlet.http.HttpServletRequest

/**
 * @author fly
 * created on 17-10-15
 */
class PreFilter extends ZuulFilter{
    @Override
    String filterType() {
        return "pre"
    }

    @Override
    int filterOrder() {
        return 1000
    }

    @Override
    boolean shouldFilter() {
        return true
    }

    @Override
    Object run() {
        RequestContext context = RequestContext.getCurrentContext()
        HttpServletRequest request = context.getRequest()
        println "this is a pre filter: Send " + request.getMethod() + " request to " + request.getRequestURL().toString()
        return null
    }
}
