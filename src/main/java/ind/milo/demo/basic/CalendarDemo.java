package ind.milo.demo.basic;

import java.util.Calendar;

/**
 * @Date 2023/5/11 13:54
 * @Created by Milo
 */
public class CalendarDemo {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        int month = calendar.get(Calendar.MONTH); // start with zero
        int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        calendar.add(Calendar.DAY_OF_YEAR, 7);

        System.out.println();

    }
}
