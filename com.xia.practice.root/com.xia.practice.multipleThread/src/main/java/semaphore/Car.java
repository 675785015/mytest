package semaphore;

/**
 * Created by Lee on 2018/2/2.
 */
public class Car implements Runnable {

    private Driver driver;

    public Car(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void run() {
        driver.drive();
    }
}
