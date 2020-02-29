package com.xingzhang.itoken.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginFilter extends ZuulFilter {
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
    public Object run() throws ZuulException {
        RequestContext currentContxt = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContxt.getRequest();
        String token = request.getParameter("token");
        /*if(token == null){
            currentContxt.setSendZuulResponse(false);
            currentContxt.setResponseStatusCode(401);
            try {
                HttpServletResponse response = currentContxt.getResponse();
                response.setContentType("text/html;charset=utf-8");
                currentContxt.getResponse().getWriter().write("非法请求");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        return null;
    }
}
