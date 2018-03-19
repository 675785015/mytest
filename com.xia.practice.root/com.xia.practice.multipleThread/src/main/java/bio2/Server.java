package bio2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	final static int PORT = 8765;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(PORT);
			System.out.println("服务器start");
			Socket accept = server.accept();
			new HandlerExecutorPool(50,1000).execute(new ServerHandler(accept));
			//new Thread(new ServerHandler(accept)).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(server != null){
				try {
					server.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			server = null;
		}

	}

}
