package disruptor;

/**
 * Created by Administrator on 2018/8/8 0008.
 */
public class MyInParkingDataEvent {

    private String carLicense; // 车牌号

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

}
