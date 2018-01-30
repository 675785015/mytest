package singleton;

import java.util.Collections;
import java.util.HashSet;

/**
 * Created by Lee on 2018/1/24.
 */
public class InnerSingleton {


    private static class Singleton{
        private static Singleton singleton = new Singleton();
    }

    public static Singleton getInstance(){
        return Singleton.singleton;
    }


    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"---"+InnerSingleton.getInstance().hashCode());
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"---"+InnerSingleton.getInstance().hashCode());
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"---"+InnerSingleton.getInstance().hashCode());
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();


        Collections.synchronizedSet(new HashSet<Object>());
    }
}
