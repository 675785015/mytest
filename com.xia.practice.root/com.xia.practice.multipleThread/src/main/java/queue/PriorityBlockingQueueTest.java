package queue;

import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by Lee on 2018/1/29.
 */
public class PriorityBlockingQueueTest {

    public static void main(String[] args) {

        PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<Task>();

        for(int i=1; i<4;i++){
            Task task = new Task(i,"任务"+i);
            queue.add(task);
        }

        while (queue.size()>0){
            System.out.println(queue.poll().getName());
        }


    }


}
