package dai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 扫描接口类，接口上加有@Mapper注解的，都会通过Mybatic框架生成代理类
@MapperScan(basePackages = "dai.mapper")

public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
