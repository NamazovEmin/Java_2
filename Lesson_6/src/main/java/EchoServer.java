import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(8080)){
            System.out.println("Server Start");
            Socket socket = serverSocket.accept();
            System.out.println("User Connected");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            while (true){
                String message = in.readUTF();
                if (message.equals("/end")){
                    break;
                }
                out.writeUTF("Echo: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
