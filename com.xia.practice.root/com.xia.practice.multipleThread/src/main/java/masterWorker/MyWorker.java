package masterWorker;

/**
 * Created by Lee on 2018/1/31.
 */
public class MyWorker extends Worker {


    @Override
    public Integer handle(Task t){
        Integer input = 0;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        input = t.getPrice();
        return input;
    }
}
