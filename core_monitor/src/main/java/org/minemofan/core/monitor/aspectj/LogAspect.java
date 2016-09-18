package org.minemofan.core.monitor.aspectj;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.minemofan.core.service.demo.IDemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * Created on 2015-04-01
 * <p>Title:       日志切面</p>
 * <p>Description: 执行顺序：Around >> After  >> </p>
 * <p>Copyright:   Copyright (c) 2015</p>
 * <p>Company:     平安金融科技咨询有限公司</p>
 * <p>Department:  科技中心研发部</p>
 * @author         mosh
 * @version        1.0
 */
@Component
@Aspect
public class LogAspect {
	
	private static Logger log = LoggerFactory.getLogger(LogAspect.class);
	
	@Autowired
	private IDemoService demoService;
	
	
	/**
     * Title 环绕触发
     * Description 
     * @author mosh
     * @param pjp
     * @return Objects
     * @throws Throwable
     */
    @Around("execution(* org.minemofan.core.web.demo.AspectController.*(..)) "
    		+ "|| execution(* org.minemofan.core.facade.demo.AspectFacade.*(..))")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
    	
    	log.info("LogAspect-------------doAround   Begin!");
    	try{ 
    		//1.获取request信息  jsonStr
    		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
    		log.debug("LogAspect---doAround---RequestAttributes:{}。", requestAttributes);
    		
    		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
    		log.debug("LogAspect---doAround---ServletRequestAttributes:{}。", servletRequestAttributes);
    		
    		HttpServletRequest request = servletRequestAttributes.getRequest();
    		log.debug("LogAspect---doAround---HttpServletRequest:{}。", request);
    		
    		Map map = request.getParameterMap();
    		log.debug("-----------"+ map.keySet());
    		log.debug("-----------"+ map.get("jsonStr"));
    		log.debug("-----------"+ map.get("jsonStr").toString());
    		
    		//2.根据request获取session
    		HttpSession session = request.getSession();
    		log.debug("LogAspect---doAround---HttpSession,ID:{},OBJ:{}。", session.getId(), session);
    		
    		//3.从session中取出登录用户信息
    	 
    	
    		
    	}catch(Exception e){
    		log.error("切面异常！LogAspect:{}。", e.getMessage());
    		log.debug("切面异常！LogAspect:{}。", e);
    		throw new Exception(e);
    	}
    	 
         log.info("LogAspect-------------doAround   End!");
    	return null;
    }
    
    
    /** 
     * Title	doBefore
     * Description: 方法调用前触发  
     *  记录开始时间  
     * @author mosh  
     * @param joinPoint 
     */ 
    @Before("execution(* org.minemofan.core.web.demo.AspectController.*(..))")  
    public void doBefore(JoinPoint joinPoint) {  
        log.info("LogAspect-------------doBefore   Begin!");
        
        log.info("LogAspect-------------doBefore   End!");
    }   
    
    
    /** 
     *  
     * @Title：doAfterInServiceLayer 
     * @Description: 方法调用后触发  
     *  记录结束时间 
     * @author shaojian.yu  
     * @date 2014年11月2日 下午4:46:21 
     * @param joinPoint 
     */  
    @After("execution(* org.minemofan.core.web.demo.AspectController.*(..))")  
    public void doAfter(JoinPoint joinPoint) {  
    	 log.info("LogAspect-------------doAfter   Begin!");
         
         log.info("LogAspect-------------doAfter   End!");
    }  
    
    
	
    
    
    
    
    /*
    @Around("execution(* com.yusj.controller..*.*(..))")  
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {  
        
         * 1.获取request信息 
         * 2.根据request获取session 
         * 3.从session中取出登录用户信息 
          
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();  
        ServletRequestAttributes sra = (ServletRequestAttributes)ra;  
        HttpServletRequest request = sra.getRequest();  
        // 从session中获取用户信息  
        String loginInfo = (String) session.getAttribute("username");  
        if(loginInfo != null && !"".equals(loginInfo)){  
            userName = operLoginModel.getLogin_Name();  
        }else{  
            userName = "用户未登录" ;  
        }  
        // 获取输入参数  
        inputParamMap = request.getParameterMap();  
        // 获取请求地址  
        requestPath = request.getRequestURI();  
          
        // 执行完方法的返回值：调用proceed()方法，就会触发切入点方法执行  
        outputParamMap = new HashMap<String, Object>();  
        Object result = pjp.proceed();// result的值就是被拦截方法的返回值  
        outputParamMap.put("result", result);  
          
        return result;  
    }  */
    
    
    @AfterReturning(pointcut="execution(* org.minemofan.core.web.demo.AspectController.*(..))", 
            returning="returnValue")
    public void doAfterReturning(JoinPoint point, Object returnValue) {
    	log.info("LogAspect-------------doAfterReturning   Begin!");
        
        log.info("LogAspect-------------doAfterReturning   End!");
             
        }
}
