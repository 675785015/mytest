package synchronizedTest;

/**
 * Created by Lee on 2018/3/16.
 */
public class MyRunnable implements Runnable {


    private TestSyn testSyn;

    public MyRunnable(TestSyn testSyn) {
        this.testSyn = testSyn;
    }

    @Override
    public void run() {
        testSyn.printOut();
    }
}
