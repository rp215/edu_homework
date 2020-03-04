package date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author：renpeng
 * @date：2019/3/8
 */
public class CalenderDemo {

    public static void main(String[] args) {
        String startTime="";
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date curDate = new Date(System.currentTimeMillis());
        System.out.println(curDate);
        String endTime=sf.format(curDate)+" 23:59:59";//当前时间
//        startTime = sf.format(curDate)+" 00:00:00";

//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 6);
//        Date today = calendar.getTime();
//        startTime = sf.format(today)+" 00:00:00";

        Calendar calendar=Calendar.getInstance();
        Date theDate=calendar.getTime();
        GregorianCalendar gcLast=(GregorianCalendar)Calendar.getInstance();
        gcLast.setTime(theDate);
        //设置为第一天
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        startTime=sf.format(gcLast.getTime())+" 00:00:00";

        System.out.println(startTime);
        System.out.println(endTime);
    }

}
