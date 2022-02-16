package com.ethen.inventory.interceptor;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ethenyang@126.com
 * @since 2022/02/16
 */
public class PrintInterceptor implements HandlerInterceptor, EnvironmentAware {
    private Environment env;

    @Override
    public void setEnvironment(Environment env) {
        this.env = env;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String port = env.getProperty("server.port");

        System.err.println("@@port=" + port + "被请求啦\n" + request.getRequestURL().toString());

        return true;
    }
}
