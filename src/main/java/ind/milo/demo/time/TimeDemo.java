package ind.milo.demo.time;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.*;

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
//        DayOfWeek.FRIDAY
    }
}
