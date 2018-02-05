package lock;

import executors.ThreadPoolExecutorTest;

import java.awt.image.renderable.RenderableImageProducer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Lee on 2018/2/2.
 */
public class LockTest {

    private Lock lock = new ReentrantLock();

    public void method1(){
        lock.lock();
        System.out.println("当前线程："+Thread.currentThread().getName()+"进入等待。。。");
        try {
            Thread.sleep(3000);
            System.out.println("当前线程："+ Thread.currentThread().getName()+ "释放锁");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void method2(){
        System.out.println("当前线程："+Thread.currentThread().getName()+"进入等待。。。");
        try {
            Thread.sleep(2000);
            System.out.println("当前线程："+ Thread.currentThread().getName()+ "释放锁");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
