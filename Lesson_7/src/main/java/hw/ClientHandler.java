package hw;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private final Server server;
    private final Socket socket;
    private final DataInputStream imputStream;
    private final DataOutputStream outputStream;

    private String nickName;

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            this.imputStream = new DataInputStream(socket.getInputStream());
            this.outputStream = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try {
                    authentication();
                    readMessages();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    closeConnection();
                }
            }).start();
        } catch (IOException e) {
            throw new RuntimeException("Проблемы при создании обработчика");
        }


    }


    public  void authentication() throws IOException {
        while (true) {
            String message = imputStream.readUTF();
            if (message.startsWith(ServerCommandConstants.AUTHORIZATION)) {
                String[] authInfo = message.split(" ");
                String nickName = server.getAuthService().getNickNameByLoginAndPassword(authInfo[1],authInfo[2]);
                if (nickName != null) {
                    if (!server.isNickNameBusy(nickName)) {
                        sendMessage("/authOk " + nickName);
                        this.nickName = nickName;
                        server.broadcastMessage(nickName + "зашел в чат");
                        server.addConnectedUser(this);
                        return;
                    } else {
                        sendMessage("учетная запись уже используется");
                    }
                } else {
                    sendMessage("Неверный логин или пароль");
                }
            }
        }
    }

    private void readMessages() throws IOException {
        while (true) {
            String messageInChat = imputStream.readUTF();
            System.out.println("от " + nickName + ": " + messageInChat);
            if (messageInChat.equals("/end")) {
                return;
            }
            if (messageInChat.startsWith(ServerCommandConstants.PRIVATE)){
                String[] privateUserMessage = messageInChat.split(" ");
                if (server.isNickNameBusy(privateUserMessage[1])){
                    messageInChat = String.join(" ",privateUserMessage);
                    server.broadcastPrivateMessage((messageInChat),privateUserMessage[1], nickName);

                }
            } else {
                server.broadcastMessage(nickName + ": " + messageInChat);
            }
//            server.broadcastMessage(nickName + ": " + messageInChat);
        }
    }

    private void closeConnection() {
        server.disconnectUser(this);
        server.broadcastMessage(nickName + " вышел из чата");
        try {
            outputStream.close();
            imputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }

    void sendMessage(String message) {
        try {
            outputStream.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNickName() {
        return nickName;
    }
}
