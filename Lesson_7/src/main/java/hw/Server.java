package hw;

import Server.authorization.AuthService;
import Server.authorization.InMemoryAuthServiceImpl;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Server {

    private final AuthService authService;
    private List<ClientHandler> connectedUsers;
    private final  int PORT = 8080;
    public Server(){
        authService = new InMemoryAuthServiceImpl();
        try (ServerSocket server = new ServerSocket(PORT);){
            authService.start();
            connectedUsers = new ArrayList<>();
            while (true) {
                System.out.println("Сервер ожидает подключения");
                Socket socket = server.accept();
                System.out.println("Клиент подключился");
                new ClientHandler(this,socket);
            }

        } catch (IOException e) {
            System.out.println("Ошибка в работе сервера");
            e.printStackTrace();
        } finally {
            if (authService != null) {
                authService.end();
            }
        }
    }


    public AuthService getAuthService() {
        return authService;
    }

    public boolean isNickNameBusy(String nickName) {
        for (ClientHandler handler : connectedUsers){
            if (handler.getNickName().equals(nickName)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void  broadcastMessage(String message) {
        for (ClientHandler handler : connectedUsers) {
            handler.sendMessage(message);
        }
    }

    public synchronized void broadcastPrivateMessage(String text, String name, String nickname){
        for (ClientHandler handler : connectedUsers){
            if (handler.getNickName().equals(name)) {
                String message = text.replace("/w " + name, " приватное сообщение только для вас от " + nickname + ": ");
                handler.sendMessage(message);
            }
            if (handler.getNickName().equals(nickname)) {
                String message = text.replace("/w " + name, " вы приватно написали " + name + ": ");
                handler.sendMessage(message);
            }
        }
    }

    public synchronized void addConnectedUser(ClientHandler handler) {
        connectedUsers.add(handler);
    }

    public synchronized void disconnectUser(ClientHandler handler) {
        connectedUsers.remove(handler);
    }

}
