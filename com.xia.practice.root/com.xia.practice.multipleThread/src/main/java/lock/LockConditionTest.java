package lock;

import executors.ThreadPoolExecutorTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Lee on 2018/2/2.
 */
public class LockConditionTest {

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public void m1(){
        lock.lock();
        System.out.println("当前线程："+ Thread.currentThread().getName()+"等待");
        try {
            Thread.sleep(2000);
            condition.await();
            System.out.println("当前线程："+Thread.currentThread().getName()+"执行完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


    }

    public void m2(){
        lock.lock();
        System.out.println("signal当前线程："+ Thread.currentThread().getName()+"等待");
        try {
            Thread.sleep(2000);
            condition.signal();
            System.out.println("signal当前线程："+Thread.currentThread().getName()+"执行完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }        finally {
            lock.unlock();
        }

    }

}
