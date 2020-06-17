package dai.controller;

import dai.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/1")
public class LoginController {

    /*
    * 两个页面，login.html和index.html，哪些url能够访问
    * 每个url访问的时候，是否时转发的？
    * http://localhost:8080/login login.html 转发
    * http://localhost:8080/login.html 访问的是....
    *
    * localhost:8080 访问的时index.html 访问方式时转发
    * http://localhost:8080/index.html 访问的是index.html 转发
    *
    *
    * */
    @RequestMapping(value = "/login")
    public String login(Integer i){
        if(i==1)
            // 如果传进来的是1就进行重定向
            return "redirect:/index.html";
        else
            //否则进行转发
            return "forward:/login.html";
    }

    @RequestMapping(value = "/login2",method = RequestMethod.POST)
    @ResponseBody
    public Object login2(@RequestParam("username") String username1,
                         String password,String password2){
        System.out.println(username1+"="+password+","+password2);
        User user = new User();
        user.setUsername("烤鸭");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }

    @RequestMapping(value = "/login3",method = RequestMethod.POST)
    @ResponseBody
    public Object login3(User u){
        System.out.println(u);
        User user = new User();
        user.setUsername("烤鸭");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }

    @RequestMapping(value = "/login4",method = RequestMethod.POST)
    @ResponseBody
    public Object login4(@RequestBody User u){
        System.out.println(u);
        User user = new User();
        user.setUsername("烤鸭");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }

/*    @RequestMapping(value = "/login5",method = RequestMethod.POST)
    @ResponseBody
    public Object login5(HttpServletRequest request,
                         HttpServletResponse response,
                         @RequestBody User u){
        //模拟登录
        if("abc".equals(u.getUsername())
                && "123".equals(u.getPassword())){
            HttpSession session = request.getSession();
            session.setAttribute("user",u);
        }
        User user = new User();
        user.setUsername("烤鸭");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }*/

    @RequestMapping(value = "/login5",method = RequestMethod.POST)
    @ResponseBody
    // 为了方便写前端页面，把@RequestBody去掉
    public Object login5(HttpServletRequest request,
                         HttpServletResponse response,
                         User u){
        //模拟登录
        if("abc".equals(u.getUsername())
                && "123".equals(u.getPassword())){
            HttpSession session = request.getSession();
            session.setAttribute("user",u);
            User user = new User();
            user.setUsername("烤鸭");
            user.setPassword("123");
            user.setBirthday(new Date());
            return user;
        }
        // 如果用户名或密码不通过，抛异常处理
        throw new RuntimeException("登录不成功");
    }

    @RequestMapping(value = "/{type}/login6",method = RequestMethod.POST)
    @ResponseBody
    // @PathVariable 根据路径变量进行映射
    public Object login6(@PathVariable("type") String type){
        //System.out.println(type);
        // 比如说网址是http://localhost:8080/1/abc/login6，此处就会控制台就会打印abc
        User user = new User();
        user.setUsername("烤鸭");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }
}
