package com.example.interceptor;

import com.example.model.UserDO;
import com.sun.istack.internal.NotNull;
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

    @NotNull
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, final ModelAndView modelAndView) throws Exception {
        //System.out.println("执行到了postHandle method");
        UserDO user = (UserDO) httpServletRequest.getSession().getAttribute("user");
        if (user != null) {
            String requestURI = httpServletRequest.getRequestURI();
            Integer userType = user.getUserType();
            if ("/api/delete".equals(requestURI)) {
                if (userType.equals(0)) {
                    modelAndView.setViewName("error");
                }
            }

           // System.out.println(user);
        } else {
            modelAndView.setViewName("login");
        }
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        //System.out.println("执行到了afterCompletion method");
    }
}
