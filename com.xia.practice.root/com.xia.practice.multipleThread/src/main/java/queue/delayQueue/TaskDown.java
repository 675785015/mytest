package queue.delayQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by Lee on 2018/1/30.
 */
public class TaskDown implements Delayed {

    private int id;
    private String name;
    private long endtime;

    public TaskDown() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getEndtime() {
        return endtime;
    }

    public void setEndtime(long endtime) {
        this.endtime = endtime;
    }

    public TaskDown(int id, String name, long endtime) {
        this.id = id;
        this.name = name;
        this.endtime = endtime*1000+System.currentTimeMillis();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return endtime - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        TaskDown taskDown = (TaskDown) o;
        return Long.valueOf(this.endtime).compareTo(taskDown.endtime);
    }
}
