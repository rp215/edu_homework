package socketDemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author：renpeng
 * @date：2019/8/12
 */
public class ClientSocketDemo {
    public static void main(String[] args) {
        Socket socket = null;
        PrintWriter out = null;
        try {
            socket = new Socket("127.0.0.1", 8080);

            out = new PrintWriter(socket.getOutputStream());

            out.write("a");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != out){
                out.close();
            }
            if (null != socket){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
