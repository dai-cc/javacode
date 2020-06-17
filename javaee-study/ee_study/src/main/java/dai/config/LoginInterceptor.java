package dai.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    //Controller接受客户端请求，匹配到路径，并且被拦截到，进入方法前执行的逻辑
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);//传入false，意思是如果没有session不自动创建
        if(session != null){// 不等于null代表有登录
            //权限校验
            //if（校验通过）
            return true;
            //else 权限不通过，设置状态码
//          response.setStatus(HttpStatus.FORBIDDEN.value());//403
        }
        response.setStatus(HttpStatus.UNAUTHORIZED.value());//401未被授权的
        // 如果返回不成功，那就直接跳转到登录页面（通过重定向来操作）
        //response.sendRedirect("login/html");最好不要这样写
        // 因为目前项目没有设置项目部署名，这样访问可以，但是如果后期添加了项目部署名，这个网址就访问不了会报404
        /*
        当不确定地址怎么写的时候，可以把这些地址相关的东西打印一下，拼接起来就是地址
        System.out.println(request.getScheme());//打印协议：http
        System.out.println(request.getProtocol());//http版本号：http/1.2
        System.out.println(request.getServletPath());//请求的路径
        System.out.println(request.getContextPath());//空字符串
        System.out.println(request.getPathInfo());//null
        System.out.println(request.getRequestURI());//请求路径
        System.out.println(request.getRequestURL());//请求的全路径
        */
        //暂时先这样写
        response.sendRedirect("login/html");
        return false;

    }

    //Controller方法执行完，之后的逻辑
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
