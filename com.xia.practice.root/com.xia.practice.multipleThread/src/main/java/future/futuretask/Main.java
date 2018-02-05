package future.futuretask;

import java.util.concurrent.*;

/**
 * Created by Lee on 2018/2/2.
 */
public class Main {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String param = "query";

        FutureTask<String> futureTask = new FutureTask<String>(new UserFuture(param));
        FutureTask<String> futureTask1 = new FutureTask<String>(new UserFuture(param));

        //创建一个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //submit 与 execute区别  submit有返回值（当线程执行完时返回null）
        //提交给线程池执行任务，也可以通过exec.invokeAll(taskList)一次性提交所有任务;
        Future<?> submit1 = executorService.submit(futureTask1);
        Future<?> submit = executorService.submit(futureTask);

        System.out.println("请求完毕");

        String result = futureTask.get();  //get方法会自动阻塞,直到获取计算结果为止
        String s = futureTask1.get();
        System.out.println("数据结果："+ s);
        System.out.println("数据结果："+ result);

        executorService.shutdown();
    }
}
