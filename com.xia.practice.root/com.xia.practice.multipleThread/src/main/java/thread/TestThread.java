package thread;

/**
 * Created by Lee on 2018/3/15.
 */
public class TestThread {
    public static void main(String[] args)  {
        System.out.println("主线程ID："+Thread.currentThread().getId());

        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("主线程结束");
    }
}

class MyRunnable implements Runnable{

    public MyRunnable() {

    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("子线程ID："+Thread.currentThread().getId());
    }
}