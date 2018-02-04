package service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;

import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;

/**
 * Created by Administrator on 2018/2/3 0003.
 */
public class WebServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user=req.getParameter("user");
        System.out.println("-------user-----------"+user);
        String name=new String(user.getBytes("iso8859-1"), "utf-8");
        System.out.println("----------------"+name);
        resp.getWriter().write("你好："+name);
    }

    public static  void main(String[] args) throws MalformedURLException {
        Service service = new ObjectServiceFactory().create(IgetCKXX.class);
        XFireProxyFactory factory = new XFireProxyFactory(XFireFactory
                .newInstance().getXFire());
        String url = "http://localhost:8080/services/getCKXX";
        IgetCKXX igetCKXX = (IgetCKXX) factory.create(service,url);
        System.out.println("------------------------"+igetCKXX.getCKXX("t_user"));
    }
}
