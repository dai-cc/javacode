package dai.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Response {
    private boolean success;// 操作是否成功
    private String code;//抛异常时候的错误码
    private String message;//错误信息
    private String stackTrace; // 堆栈信息
    private Object data;//数据
}
