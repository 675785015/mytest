package masterWorker;

import java.util.Map;
import java.util.Queue;

/**
 * Created by Lee on 2018/1/31.
 */
public abstract class Worker implements Runnable {

    //任务队列，用于子任务
    private Queue<Task> workQueue;
    //结果集，用于存放结果
    private Map<String, Object> resultMap;

    public void setWorkQueue(Queue<Task> workQueue) {
        this.workQueue = workQueue;
    }

    public void setMap(Map<String, Object> map) {
        this.resultMap = map;
    }

    @Override
    public void run() {
        while(true){
            Task t = workQueue.poll();
            if(t==null){
                break;
            }
            //处理业务
            Integer outPut = handle(t);
            this.resultMap.put(Integer.toString(t.getId()), outPut);
        }

    }
    //实际业务处理
    public abstract Integer handle(Task t);
}
