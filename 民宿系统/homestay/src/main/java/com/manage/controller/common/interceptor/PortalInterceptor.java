package com.manage.controller.common.interceptor;

import com.manage.common.Const;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

@Slf4j
public class PortalInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle");
        //请求中Controller中的方法名
        HandlerMethod handlerMethod = (HandlerMethod)handler;

        //解析HandlerMethod

        String methodName = handlerMethod.getMethod().getName();
        String className = handlerMethod.getBean().getClass().getSimpleName();

        //解析参数,具体的参数key以及value是什么，我们打印日志
        StringBuffer requestParamBuffer = new StringBuffer();
        Map paramMap = request.getParameterMap();
        Iterator it = paramMap.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry entry = (Map.Entry)it.next();
            String mapKey = (String)entry.getKey();

            String mapValue = StringUtils.EMPTY;

            //request这个参数的map，里面的value返回的是一个String[]
            Object obj = entry.getValue();
            if(obj instanceof String[]){
                String[] strs = (String[])obj;
                mapValue = Arrays.toString(strs);
            }
            requestParamBuffer.append(mapKey).append("=").append(mapValue);
        }
        log.info("权限拦截器拦截到请求,className:{},methodName:{},param:{}",className,methodName,requestParamBuffer.toString());

      /*  Users users ;

        HttpSession session = request.getSession();
        users = (Users)session.getAttribute(Const.Token.SESSION);


        if(users == null){
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=utf-8");
            PrintWriter out;
            JSONObject res = new JSONObject();
            res.put("status","1");
            res.put("msg","未登录");
            out=response.getWriter();
            out.append(res.toString());
            //response.sendRedirect("http://www.ygmall.com:8080/user/userLogin.html");
            return false;
        }*/
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
