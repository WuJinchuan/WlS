package com.wx.wlcx.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@Order(1)
@WebFilter(filterName = "h5URLRewriteFilter", urlPatterns = "/h5/*")
public class H5URLRewriteFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String uri = httpServletRequest.getRequestURI();

        if (!Pattern.matches(".+\\..+$", uri)) {
            ((HttpServletResponse) response).setHeader("Cache-Control", "no-cache, no-store, max-age=0, must-revalidate");
            httpServletRequest.getRequestDispatcher("/h5/index.html").forward(request, response);;
        } else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
