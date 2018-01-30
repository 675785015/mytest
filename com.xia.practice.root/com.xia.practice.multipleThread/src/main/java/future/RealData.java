package future;

/**
 * Created by Lee on 2018/1/30.
 */
public class RealData implements Data {

    private String result;

    public RealData(String requestStr) {

        System.out.println("真实业务处理，耗时中。。。");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("业务处理完毕");
        this.result = "处理结果";
    }

    @Override
    public String getData() {
        return result;
    }
}
