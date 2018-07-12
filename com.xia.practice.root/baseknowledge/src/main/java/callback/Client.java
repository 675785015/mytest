package callback;

/**
 * Created by Lee on 2018/3/28.
 */
public class Client implements SayInterface {
    @Override
    public void say() {
        System.out.println("回调方法");
    }
}
