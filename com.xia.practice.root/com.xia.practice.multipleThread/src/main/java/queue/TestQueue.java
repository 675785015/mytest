package queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Lee on 2018/1/26.
 */
public class TestQueue {

    public static void main(String[] args) throws InterruptedException {
        /**
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();

        queue.add("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");

        System.out.println(queue.size());
        System.out.println(queue.poll());
        System.out.println(queue.size());
        System.out.println(queue.peek());
        System.out.println(queue.size());
        */

        /**
        ArrayBlockingQueue queue = new ArrayBlockingQueue(3);
        queue.add("a");
        queue.offer("b");
        queue.add("c");
        System.out.println(queue.size());
        */


        /**
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>();
        queue.add("a");
        queue.offer("b");
        queue.add("c");
        queue.add("d");

        List<String> list = new ArrayList<String>();

        queue.drainTo(list,3);

        for(String arg:list){
            System.out.println(arg);
        }

        System.out.println(queue.size());
        System.out.println(queue.poll());
        System.out.println(queue.size());
        */


    }
}
