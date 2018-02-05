package semaphore;

/**
 * Created by Lee on 2018/2/2.
 */
public class Run {

    public static void main(String[] args) {
        Driver driver = new Driver();
        for (int i=0;i<10;i++){
            Thread thread = new Thread(new Car(driver));
            thread.start();
        }
    }
}
