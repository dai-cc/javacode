package dai.test;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Date;

// @ServerEndpoint来修饰指定的类，同时再注解中使用value参数来指定一个具体的路径
// 后续html页面就可以通过这个路径来访问到服务器
// 这个注解的功能就类似于web.xml中配置的映射关系
// 服务器处理连接的代码
@ServerEndpoint(value="/webSocketTest")
public class WebsocketDemo {

    // 这几个方法都是服务器在合适的时机自动调用的，不需要用户手动来调用（类似于Servlet里的doGet,doPost方法一样）
    // 这几个方法名字叫什么无所谓，主要是使用指定的注解修饰

    @OnOpen
    public void onOpen(Session session){// 这里的Session和HttpSession(servlet中的)不是同一个对象，但是作用类似，都是每次有客户端连上服务器，就会由服务器创建一个session对象
        // 将会再客户端建立连接时被调用
        System.out.println("建立连接");

        // 创建一个专门的线程，来源源不断地写回数据
        Thread t = new Thread(){
          @Override
          public void run(){
              while(true){
                  try {
                      // 每秒钟返回一条客户端你好
                      session.getBasicRemote().sendText("客户端你好"+new Date());
                      Thread.sleep(1000);
                  } catch (InterruptedException | IOException e) {
                      e.printStackTrace();
                  }
              }
          }
        };
        t.start();
    }

    @OnClose
    public void onClose(){
        //客户端断开连接时调用
        System.out.println("断开连接");
    }

    @OnMessage
    public void onMessage(String message,Session session) throws IOException {
        // 在服务器收到客户端的请求时调用
        System.out.println("收到消息："+message);
        // 收到消息，就给客户端返回一个数据
        session.getBasicRemote().sendText("我收到了");
    }

    @OnError
    public void onError(Session session,Throwable error){
        //连接意外终止时，就会调用onError方法
        System.out.println("连接出现错误！");
        error.printStackTrace();
    }
}
