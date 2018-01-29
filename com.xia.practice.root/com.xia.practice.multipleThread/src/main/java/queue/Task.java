package queue;

import java.util.Comparator;

/**
 * Created by Lee on 2018/1/29.
 */
public class Task implements Comparable<Task> {

    private Integer id;
    private String name;

    public Task(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Task task) {
        return task.id.compareTo(this.id);
    }
}
