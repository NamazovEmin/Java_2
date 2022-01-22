
public class Lesson_1 {

    public static void main(String[] args) {
//Cat cat1 = new Cat(2, 200, "Izi");
//Robot robot1 = new Robot(3,300, "Robokop 1000");
//People people1 = new People(1,100, "Nikolay");
//Wall wall1 = new Wall(1);
//RunningTrack runningTrack1 = new RunningTrack(100);
//cat1.run(runningTrack1, cat1);
//robot1.run(runningTrack1, robot1);
//people1.run(runningTrack1, people1);
//cat1.jump(wall1, cat1);
//robot1.jump(wall1, robot1);
//people1.jump(wall1, people1);



        Participant[] participants = new Participant[2];
        participants[0] = new Cat(2, 100, "Izi");
        participants[1] = new Cat(3, 1000, "Barsa");
//        participants[2] = new Robot(4, 200, "Naomi");
//        participants[3] = new Robot(5, 500, "Masay");
//        participants[4] = new People(6, 50, "Nikolay");
//        participants[5] = new People(6, 50, "Vladimir");

        Obstacle[] obstacles = new Obstacle[7];
        obstacles[0] = new Wall(2);
        obstacles[1] = new RunningTrack(200);
        obstacles[2] = new River(100);
        obstacles[3] = new RunningTrack(100);
        obstacles[4] = new Wall(3);
        obstacles[5] = new RunningTrack(50);
        obstacles[6] = new Wall(5);
        competition(participants, obstacles);
    }


    public static void competition(Participant[] participants, Obstacle[] obstacles) {
        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                boolean result = obstacle.doAction(participant);
                System.out.println("competition(). result: " + result + ", obstacle: " + obstacle + ", participants: " + participant);
                if (!result) {
                    break;
                }
            }
        }
    }
}




