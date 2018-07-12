package synchronizedTest;

/**
 * Created by Lee on 2018/3/16.
 */
public class TestSyn {

    static int a = 5;

    /**
     * 不同对象不同锁
     * 如果添加static 就属于类锁了
      */


    public static synchronized void printOut(){

            System.out.println(--a);
    }
}
