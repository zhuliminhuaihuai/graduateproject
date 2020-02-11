package com.project.controller.common.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;


@Slf4j
public class AuthorityInterceptor implements HandlerInterceptor{

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

        if(StringUtils.equals(className,"UserController")){
            if(StringUtils.equals(methodName,"login")||StringUtils.equals(methodName,"tokenCodeV1")||StringUtils.equals(methodName,"validateToken")) {
                log.info("权限拦截器拦截到请求,className:{},methodName:{}", className, methodName);
                //如果是拦截到登录请求，不打印参数，因为参数里面有密码，全部会打印到日志中，防止日志泄露
                return true;
            }
        }
//        if(StringUtils.equals(className,"UserManageController") && StringUtils.equals(methodName,"login")){
//            log.info("权限拦截器拦截到请求,className:{},methodName:{}",className,methodName);
//            //如果是拦截到登录请求，不打印参数，因为参数里面有密码，全部会打印到日志中，防止日志泄露
//            return true;
//        }
//        if(StringUtils.equals(className,"UserManageController") && StringUtils.equals(methodName,"tokenCodeV1")){
//            log.info("权限拦截器拦截到请求,className:{},methodName:{}",className,methodName);
//            //如果是拦截到登录请求，不打印参数，因为参数里面有密码，全部会打印到日志中，防止日志泄露
//            return true;
//        }
//        if(StringUtils.equals(className,"UserManageController") && StringUtils.equals(methodName,"validateToken")){
//            log.info("权限拦截器拦截到请求,className:{},methodName:{}",className,methodName);
//            //如果是拦截到登录请求，不打印参数，因为参数里面有密码，全部会打印到日志中，防止日志泄露
//            return true;
//        }
        log.info("权限拦截器拦截到请求,className:{},methodName:{},param:{}",className,methodName,requestParamBuffer.toString());


      /*  Users users ;

        HttpSession session = request.getSession();
        users = (Users)session.getAttribute(Const.ManagerToken.SESSION);


        if(users == null || ((users.getRole().intValue()<1) ||(users.getRole().intValue()>5))){
            response.sendRedirect("http://www.ygmall.com:8080/manage/user/login.html");
//            ?redirect=" + request.getRequestURL()
//            out.flush();
//            out.close();//这里要关闭

            return false;

        }*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion");
    }
}
