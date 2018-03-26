package synchronizedTest;

/**
 * Created by Lee on 2018/3/19.
 */
public class ObjectLock {

    public void method1(){
        synchronized (this){
            System.out.println("do method1...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void method2(){
        synchronized (ObjectLock.class){
            System.out.println("do method2...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public Object lock = new Object();

    public void method3(){
        System.out.println("1 do method3...");
        synchronized (lock){
            System.out.println("do method3...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("2 do method3...");

    }
}
