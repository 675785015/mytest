package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2018/8/8 0008.
 */
public class SocketServer {

        public static void main(String[] args) throws IOException {
            //创建服务端socket
            ServerSocket serverSocket = new ServerSocket(10086);//1024-65535的某个端口
            //监听  线程挂起
            while (true) {
                Socket accept = serverSocket.accept();
                HanderThreadPool handerThreadPool = new HanderThreadPool(50, 1000);
                handerThreadPool.execute(new ServerHandler(accept));
            }
        }
}
