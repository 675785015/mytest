package threadLocal;

/**
 * Created by Lee on 2018/1/24.
 *
 *
 */
public class TestClient extends Thread {

    private TestNum num;

    public TestClient(TestNum num) {
        this.num = num;
    }

    public void run(){
        for(int i=1;i<=3;i++){
            System.out.println("thread["+Thread.currentThread().getName()+"] ----> sn["+num.nextNum()+"]");
        }
    }
}
