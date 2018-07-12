package socket;

import bio2.*;
import bio2.ServerHandler;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Lee on 2018/7/2.
 */
public class SocketServer {

    public static void main(String[] args) throws IOException {
        //创建服务端socket
        ServerSocket serverSocket =new ServerSocket(10086);//1024-65535的某个端口
        //监听  线程挂起
        while (true){
            Socket accept = serverSocket.accept();
            HanderThreadPool handerThreadPool = new HanderThreadPool(50, 1000);
            handerThreadPool.execute(new ServerHandler(accept));
        }


//5、关闭资源

    }
}
