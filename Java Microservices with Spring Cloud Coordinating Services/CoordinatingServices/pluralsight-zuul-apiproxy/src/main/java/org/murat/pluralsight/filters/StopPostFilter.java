package org.murat.pluralsight.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class StopPostFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        Instant stop = Instant.now();

        RequestContext ctx = RequestContext.getCurrentContext();
        Instant start = (Instant) ctx.get("starttime");
        long secondsDifference = ChronoUnit.MILLIS.between(start, stop);

        System.out.println("Call took " + secondsDifference + " milliseconds.");

        return null;
    }
}
