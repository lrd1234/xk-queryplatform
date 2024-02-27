package com.qp.accessControl;

import com.qp.role.mapper.RoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;


//交给spring管理
@Component
//标识切面
@Aspect
@Slf4j
public class Section {

    @Autowired
    private RoleMapper roleMapper;
    // 以自定义 @SectionNote 注解为切点,就是使用了自定以注解SectionNote的方法会切入
    @Pointcut("@annotation(com.qp.accessControl.SectionNote)")
    public void sectionNote(){}


    @Around("sectionNote() && @annotation(sectionNote)")
    public AjaxResponse  doAround(ProceedingJoinPoint joinPoint,SectionNote sectionNote) {
        log.info("进入AOP切面");
        //获取切面参数
        String sectionNoteInfo = getSectionNoteInfo(joinPoint);
        log.info("获取切面参数：{}",sectionNoteInfo);
        //获取用户权限
        String userRole = getUserRole();
        log.info("获取用户权限userRole：{}",userRole);
        //判断是否有权限 1有 -1 没有
        int i = accessControl(sectionNoteInfo,userRole );
        if(i==1){
            //有权限,执行方法
            try {
                return AjaxResponse.success(joinPoint.proceed());
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                return AjaxResponse.error("访问的内容出错");
            }
        }else{
            //没有权限,返回错误码
            return AjaxResponse.error("没有权限操作此内容");
        }
    }


    /**
     * 获取注解信息
     *
     * @param joinPoint
     * @return
     * @throws Exception
     */
    public String getSectionNoteInfo(JoinPoint joinPoint) {
        // 获取切入点的目标类
        Class<?> aClass = joinPoint.getTarget().getClass();
        String targetName = joinPoint.getTarget().getClass().getName();
        Class<?> targetClass = null;
        try {
            targetClass = Class.forName(targetName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 获取切入方法名
        String methodName = joinPoint.getSignature().getName();
        log.info("切入方法名,methodName:{}",methodName);
        // 获取切入方法参数
        Object[] arguments = joinPoint.getArgs();
        // 获取目标类的所有方法
        Method[] methods = targetClass.getMethods();
        for (Method method : methods) {
            // 方法名相同、包含目标注解、方法参数个数相同（避免有重载）
            if (method.getName().equals(methodName) && method.isAnnotationPresent(SectionNote.class)
                    && method.getParameterTypes().length == arguments.length) {
                return method.getAnnotation(SectionNote.class).value();
            }
        }
        return "";
    }

    /**
     * 获取用户权限
     * */
    public String getUserRole(){
        //获取request
        HttpServletRequest request = ServletUtils.getRequest();
        //获取token
        String accessToken = request.getHeader("accessToken");
        //获取用户id
        //String userId = JwtUtil.getUserInfo(accessToken,"userId");
        String userId = request.getHeader("userId");
        log.info("获取得用户id为：{}",userId);
        //获取用户的角色
       String role = roleMapper.getUserRoleUserId(userId);
       log.info("查询数据库返回结果：{}",role);
        return role;
    }

    /**
     * 判断是否有权限
     * @param sectionNoteInfo 注解上的值
     * @param userRole 用户的权限
     * */
    public int accessControl(String sectionNoteInfo,String userRole){
        //判断是否符合权限
        if (sectionNoteInfo.equals(userRole)) {
            //执行方法
            return 1;
        }
        return -1;

    }
}

