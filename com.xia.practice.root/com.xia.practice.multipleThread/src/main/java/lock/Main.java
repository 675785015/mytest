package lock;

/**
 * Created by Lee on 2018/2/2.
 */
public class Main {


    //lockTest
//    public static void main(String[] args) {
//        final LockTest test = new LockTest();
//
//        for(int i=0;i<3;i++){
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    test.method1();
//                }
//            }).start();
//
//        }
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                test.method2();
//            }
//        }).start();
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }


    //lockConditionTest
    public static void main(String[] args) {
        final LockConditionTest test = new LockConditionTest();

        for(int i=0;i<3;i++){

            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.m1();
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.m2();
                }
            }).start();
        }

    }
}
