package future;

/**
 * Created by Lee on 2018/1/30.
 */
public class FutureClient {

    public Data request(final String requestStr){
        //构造一个包装对象
        final FutureData futureData = new FutureData();

        //2 启动一个线程去加载数据
        new Thread(new Runnable() {
            @Override
            public void run() {
                RealData realData = new RealData(requestStr);
                futureData.setRealData(realData);
            }
        }).start();


        return futureData;

    }
}
