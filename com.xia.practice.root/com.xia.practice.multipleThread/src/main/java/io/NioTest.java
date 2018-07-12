package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Lee on 2018/7/3.
 */
public class NioTest {

    public static void main(String[] args) throws Exception {
        copyFileUseNIO();
    }

    public static void copyFileUseNIO() throws Exception{
        //声明源文件和目标文件
        FileInputStream fi = new FileInputStream(new File("d:/Penguins.jpg"));
        FileOutputStream fo = new FileOutputStream(new File("d:/Penguins2.jpg"));
        //获得传输通道channel
        FileChannel inChannel=fi.getChannel();
        FileChannel outChannel=fo.getChannel();
        //获得容器buffer
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        while(inChannel.read(buffer)!=-1){
            //重设一下buffer的position=0，limit=position
            buffer.flip();
            //开始写
            outChannel.write(buffer);
            //写完要重置buffer，重设position=0,limit=capacity
            buffer.clear();
        }
        inChannel.close();
        outChannel.close();
        fi.close();
        fo.close();
    }


}
