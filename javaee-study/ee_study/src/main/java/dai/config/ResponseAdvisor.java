package dai.config;

import dai.model.Response;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;



@ControllerAdvice
public class ResponseAdvisor implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        //supports返回true表示响应数据时，先执行beforeBodyWrite，false则不执行
        // 获取请求方法对象，判断Controller方法上是否有@ResponseBody
        return returnType.getMethod().getAnnotation(ResponseBody.class) != null;
    }
    // body位请求方法执行完之后，返回的对象
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        Response resp = new Response();
        resp.setSuccess(true);
        resp.setData(body);
        return resp;
    }
}
