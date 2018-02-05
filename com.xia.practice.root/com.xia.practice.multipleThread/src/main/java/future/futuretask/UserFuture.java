package future.futuretask;

import java.util.concurrent.Callable;

/**
 * Created by Lee on 2018/2/2.
 */
public class UserFuture implements Callable<String> {

    private String para;

    public UserFuture(String para) {
        this.para = para;
    }

    @Override
    public String call() throws Exception {
        //模拟耗时
        Thread.sleep(3000);
        String result = this.para + "处理完成";

        return result;
    }
}
