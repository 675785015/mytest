package vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by Lee on 2018/1/26.
 */
public class TestVector {

    private Vector<String> vector = new Vector<String>();

    private List<String> list = new ArrayList<String>();


    public static void main(String[] args) {
        for(int i=1;i<=10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {

                }
            }).start();


        }
    }

}
