package synchronizedTest;

/**
 * Created by Lee on 2018/3/16.
 */
public class TestSyn {

    int a = 5;

    public synchronized void printOut(){

            System.out.println(--a);
    }
}
