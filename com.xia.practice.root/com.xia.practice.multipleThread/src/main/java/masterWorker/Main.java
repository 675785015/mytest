package masterWorker;

/**
 * Created by Lee on 2018/1/31.
 */
public class Main {

    public static void main(String[] args) {


        System.out.println("当前线程数："+Runtime.getRuntime().availableProcessors());
        Master m = new Master(new MyWorker(),Runtime.getRuntime().availableProcessors());

        for(int i=0;i<100;i++){
            Task task = new Task();
            task.setId(i);
            task.setName("任务" + i);
            task.setPrice(i);
            m.submit(task);
        }

        m.execute();

        long start = System.currentTimeMillis();

        while(true){
            if(m.isComplete()){
                long end = System.currentTimeMillis() - start;
                Integer result = m.getResult();
                System.out.println("操作总耗时："+end+",结果："+result);
                break;
            }
        }
    }
}
