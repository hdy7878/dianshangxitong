package Listener;

import until.TimeHelper;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Timer;
import java.util.TimerTask;

public class MyListener implements ServletContextListener {
    private Timer timer;
    private  MyTask myTask;
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("定时开始了");
        timer=new Timer();
       myTask=new MyTask();
       timer.schedule( myTask,0,5000);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        timer.cancel();
        System.out.println("定时结束了");
    }
}
class MyTask extends TimerTask{
    public void run(){
        System.out.println(TimeHelper.getTime());
    }

}

