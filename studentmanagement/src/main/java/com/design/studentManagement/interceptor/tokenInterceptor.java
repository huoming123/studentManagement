package com.design.studentManagement.interceptor;

import com.design.studentManagement.pojo.res.RestFulBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
public class tokenInterceptor implements HandlerInterceptor {
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (!request.getRequestURI().equals("/login")&&!request.getRequestURI().equals("/profession/get/list")&&!request.getRequestURI().equals("/users/add")&&!request.getRequestURI().equals("/users/upload/image")) {
            response.setContentType("text/html; charset=UTF-8");
            if (RequestMethod.OPTIONS.name().equals(request.getMethod())) {
                return true;
            }
            //根据token里面的值验证token是否登陆过
            String token = request.getHeader("Authorization");
            //验证token是否为空
            if (token.equals("null")) {
                //证明需要登录或者超时
                RestFulBean<Object> res = RestFulBean.error(4000, "你已退出，请重新登录", null);
                //loginService.clear(request);
                response.getWriter().write(objectMapper.writeValueAsString(res));
                return false;
            }
        }
        return true;
    }

}
