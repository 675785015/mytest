package semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Created by Lee on 2018/2/2.
 */
public class Driver {

    private Semaphore semaphore = new Semaphore(3);

    public void drive(){

        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+"业务处理中...");
            Thread.sleep(new Random().nextInt(5) * 1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"业务处理完");
        semaphore.release();

    }
}
