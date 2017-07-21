package com.example.interceptor;

import com.example.model.UserDO;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhang on 2017/7/17.
 */
public class CommonsInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        UserDO user = (UserDO) httpServletRequest.getSession().getAttribute("user");
        String requestURI = httpServletRequest.getRequestURI();

        if (user == null)
            modelAndView.setViewName("login");
        else {
            if ("/public".equals(requestURI) || "/edit".equals(requestURI)) {
                if (user.getUserType() != 1) {
                    modelAndView.setViewName("error");
                }
            }
        }
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
