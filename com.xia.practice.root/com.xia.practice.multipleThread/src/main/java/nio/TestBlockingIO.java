package nio;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by Lee on 2018/3/6.
 */
public class TestBlockingIO {

    @Test
    public void client() throws IOException {
        //1、获取通道（open这种方法是jdk1.7之后才引入的）
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8888));
        //2、分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //3、从本地读取文件，并发送到服务端
//        FileChannel fileChannel = FileChannel.open(Paths.get("F:/test/bio/abc.png"), StandardOpenOption.READ);
//        while(fileChannel.read(buffer)!=-1){
//            buffer.flip();
//            socketChannel.write(buffer);
//            buffer.clear();
//        }
        socketChannel.write(buffer);
        socketChannel.shutdownOutput();

        //客户端 接收代码
        int len = 0;
        while((len = socketChannel.read(buffer))!=-1){
            buffer.flip();
            System.out.println(new String(buffer.array(),0,len));
        }




        //4.关闭通道
        socketChannel.close();

    }

    @Test
    public void server() throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.bind(new InetSocketAddress(8888));

        SocketChannel socketChannel = serverSocketChannel.accept();

        FileChannel fileChannel = FileChannel.open(Paths.get("F:/test/nio/EChartsTheme.png"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while(socketChannel.read(buffer)!=-1){
            buffer.flip();
            fileChannel.write(buffer);
            buffer.clear();
        }


        //发送反馈给客户端
        buffer.put("服务端接收数据成功！".getBytes());
        buffer.flip();
        socketChannel.write(buffer);


        socketChannel.close();
        fileChannel.close();
        serverSocketChannel.close();



    }

}
