package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Lee on 2018/2/3.
 */
//读读共享  读写互斥  写写互斥
public class ReadWriteLockTest {

    public static void main(String[] args) {
        final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        final Lock readLock = lock.readLock();
        final Lock writeLock = lock.writeLock();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                readLock.lock();
                System.out.println("t1运行");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    readLock.unlock();
                }
            }
        },"t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                readLock.lock();
                System.out.println("t2运行");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    readLock.unlock();
                }
            }
        },"t2");

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                writeLock.lock();
                System.out.println("t3运行");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    writeLock.unlock();
                }
            }
        },"t3");

        t1.start();
//        t2.start();
        t3.start();

    }

}
