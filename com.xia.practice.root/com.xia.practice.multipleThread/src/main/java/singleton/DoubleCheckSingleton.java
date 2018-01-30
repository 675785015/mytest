package singleton;

/**
 * Created by Lee on 2018/1/26.
 */
public class DoubleCheckSingleton {

    private static DoubleCheckSingleton singleton;


    public static DoubleCheckSingleton getInstance(){
        if(singleton==null){

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (DoubleCheckSingleton.class){
                if(singleton==null){
                    singleton = new DoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"--->"+DoubleCheckSingleton.getInstance().hashCode());
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"--->"+DoubleCheckSingleton.getInstance().hashCode());
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"--->"+DoubleCheckSingleton.getInstance().hashCode());
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
