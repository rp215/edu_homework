package socketDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author：renpeng
 * @date：2019/8/12
 */
public class ServerSocketDemo {
    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        BufferedReader in = null;

        try {
            serverSocket = new ServerSocket(8080);
            Socket socket = serverSocket.accept();//阻塞
            // 获取到输入流
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(in.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != in){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != serverSocket){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
