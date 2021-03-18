package date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TestDate {
    public static void main(String[] args) {
        testDate();
        testCalendar();
        testTimeZone();
        testTimestamp();
    }

    public static void testDate() {
        //* java.util.Date 是过时的旧日期API
        //* 新的日期API在 java.time 包里
        Date date = new Date();

        System.out.println("Current year: " + (date.getYear() + 1900)); // 这里必须加1900
        System.out.println("Current month: " + (date.getMonth() + 1));
        System.out.println("Current day: " + date.getDay()); // 获取星期
        System.out.println("Current date: " + date.getDate()); // 获取日
        System.out.println("Current epoch time: " + date.getTime()); // 获取从计算机创世纪以来的秒数
        System.out.println("Current time string: " + date.toString()); // 获取本地时区的日期和时间字符串
        System.out.println("Current GMT date: " + date.toGMTString()); // 获取格林威治日期和时间字符串

        //* 自定义格式输出
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // DateFormat 是抽象类
        System.out.println("Current time in yyyy-mm-dd hh:mm:ss format: " + format.format(date));

        System.out.println();
    }

    public static void testCalendar() {
        //* getInstance() 是 Calendar 类的一个静态方法
        //* 而且是唯一获取 Calendar 对象的方法
        Calendar calendar = Calendar.getInstance();

        int y = calendar.get(Calendar.YEAR);
        int m = 1 + calendar.get(Calendar.MONTH);
        int d = calendar.get(Calendar.DAY_OF_MONTH);
        int w = calendar.get(Calendar.DAY_OF_WEEK);
        int hh = calendar.get(Calendar.HOUR_OF_DAY);
        int mm = calendar.get(Calendar.MINUTE);
        int ss = calendar.get(Calendar.SECOND);
        int ms = calendar.get(Calendar.MILLISECOND);
        System.out.println("Get date from Calendar class");
        System.out.println(y + "-" + m + "-" + d + " " + w + " " + hh + ":" + mm + ":" + ss + "." + ms);

        //* 若要自己设置日期的字段，需要调用 calendar.clear() 方法
        calendar.clear();
        calendar.set(Calendar.YEAR, 2019);
        calendar.set(Calendar.MONTH, 8); // 设置9月:注意8表示9月
        calendar.set(Calendar.DATE, 2); // 设置2号
        calendar.set(Calendar.HOUR_OF_DAY, 21);
        calendar.set(Calendar.MINUTE, 22);
        calendar.set(Calendar.SECOND, 23);
        System.out.println("Set new date and time from Calendar");
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()));

        calendar.add(Calendar.MONTH, 1); // 对日期进行加减，此处为增加一个月
        System.out.println("Add 1 month to the date: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()));
        System.out.println();
    }

    public static void testTimeZone() {
        TimeZone tzDefault = TimeZone.getDefault(); // 获取当前时区
        TimeZone tzGMT8 = TimeZone.getTimeZone("GMT+9:00"); // 获取 GMT+9 时区
        TimeZone tzSyd = TimeZone.getTimeZone("Australia/Sydney"); // 获取悉尼时区

        System.out.println("Default timezone: " + tzDefault.getID());
        System.out.println("Default timezone: " + tzGMT8.getID());
        System.out.println("Default timezone: " + tzSyd.getID());
        System.out.println();

        // 设置时区进行转换
        // 将当前北京时间转换为悉尼时间
        Calendar currentCal = Calendar.getInstance(); // 获取当前时区的当前时间
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current time in current timezone: " + dateFormat.format(currentCal.getTime()));

        dateFormat.setTimeZone(tzSyd); // 传入悉尼时区
        System.out.println("Current time in Sydney timezone: " + dateFormat.format(currentCal.getTime()));
        System.out.println();
    }

    public static void testTimestamp () {
        //* Java 中时间戳以 Instant 类型表示，可以与 Long 互相转换
        // 类比 Python 的 time.time()
        Instant now = Instant.now();
        System.out.println("Current time number in seconds: " + now.getEpochSecond());
        System.out.println("Current time number in miliseconds: " + now.toEpochMilli());
        System.out.println();
    }
}
