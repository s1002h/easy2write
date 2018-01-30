package com.gezida.easy2write.sys.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.gezida.easy2write.common.service.BaseService;

/**
 * 权限拦截器
 * @author Tangbinqi
 * @version 2017-8-16
 */
public class AuthInterceptor extends BaseService implements HandlerInterceptor {

	
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 * 在执行action里面的处理逻辑之前执行，它返回的是boolean，这里如果我们返回true在接着执行postHandle和afterCompletion，如果我们返回false则中断执行。
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler) throws Exception {
		
		String requestUri = request.getRequestURI();  request.getRemoteAddr();
        String contextPath = request.getContextPath();  
        String url = requestUri.substring(contextPath.length());  
        
        logger.info("requestUri:"+requestUri);    
        logger.info("contextPath:"+contextPath);    
        logger.info("url:"+url);   
        logger.info("ip:"+getRemoteHost(request));
        
        //Controller的RequestMapping时
        if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
        	//先拿shiro的注解
        	RequiresPermissions requiresPermissions = ((HandlerMethod) handler).getMethodAnnotation(RequiresPermissions.class);
            
            //没有声明需要权限,或者声明不验证权限
            if(requiresPermissions == null /* || requiresPermissions.value().length == 0 */)
                return true;
            else{   
            	//1.需要鉴权的，首先检查用户是否存在  TODO 建议使用redis存储会话
            	String username =  (String)request.getSession().getAttribute("user");   
                if(username == null){  
                	logger.info("AuthInterceptor：跳转到login页面！");  
                	logger.info("request.getRequestDispatcher(\"/login\").forward(request, response); \r\n return false;");
                    return true;  
                }
                //返回状态码方式
                response.sendError(505, "Not Auth");
                //2.该用户拥有权限跟URL匹配或跟requiresPermissions.value()匹配
                logger.info("request.getRequestDispatcher(\"/login\").forward(request, response); \r\n return false;");
                //在这里实现自己的权限验证逻辑
                if(false)//如果验证成功返回true（这里直接写false来模拟验证失败的处理）
                    return true;
                else//如果验证失败
                {
                    
                    return false;
                }       
            }
        }
        else
            return true;  
        
        
	}
	
	
	public String getRemoteHost(HttpServletRequest request){
		String ip = request.getHeader("x-forwarded-for");
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			ip = request.getHeader("Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			ip = request.getRemoteAddr();
		}
		return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 * 在执行action里面的逻辑后返回视图之前执行
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, 
			ModelAndView modelAndView) throws Exception {
//		if (modelAndView != null){
//			logger.info("ViewName: " + modelAndView.getViewName());
//		}
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 * 在action返回视图后执行。
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
			Object handler, Exception ex) throws Exception {
		
	}

}
