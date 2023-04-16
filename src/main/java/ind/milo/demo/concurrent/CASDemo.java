package ind.milo.demo.concurrent;

import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;

import java.util.concurrent.*;

public class CASDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1 / 0;
            }
        });
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(futureTask);
        if (futureTask.isDone() || futureTask.isCancelled()) {
            // 如果还未完成或已经取消，则尝试取消任务的执行
            futureTask.cancel(true);
//            futureTask.get();
        } else {
        }
        System.out.println("shutdown");
        executorService.shutdown();
    }


}
