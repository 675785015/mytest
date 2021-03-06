import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Lee on 2018/2/2.
 */
public class CyclicBarrierTest {


    static class Runner extends Thread{

        private CyclicBarrier cyclicBarrier;
        private String name;


        public Runner(CyclicBarrier cyclicBarrier, String name) {
            this.cyclicBarrier = cyclicBarrier;
            this.name = name;
        }

        @Override
        public void run() {

            try {
                Thread.sleep(1000*(new Random().nextInt(5)));
            } catch (InterruptedException e) {
            }
            System.out.println(name+"准备ok");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

            System.out.println(name+"...Go");

        }
    }

    public static void main(String[] args) {
        CyclicBarrier c = new CyclicBarrier(3);


        Thread r1 = new Runner(c, "zhangsan");
        Thread r2 = new Runner(c, "lisi");
        Thread r3 = new Runner(c, "wangwu");

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(r1);
        executorService.submit(r2);
        executorService.submit(r3);

        executorService.shutdown();

    }

}
