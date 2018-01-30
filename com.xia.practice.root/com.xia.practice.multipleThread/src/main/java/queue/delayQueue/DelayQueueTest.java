package queue.delayQueue;

import java.util.concurrent.DelayQueue;

/**
 * Created by Lee on 2018/1/30.
 */
public class DelayQueueTest{

    public static void main(String[] args) {

        DelayQueue<TaskDown> queue = new DelayQueue<TaskDown>();

        TaskDown t1 = new TaskDown(13, "路人甲",1);
        TaskDown t2 = new TaskDown(24, "路人乙",9);
        TaskDown t3 = new TaskDown(35, "路人丙",5);

        queue.add(t1);
        queue.add(t2);
        queue.add(t3);
        while(queue.size()>0){
            try {
                TaskDown take = queue.take();
                System.out.println("证件号:"+take.getId()+";姓名:"+take.getName()+";下线了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
