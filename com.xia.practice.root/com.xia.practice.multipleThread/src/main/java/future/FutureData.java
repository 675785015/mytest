package future;

/**
 * Created by Lee on 2018/1/30.
 */
public class FutureData implements Data {

    private RealData realData;

    private boolean isReady = false;

    public synchronized void setRealData(RealData realData) {
        //准备好直接返回
        if (isReady) {
            return;
        }
        //真实数据赋值
        this.realData = realData;
        isReady = true;
        //通知阻塞的线程
        notify();
    }

    @Override
    public synchronized String getData() {

        while (!isReady) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this.realData.getData();
    }
}
