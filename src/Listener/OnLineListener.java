package Listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnLineListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("有用户上线了");
        ServletContext app = event.getSession().getServletContext();

        Object obj =app.getAttribute("onLineNum");
        if (obj == null) {
            app.setAttribute("onLineNum", 1);
        } else {
            app.setAttribute("onLineNum", ((Integer)obj)+1);
        }
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("有用户下线了");
        ServletContext app = event.getSession().getServletContext();
        app.setAttribute("onLineNum",Integer.parseInt(app.getAttribute("onLineNum").toString())-1);
    }
}
