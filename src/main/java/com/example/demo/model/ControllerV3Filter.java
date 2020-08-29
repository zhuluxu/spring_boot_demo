package com.example.demo.model;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author zhuluxu
 * @date  v3拦截，参数处理
 **/
@WebFilter(filterName = "controllerV3Filter", urlPatterns = "/v3/*")
public class ControllerV3Filter implements Filter {

    private static final String PROJECT_ID_KEY = "projectId";

    private static final String OWNER_KEY= "owner";

    private static final String DEPARTMENT_CODE_KEY= "departmentCode";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
