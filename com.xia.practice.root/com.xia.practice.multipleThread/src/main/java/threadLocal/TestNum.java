package threadLocal;

/**
 * Created by Lee on 2018/1/24.
 */
public class TestNum {

    private static ThreadLocal<Integer> seqnum = new ThreadLocal<Integer>(){
        public Integer initialValue(){
            return 0;
        }
    };

    public Integer nextNum(){
        seqnum.set(seqnum.get()+1);
        return seqnum.get();
    }

    public static void main(String[] args) {

        TestNum testNum = new TestNum();

        TestClient client1 = new TestClient(testNum);
        TestClient client2 = new TestClient(testNum);
        TestClient client3 = new TestClient(testNum);


        client1.start();
        client2.start();
        client3.start();
    }

}
