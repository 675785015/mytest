package queue;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Lee on 2018/1/26.
 */
public class SynchronousQueueTest {


    public static void main(String[] args) {
        SynchronousQueue<Integer> que = new SynchronousQueue<Integer>();

        new Provider(que).start();
        new Comsumer(que).start();
    }


    static class Provider extends Thread{

        SynchronousQueue<Integer> queue;

        public Provider(SynchronousQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run(){
            System.out.println("生产者开始");
            while(true){
                int i = new Random().nextInt(1000);
                System.out.println("生产一个随机数："+i);
                System.out.println("生产者休息3s");

                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    queue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(queue.isEmpty());
            }
        }


    }
    static class Comsumer extends Thread{

        SynchronousQueue<Integer> queue;

        public Comsumer(SynchronousQueue<Integer> queue) {
            this.queue = queue;
        }
        @Override
        public void run(){
            System.out.println("消费者开始");
            while (true){
                try {
                    System.out.println("消费者取出:"+queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("----");
            }
        }
    }
}
