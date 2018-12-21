package com.wx.wlcx.utils;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {

    public static Boolean isStaticResourceRequest(HttpServletRequest request) {
        Boolean result = Boolean.FALSE;
        String requestURI = request.getRequestURI();
        if (requestURI.contains("/js") || requestURI.endsWith(".js")) {
            result = Boolean.TRUE;
        }
        if (requestURI.contains("/css") || requestURI.endsWith(".css")) {
            result = Boolean.TRUE;
        }
        if (requestURI.contains("/html") || requestURI.endsWith(".html")) {
            result = Boolean.TRUE;
        }
        if (requestURI.contains("/image") || requestURI.contains("/images")) {
            result = Boolean.TRUE;
        }
        return result;
    }
}
