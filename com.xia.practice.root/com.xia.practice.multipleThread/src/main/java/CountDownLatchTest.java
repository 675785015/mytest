import java.util.concurrent.CountDownLatch;

/**
 * Created by Lee on 2018/2/2.
 */
public class CountDownLatchTest {

    public static void main(String[] args) {

        final CountDownLatch countDownLatch = new CountDownLatch(2);


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程："+Thread.currentThread().getName()+"开始运行");

                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程："+Thread.currentThread().getName()+"结束");

            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程："+Thread.currentThread().getName()+"开始运行");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
                System.out.println("线程："+Thread.currentThread().getName()+"结束");

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程："+Thread.currentThread().getName()+"开始运行");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
                System.out.println("线程："+Thread.currentThread().getName()+"结束");

            }
        });

        t1.start();
        t2.start();
        t3.start();

    }
}
