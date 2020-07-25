package dai.config;

import dai.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Date;

@Configuration
public class Myconfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截器
        registry.addInterceptor(new LoginInterceptor())//所有匹配的路径，都会进入拦截器
                .addPathPatterns("/1/**")//**代表所有子路径*只屏蔽一级路径，所有/1//**的子路径都被拦截到了
                .excludePathPatterns("/1/login5");//此处从被拦截到的路径中排除掉/1/login5
    }

    @Bean
    public User user1(){
        // 定义了一个名称为方法名user1的user对象，并注入到容器中
        User user = new User();
        user.setUsername("烤鸭1");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }

    @Bean
    public User user2(@Qualifier("user1") User user1){
        // 定义了一个名称为方法名user1的user对象，并注入到容器中
        // 注意这个@Qualifier("user1") User user1在启动的时候就会执行，
        // 所以此处的打印在启动日志里找
        System.out.println(user1);//检验看有没有注入成功
        // debug之后再启动日志中打印User(username=烤鸭1, password=123, birthday=Thu Jun 18 20:18:49 GMT+08:00 2020)
        User user = new User();
        user.setUsername("烤鸭2");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }
}
