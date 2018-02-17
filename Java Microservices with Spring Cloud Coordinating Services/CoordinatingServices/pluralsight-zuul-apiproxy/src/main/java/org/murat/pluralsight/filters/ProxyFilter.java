package org.murat.pluralsight.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class ProxyFilter extends ZuulFilter{

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        boolean isMobile = false;
        RequestContext ctx = RequestContext.getCurrentContext();
        String param = ctx.getRequest().getParameter("source");
        if(param != null && param.equalsIgnoreCase("mobile")){
            isMobile = true;
        }

        return isMobile;
    }

    @Override
    public Object run() {
        System.out.println("Calling a filter!");
        return null;
    }
}
