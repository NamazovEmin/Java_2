import javax.naming.Name;

public class Lesson_1 {

    public static void main(String[] args) {
        Participant[] participants = new Participant[6];
        participants[0] = new Cat(5, 200, "Izi");
        participants[1] = new Cat(3, 1000, "Barsa");
        participants[2] = new Robot(4, 200, "Naomi");
        participants[3] = new Robot(6, 500, "Masay");
        participants[4] = new People(6, 50, "Nikolay");
        participants[5] = new People(6, 50, "Vladimir");

        Obstacle[] obstacles = new Obstacle[7];
        obstacles[0] = new Wall(2);
        obstacles[1] = new RunningTrack(200);
        obstacles[2] = new Wall(1);
        obstacles[3] = new RunningTrack(100);
        obstacles[4] = new Wall(3);
        obstacles[5] = new RunningTrack(50);
        obstacles[6] = new Wall(5);
        competition(participants, obstacles);
    }

    public static void competition(Participant[] participants, Obstacle[] obstacles) {
        for (Participant participant : participants) {
            boolean result = false;
            for (Obstacle obstacle : obstacles) {
                result = obstacle.doAction(participant);
                if (!result) {
                    break;
                }
            }
            if (result) {
                System.out.println("Competition win: " +participant);
            }
        }
    }
}




