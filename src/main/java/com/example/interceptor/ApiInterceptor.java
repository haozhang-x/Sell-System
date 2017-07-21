package com.example.interceptor;

import com.example.model.UserDO;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhang on 2017/7/17.
 */
public class ApiInterceptor implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        UserDO user = (UserDO) httpServletRequest.getSession().getAttribute("user");
        String requestURI = httpServletRequest.getRequestURI();
        if (user != null) {
            Integer userType = user.getUserType();
            if ("/api/delete".equals(requestURI)) {
                if (userType.equals(0)) {
                    modelAndView.setViewName("error");
                }
            }
        } else {
            if (!"/api/login".equals(requestURI)) {
                modelAndView.setViewName("login");
            }

        }
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
