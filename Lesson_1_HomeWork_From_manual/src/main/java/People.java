public class People implements Participant{
    final int heightJumpPeople;
    final int lenghtRunPeople;
    final String name;

    public People(int heightJumpPeople, int lenghtRunPeople, String name) {
        this.heightJumpPeople = heightJumpPeople;
        this.lenghtRunPeople = lenghtRunPeople;
        this.name = name;
    }

    public int getHeightJumpCat() {
        return heightJumpPeople;
    }

    public int getLenghtRunCat() {
        return lenghtRunPeople;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean run(int value) {
        return lenghtRunPeople >= value;
    }

    @Override
    public boolean jump(double value) {
        return heightJumpPeople >= value;
    }

    @Override
    public String toString() {
        return "People{" +
                "heightJumpPeople=" + heightJumpPeople +
                ", lenghtRunPeople=" + lenghtRunPeople +
                ", name='" + name + '\'' +
                '}';
    }
}
