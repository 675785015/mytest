package masterWorker;

import sun.awt.windows.ThemeReader;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Lee on 2018/1/31.
 */
public class Master {

    //存放任务queue
    private Queue<Task> queue = new ConcurrentLinkedQueue<Task>();
    //worker进程集
    private Map<String, Thread> map = new HashMap<String, Thread>();
    //子任务处理的结果集
    private Map<String, Object> resultMap = new ConcurrentHashMap<String, Object>();

    public Master(Worker worker, int count){
        worker.setWorkQueue(queue);
        worker.setMap(resultMap);

        for(int i=0;i<count;i++){

            map.put("线程"+Integer.toString(i),new Thread(worker));
        }
    }

    //提交方法
    public void submit(Task task){
        queue.add(task);
    }

    //启动所有worker线程
    public void execute(){
        for(Map.Entry<String, Thread> m : map.entrySet()){
            m.getValue().start();
        }
    }

    public Integer getResult(){
        int ret = 0;
        for(Map.Entry<String, Object> m : resultMap.entrySet()){
            ret += (Integer) m.getValue();
        }
        return ret;
    }

    public boolean isComplete(){
        for(Map.Entry<String, Thread> m : map.entrySet()){
            if(m.getValue().getState() != Thread.State.TERMINATED){
                return false;
            }
        }
        return true;
    }
}
