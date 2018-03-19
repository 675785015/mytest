package nio;

import java.nio.IntBuffer;

/**
 * Created by Lee on 2018/3/6.
 */
public class TestBuffer {

    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(10);
        buffer.put(10);
        buffer.put(20);
        buffer.put(30);

        buffer.flip();  //需要复位

        System.out.println("复位buffer:"+buffer);
        System.out.println("容量："+buffer.capacity());
        System.out.println("上限："+buffer.limit());

        System.out.println(buffer.get(1));
        System.out.println("查看buffer:"+buffer);

        buffer.put(1,4);

        for(int i=1;i<=buffer.limit();i++){
            System.out.println("buffer值："+buffer.get());
        }

        /**
         *未复位时，get()是以put位置下标值开始
         *
         * 复位buffer:java.nio.HeapIntBuffer[pos=0 lim=3 cap=10]
         容量：10
         上限：3
         20
         查看buffer:java.nio.HeapIntBuffer[pos=0 lim=3 cap=10]
         buffer值：10
         buffer值：4
         buffer值：30
         */
    }
}
