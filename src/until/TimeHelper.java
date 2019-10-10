package until;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeHelper {
   public static String getTime() {
       Date date = new Date();
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       return format.format(date);
   }
    public static String getTime2() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssms");
        return format.format(date);
    }
}
