package HomWorkMarket;

abstract class User {
    String name;
    String surname;
    int money;

    public User(String name, String surname, int money) {
        this.name = name;
        this.surname = surname;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
