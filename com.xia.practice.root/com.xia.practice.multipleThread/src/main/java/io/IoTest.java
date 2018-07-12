package io;

import java.io.*;

/**
 * Created by Lee on 2018/7/3.
 */
public class IoTest {

    public static void main(String[] args) {
//        writeByteToFile();
//        readByteFromFile();
//        writeCharToFile();
//        readCharFromFile();
//        randomAccessFileRead();
//        randomAccessFileWrite();
//        readByBufferedInputStream();
//        readByBufferedReader();
//        copyByBufferInputStream();
        copyByBufferReader();
    }

    public static void writeByteToFile() {
        //往文件中写出 字符串
        String hello = "hello";
        //把字符串转为字节
        byte[] bytes = hello.getBytes();
        File file = new File("d:/iotest.txt");
        //用字节流写出，所以对应的是outputstream
        //因为媒介是文件，子类用fileoutputstream
        OutputStream out = null;
        try {
            out = new FileOutputStream(file);
            out.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void readByteFromFile() {
        File file = new File("d:/iotest.txt");
        // 设定读取的字节数
        int n = 512;
        byte buffer[] = new byte[n];
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            int read = is.read();
            while(read !=-1){
                System.out.print((char) read);
                read = is.read();
            }
            // 读取输入流
//            while ((is.read(buffer, 0, n) != -1) && (n > 0)) {
//                System.out.print(new String(buffer));
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 关闭输入流
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void writeCharToFile(){
        String hello = "hello world";
        File file = new File("d:/iotest.txt");
        Writer writer = null;
        try {
            writer = new FileWriter(file);
            writer.write(hello);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readCharFromFile(){
        File file = new File("d:/iotest.txt");

        int n = 512;
        Reader reader = null ;
        try {
            reader = new FileReader(file);
            char[] chars = new char[n];
            while((reader.read(chars,0,n) != -1) && (n>0)){
                System.out.println("reader content:"+new String(chars));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //字节流转换成字符流
    public static void convertByteToChar(){
        File file = new File("d:/iotest.txt");

        int n = 512;
        Reader reader = null ;
        try {
            FileInputStream is = new FileInputStream(file);
            //字节流转换成字符流
            reader = new InputStreamReader(is);

            char[] chars = new char[n];
            while((reader.read(chars,0,n) != -1) && (n>0)){
                System.out.println("reader content:"+new String(chars));
            }
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void randomAccessFileRead(){
        try {
            RandomAccessFile file = new RandomAccessFile("d:/iotest.txt", "rw");
            //通过seek移动指针
            file.seek(3);
            //返回指针的位置
            long filePointer = file.getFilePointer();
            byte buffer[] = new byte[1024];
            file.read(buffer);

            long filePointer1 = file.getFilePointer();

            System.out.println("current filePoionter:"+filePointer1+";content:"+new String(buffer));

            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void randomAccessFileWrite(){
        try {
            RandomAccessFile rw = new RandomAccessFile("d:/iotest.txt", "rw");

            rw.seek(3);
            long filePointer = rw.getFilePointer();
            String nHello = "HELLO WOLRD";
            rw.write(nHello.getBytes());

            long filePointer1 = rw.getFilePointer();
            System.out.println("current filePointer:"+filePointer1+";");
            rw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void readByBufferedInputStream(){
        File file = new File("d:/iotest.txt");
        byte buffer[] = new byte[10240];
        try {
            InputStream bis = new BufferedInputStream(new FileInputStream(file), 2 * 1024);
            bis.read(buffer);
            System.out.println("content:"+new String(buffer));
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readByBufferedReader(){
        File file = new File("d:/iotest.txt");
        char buffer[] = new char[10240];
        try {
            Reader reader = new BufferedReader(new FileReader(file), 2 * 1024);
            reader.read(buffer);
            System.out.println("content:"+new String(buffer));
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyByBufferInputStream(){
        File file = new File("d:/Penguins.jpg");
        int ch = 0;
        byte[] chars = new byte[1024];
        try {
            InputStream is = new FileInputStream(file);

            OutputStream os = new FileOutputStream(new File("d:/Penguins2.jpg"));
            while (is.read(chars)!=-1){
                os.write(chars);
                os.flush();
            }

            os.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyByBufferReader(){
        File file = new File("d:/iotest.txt");

        try {
            Reader reader = new BufferedReader(new FileReader(file));
            Writer writer = new BufferedWriter(new FileWriter(new File("d:/iotest2.txt")));

            char chars[] = new char[1024];
            while(reader.read(chars)!=-1){
                writer.write(chars);
                writer.flush();
            }
            writer.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
