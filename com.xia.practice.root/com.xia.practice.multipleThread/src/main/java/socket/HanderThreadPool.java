package socket;

import semaphore.Run;

import java.util.concurrent.*;

/**
 * Created by Lee on 2018/7/2.
 */
public class HanderThreadPool{

    private ExecutorService executorService;
    public HanderThreadPool(int maximumPoolSize, int queueSize) {
        this.executorService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
                        maximumPoolSize,
                        120L,
                        TimeUnit.SECONDS,
                        new ArrayBlockingQueue<Runnable>(queueSize)
        );

    }

    public void execute(Runnable task){
        this.executorService.execute(task);
    }
}
