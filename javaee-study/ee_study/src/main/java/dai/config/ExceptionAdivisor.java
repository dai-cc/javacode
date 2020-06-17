package dai.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 统一的异常处理
* */


//Controller中，所有处理客户端请求的方法，抛异常都会进入异常处理逻辑

@ControllerAdvice

public class ExceptionAdivisor {


    /*

    @ExceptionHandler(Exception.class)
    @ResponseBody
    // 返回的是jession数据格式
    public Object handle(Exception e){//Controller方法抛出的异常，会注入到请求参数中
        Map<String,String> map = new HashMap<>();
        map.put("error",e.getMessage());
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        map.put("stackTrace",sw.toString());
        return map;
    }
*/

    @ExceptionHandler(Exception.class)
    public String handle(HttpServletResponse response){//Controller方法抛出的异常，会注入到请求参数中
        try {
            response.sendRedirect("/error.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
