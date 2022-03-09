package Server.authorization;

import java.util.HashMap;
import java.util.Map;

public class InMemoryAuthServiceImpl implements AuthService{
    private final Map<String, UserData> users;

    public InMemoryAuthServiceImpl() {
        users = new HashMap<>();
        users.put("login1", new UserData("login1", "password1", "first_user"));
        users.put("login2", new UserData("login2", "password2", "second_user"));
        users.put("login3", new UserData("login3", "password3", "third_user"));
    }


    @Override
    public void start() {
        System.out.println("Сервис Аутенфикации инициализирован");
    }

    @Override
    public String getNickNameByLoginAndPassword(String login, String password) {
        UserData user = users.get(login);
        // ищем пользователя по логину и поролю, если нашли возвращаем никнейм
        if (user != null && user.getPassword().equals(password)){
                return user.getNickName();
        }
        return null;
    }

    @Override
    public void end() {
        System.out.println("Сервис Аутенфикации отключен");
    }
}
