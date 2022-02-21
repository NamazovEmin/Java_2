public class Cat implements Participant {
    final double heightJumpCat;
    final int lengthRunCat;
    final String name;

    public Cat(int heightJumpCat, int lenghtRunCat, String name) {
        this.heightJumpCat = heightJumpCat;
        this.lengthRunCat = lenghtRunCat;
        this.name = name;
    }

    public double getHeightJumpCat() {
        return heightJumpCat;
    }

    public int getLengthRunCat() {
        return lengthRunCat;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean run(int value) {
        return lengthRunCat >= value;
    }

    @Override
    public boolean jump(double value) {
        return heightJumpCat >= value;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "heightJumpCat=" + heightJumpCat +
                ", lengthRunCat=" + lengthRunCat +
                ", name='" + name + '\'' +
                '}';
    }
}
