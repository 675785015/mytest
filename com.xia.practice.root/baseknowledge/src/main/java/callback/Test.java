package callback;

/**
 * Created by Lee on 2018/3/28.
 */
public class Test {

    public static void main(String[] args) {
        Caller caller = new Caller(new SayInterface() {
            @Override
            public void say() {
                System.out.println("匿名回调");
            }
        });
        caller.callBack();
    }
}
