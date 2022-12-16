package ind.milo.demo.time;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;

@Slf4j
public class TimeDemo {
    @Test
    public void now() {
        Instant now = Instant.now();
        System.out.println(now);
        Instant plusSeconds = now.plusSeconds(60);
        System.out.println(plusSeconds);

        Duration between = Duration.between(now, plusSeconds);
        System.out.println(between.toMinutes());
    }

    @Test
    public void date() {
        LocalDate now = LocalDate.now();
        log.info(String.valueOf(now));

        LocalDate date = LocalDate.of(2014, 1, 1).plusDays(255);
        log.info(String.valueOf(date));

    }

    @Test
    public void newTime() {
        LocalTime localTimeA = LocalTime.of(0, 0,10);
        LocalDate localDateA = LocalDate.of(2022,12,15);
        LocalDateTime before = LocalDateTime.of(localDateA, localTimeA);
        System.out.println(before);

        LocalDateTime now = LocalDateTime.of(2022, 12, 16, 16, 12, 10);
        System.out.println(now);

        Duration between = Duration.between(before, now);

        System.out.println(between);
        System.out.println(between.toMillis()>0);

        now = LocalDateTime.now();
        int year = now.getYear();
        Month month = now.getMonth();
        int day = now.getDayOfMonth();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();



    }

    @Test
    public void DateTimeFormatterDemo(){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.parse("20230706", dateFormatter);
        System.out.println(date);

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HHmmss");
        LocalTime time = LocalTime.parse("000000", timeFormatter);
        System.out.println(time);

        LocalDateTime dateTime = LocalDateTime.of(date, time);
        System.out.println(dateTime);

        System.out.println(String.format("%06d", 0));
        System.out.println(String.format("%06d", 1));
        System.out.println(String.format("%06d", 12));
        System.out.println(String.format("%06d", 123));
        System.out.println(String.format("%06d", 1234));
        System.out.println(String.format("%06d", 12345));
        System.out.println(String.format("%06d", 123456));
        System.out.println(String.format("%06d", 1234567));
    }


    @Test
    public void test2(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String format = now.format(dateFormatter);
        System.out.println(format);

        LocalDate localDateA = LocalDate.of(2022,12,15);
        LocalTime localTimeA = LocalTime.of(0, 9,10);
        LocalDateTime dateTime = LocalDateTime.of(localDateA, localTimeA);

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HHmmss");
        String format1 = dateTime.format(timeFormatter);
        System.out.println(format1);
        System.out.println(Integer.parseInt(format1));
    }
}
