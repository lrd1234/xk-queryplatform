package com.qp.accessControl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 自定义token拦截器
 * 继承HandlerInterceptor拦截器，重写preHandle方法
 * 重写preHandle方法后，每次请求都会走这个方法验证token
 * */
@Component
@Slf4j
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        //放行
        log.info("开始验证token:request:{},response:{},handler:{}",request,response,handler);
        //如果该方法包括该注解ReleaseToken，不需要token
       // HandlerMethod handlerMethod = (HandlerMethod) handler;
       // Method method = handlerMethod.getMethod();
        //被ReleaseToken标记的扫描
       // ReleaseToken methodAnnotation = method.getAnnotation(ReleaseToken.class);
       // if (methodAnnotation != null) {
            return true;
       // }

        //设置编码
      //  response.setCharacterEncoding("utf-8");
        //获取token
      //  String token = request.getHeader("accessToken");
        //判断token是否存在
      /*  if(null!=token){
            //token存在，验证token是否符合加密规则
            boolean verify = JwtUtil.verify(token);
            if(verify){
                //验证token中的信息是否正确
                String userId = JwtUtil.getUserInfo(token, "userId");
                //和登录的用户名和用户id比较是否相等（这里我是在登录的时候吧用户信息加到请求头中了，你也可以用数据库判断）
                String userId1 = request.getHeader("userId");
                assert userId != null;
                if(userId.equals(userId1)){
                    //验证成功，在请求头中加入相关信息
                    response.setHeader("accessToken",token);
                    //将用户id放到请求头中
                    response.setHeader("userId",userId);
                    return true;
                }
            }
        }*/
        //token不存在或验证返回false
       // return true;  //这里先返回true，到具体线上，需要验证token之后
    }
}

