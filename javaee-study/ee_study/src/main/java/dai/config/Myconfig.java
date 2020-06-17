package dai.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Myconfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截器
        registry.addInterceptor(new LoginInterceptor())//所有匹配的路径，都会进入拦截器
                .addPathPatterns("/1/**")//**代表所有子路径*只屏蔽一级路径，所有/1//**的子路径都被拦截到了
                .excludePathPatterns("/1/login5");//此处从被拦截到的路径中排除掉/1/login5
    }
}
