package com.qihoo.qsql.client;

import javax.servlet.http.*;

public class RequestManager {
    private static ThreadLocal<HttpServletRequest> threadLocal;
    static {
        RequestManager.threadLocal = new ThreadLocal<HttpServletRequest>();
    }
    public static void setHttpServletRequest(final HttpServletRequest request) {
        if (request != null) {
            RequestManager.threadLocal.set(request);
        }
    }

    public static HttpServletRequest getHttpServletRequest() {
        return RequestManager.threadLocal.get();
    }

    public static void removeHttpServletRequest() {
        RequestManager.threadLocal.remove();
    }

}
