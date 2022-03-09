import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    private final static String SERVER_ADDRESS = "localhost";
    private final static int SERVER_PORT = 8080;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public EchoClient(JTextArea chatTextArea){
        try {
            openConnection(chatTextArea);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public  void openConnection(JTextArea chatArea) throws IOException {
        socket = new Socket(SERVER_ADDRESS,SERVER_PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        new Thread(() -> {
            try {
                while (true){
                    String messageFromServer = in.readUTF();

                    if (messageFromServer.equals("/end") ) {
                        break;
                    }
                   chatArea.append(messageFromServer + "\n");
                    System.out.println(chatArea.getText());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            while (true){
                Scanner scanner = new Scanner(System.in);
                String messageFromConsole = scanner.nextLine();
                if (messageFromConsole.equals("/end") ) {
                    break;
                }
                chatArea.append(messageFromConsole + "\n");
                System.out.println(chatArea.getText());
            }

        }).start();
    }

    public void closeConnection(){
        try {
            out.writeUTF("/end");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void sendMessage(String text){
        try {
            out.writeUTF(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
