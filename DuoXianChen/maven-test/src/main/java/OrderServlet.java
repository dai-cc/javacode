import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        //用户身份校验
        //设为false，如果此时登录了，就有session对象，此时就可以获取到已有的session对象
        HttpSession session = req.getSession(false);
        if (session == null) {
            //说明此时没有登录
            resp.sendRedirect(req.getContextPath() + "/index.html");
        } else {
            PrintWriter pw = resp.getWriter();
            pw.println("<h2>已经登录，可以访问订单</h2>");
            pw.flush();
        }
    }
}

