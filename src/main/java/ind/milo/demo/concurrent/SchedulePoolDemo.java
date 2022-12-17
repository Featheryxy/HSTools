package ind.milo.demo.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SchedulePoolDemo {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        System.out.println("now: "+LocalDateTime.now());
        // 添加两个任务，希望它们都在 1s 后执行
        executor.schedule(() -> {
            System.out.println("任务1，执行时间：" + LocalDateTime.now());
            try { Thread.sleep(2000); } catch (InterruptedException e) { }
        }, 1000, TimeUnit.MILLISECONDS);
        executor.schedule(() -> {
            System.out.println("任务2，执行时间：" + LocalDateTime.now());
        }, 1000, TimeUnit.MILLISECONDS);
    }
}
