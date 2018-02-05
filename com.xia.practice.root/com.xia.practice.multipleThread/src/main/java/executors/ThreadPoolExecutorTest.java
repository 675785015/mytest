package executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Lee on 2018/2/1.
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
        ExecutorService executorService =
//                Executors.newFixedThreadPool(3);    //LinkedBlockingQueue<Runnable>
//                Executors.newCachedThreadPool();      //SynchronousQueue<Runnable>
//                  Executors.newSingleThreadExecutor();  //LinkedBlockingQueue<Runnable>
        Executors.newScheduledThreadPool(3);    //DelayedWorkQueue
        for(int i=0; i<10; i++){
            final int index = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":"+index);

                }
            });
        }
        executorService.shutdown();
    }
}
