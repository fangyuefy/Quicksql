package com.qihoo.qsql.client;

import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

@WebFilter(filterName = "QuicksqlFilter", urlPatterns = { "/*" })
public class QuicksqlFilter implements Filter
{
    public void destroy() {
        RequestManager.removeHttpServletRequest();
    }

    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        RequestManager.setHttpServletRequest((HttpServletRequest)request);
        chain.doFilter(request, response);
    }

    public void init(final FilterConfig config) throws ServletException {
    }
}
