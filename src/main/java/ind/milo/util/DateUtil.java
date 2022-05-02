package ind.milo.util;



import com.sun.jmx.snmp.Timestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    private DateUtil() {
    }

    public static void main(String[] args) {
        // https://www.jianshu.com/p/048ee8580639
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
        // 2022-04-10
        // 16:47:31.807
        // 2022-04-10T16:47:31.807

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String format = localDateTime.format(formatter2);
        System.out.println(format);

        // 时间戳：一般没有设计算法的时间戳是10位，以格林威治时间1970年01月01日00时00分00秒
        // (北京时间1970年01月01日08时00分00秒)起至现在的总秒数。加出来是10位
        String name=String.valueOf(Calendar.getInstance().getTimeInMillis());
        // 此种方法生成的时间戳为13位，那是因为在前10位后添加了3位的随机数。
        System.out.println(name);
        System.out.println(System.currentTimeMillis());

        Timestamp createTime = new Timestamp(new Date().getTime());


    }



}
