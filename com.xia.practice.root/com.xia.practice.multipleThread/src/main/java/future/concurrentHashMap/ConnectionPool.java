package future.concurrentHashMap;

import java.sql.Connection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Lee on 2018/3/23.
 */
public class ConnectionPool {

    private ConcurrentHashMap<String, Connection> pool = new ConcurrentHashMap<String, Connection>();


    public Connection getConnection(String key){
        Connection connection = null;

        if(pool.containsKey(key)){
            connection = pool.get(key);
        }else{
            connection = createConnection();
            pool.putIfAbsent(key,connection);
        }
        return connection;
    }

    public Connection createConnection(){
        return new Connection();
    }



    class Connection{}

}
