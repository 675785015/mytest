package serialize;

import java.io.*;

/**
 * Created by Lee on 2018/6/26.
 */
public class MyTest implements Serializable {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) throws Exception {
        MyTest myTest = new MyTest();
        myTest.setAge(10);
        myTest.setName("zhangsan");

        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("x.file"));
        out.writeObject(myTest);
    }
}
