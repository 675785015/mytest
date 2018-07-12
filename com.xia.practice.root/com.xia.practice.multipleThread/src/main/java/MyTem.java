import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee on 2018/6/25.
 */
public class MyTem<T> {

    List list = new ArrayList();
    public void add(T m){

        list.add(m);
    }

    public void delete(T m){
        list.remove(m);
    }

    public void find(){
        T m = (T) list.get(0);
    }
}
