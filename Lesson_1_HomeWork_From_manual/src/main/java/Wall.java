public class Wall implements Obstacle {
    private double hight;

    public Wall(int hight) {
        this.hight = hight;
    }

    public double getHight() {
        return hight;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }

    @Override
    public boolean doAction(Participant participant) {
        return participant.jump(hight);
    }

    @Override
    public String toString() {
        return "Wall{" +
                "hight=" + hight +
                '}';
    }
}
