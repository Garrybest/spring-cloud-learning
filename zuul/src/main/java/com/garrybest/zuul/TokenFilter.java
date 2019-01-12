package com.garrybest.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

public class TokenFilter extends ZuulFilter {

    /**
     * @return 过滤器的类型，它决定过滤器在请求的哪个生命周期中执行。pre表示在请求被路由之前执行
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * @return filter执行顺序，数字越大，优先级越低。
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        String token = request.getParameter("token");
        if (token == null || token.isEmpty()) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("token is empty");
        } else if (!token.equals("password")){
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("password is incorrect");
        }
        return null;
    }
}
