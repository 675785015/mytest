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

// TODO Auto-generated method stub

        Thread t1 = new Thread(new MyRunnable(new TestSyn()));
        Thread t2 = new Thread(new MyRunnable(new TestSyn()));

        t1.start();
        t2.start();

    }

}
