package callback;

/**
 * Created by Lee on 2018/3/28.
 */
public class Caller {

    private SayInterface sayInterface;

    public Caller(SayInterface sayInterface) {
        this.sayInterface = sayInterface;
    }

    public void callBack(){
        sayInterface.say();
    }
}
