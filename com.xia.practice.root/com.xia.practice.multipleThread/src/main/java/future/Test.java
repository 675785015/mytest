package future;

/**
 * Created by Lee on 2018/1/30.
 */
public class Test {

    public static void main(String[] args) {
        FutureClient client = new FutureClient();

        Data data = client.request("请求参数");
        System.out.println("请求成功了");
        System.out.println("去执行其他操作");
        String resp = data.getData();


        System.out.println(resp);
    }
}
