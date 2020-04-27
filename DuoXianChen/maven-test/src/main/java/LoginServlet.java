import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码及响应的编码，响应的数据类型
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        //加入请求数据为username=xxx&password=xxx
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //获取URI的路径：/login
        System.out.println("servletpath:"+ req.getServletPath());
        //获取项目的部署名：
        System.out.println("contextpath："+req.getContextPath());
 //       PrintWriter pw = resp.getWriter();

        //分析转发和重定向的区别
        //登陆成功，重定向到首页
        if("admin".equalsIgnoreCase(username) && "666".equalsIgnoreCase(password)){
//            pw.println("<p>登录成功</p>");
            //request.getSession(boolean create)
            //从请求对象获取一个Session对象，如果获取不到，根据create决定是否创建
            //create = true 创建一个session对象
            //create = false 不创建，返回null
            //request.getSession()相当于request.getSession(true)
            HttpSession session = req.getSession();
            session.setAttribute("user","username="+username);
            //登陆成功之后让他跳转到main界面
            //方法1：重定向
            resp.sendRedirect(req.getContextPath() + "/main.html");
            //resp.sendRedirect("https://www.baidu.com");//也可以重定向到别人的网页，不一定是自己项目内的


        }else {
//            pw.println("<p>用户名密码错误，登录不成功</p>");
            //方法2：转发
            req.getRequestDispatcher("/error.html").forward(req,resp);
        }
//        pw.flush();
    }
}
