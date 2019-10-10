package Listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class LoginListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("有人登录了");
        ServletContext app = event.getSession().getServletContext();
        Object obj=app.getAttribute("loginNum");
        if(obj==null){
            app.setAttribute("loginNum",1);
        }else{
            app.setAttribute("loginNum",((Integer)obj)+1);
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("有人退出了");
        ServletContext app = event.getSession().getServletContext();
        Object obj=app.getAttribute("loginNum");
        if(obj!=null){

            app.setAttribute("loginNum",((Integer)obj)-1);
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
}
