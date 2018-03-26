package synchronizedTest;

/**
 * Created by Lee on 2018/3/16.
 */
public class TestMySyn {


    /**

     *

     */

    public TestMySyn() {

// TODO Auto-generated constructor stub

    }

    /**
     * @param args
     * synchronized 不同对象不同锁
     */


    public static void main(String[] args) {

        final ObjectLock objectLock = new ObjectLock();
// TODO Auto-generated method stub

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                objectLock.method3();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                objectLock.method3();
            }
        });

        t1.start();
        t2.start();

    }

}
