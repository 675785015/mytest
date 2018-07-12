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
     * synchronized 是对象锁，不同对象不同锁
     * static synchronized method() 类锁
     *
     */
    public static void main(String[] args) {

        final ObjectLock objectLock = new ObjectLock();

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
//    public static void main(String[] args) {
//        for(int i = 0; i<5;i++){
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    new TestSyn().printOut();
//                    System.out.println(Thread.currentThread().getName());
//                }
//            }).start();
//        }
//    }

}
