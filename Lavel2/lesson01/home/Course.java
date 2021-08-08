package Lavel2.lesson01.home;


public class Course {
    public static void main(String[] args) {
        Human human1 = new Human("Человек", "Иван", 600, 5);
        Cat cat1 = new Cat("Кот", "Барсик", 100, 5);
        Robot robot1 = new Robot("Робот", "Василий", 300, 10.5f);

        Wall wall1 = new Wall(0.5f);
        Treadmill treadmill1 = new Treadmill(50);

        Object[] participant = {human1, robot1, cat1};
        Object[] obstacles = {wall1, treadmill1};

        int count = 0;
        while (true) {
            count++;
            System.out.println("Раунд №: " + count);
            if (runMarathon(participant, obstacles)) {
                System.out.println("Марафон окончен!!!");
                break;
            }
            System.out.println("***************");
        }

    }

    public static boolean runMarathon(Object[] participant, Object[] obstacles) {
        boolean fl = true;
        for (int i = 0; i < participant.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                if (participant[i] instanceof Human && obstacles[j] instanceof Wall) {
                    Human tmpParticipant = (Human) participant[i];
                    Wall tmpObstacles = (Wall) obstacles[j];
                    if (tmpParticipant.checkJump(tmpObstacles.getHeightWall())) {
                        tmpParticipant.jump(tmpObstacles.getHeightWall());
                        tmpParticipant.setLimitJump((tmpObstacles.getHeightWall()));
                        fl = false;
                    }
                }
                if (participant[i] instanceof Human && obstacles[j] instanceof Treadmill) {
                    Human tmpParticipant = (Human) participant[i];
                    Treadmill tmpObstacles = (Treadmill) obstacles[j];
                    if (tmpParticipant.checkRun(tmpObstacles.getLengthDistance())) {
                        tmpParticipant.run(tmpObstacles.getLengthDistance());
                        tmpParticipant.setLimitRun(tmpObstacles.getLengthDistance());
                        fl = false;
                    }
                }
                // cat
                if (participant[i] instanceof Cat && obstacles[j] instanceof Wall) {
                    Cat tmpParticipant = (Cat) participant[i];
                    Wall tmpObstacles = (Wall) obstacles[j];
                    if (tmpParticipant.checkJump(tmpObstacles.getHeightWall())) {
                        tmpParticipant.jump(tmpObstacles.getHeightWall());
                        tmpParticipant.setLimitJump((tmpObstacles.getHeightWall()));
                        fl = false;
                    }
                }
                if (participant[i] instanceof Cat && obstacles[j] instanceof Treadmill) {
                    Cat tmpParticipant = (Cat) participant[i];
                    Treadmill tmpObstacles = (Treadmill) obstacles[j];
                    if (tmpParticipant.checkRun(tmpObstacles.getLengthDistance())) {
                        tmpParticipant.run(tmpObstacles.getLengthDistance());
                        tmpParticipant.setLimitRun(tmpObstacles.getLengthDistance());
                        fl = false;
                    }
                }
                //robot
                if (participant[i] instanceof Robot && obstacles[j] instanceof Wall) {
                    Robot tmpParticipant = (Robot) participant[i];
                    Wall tmpObstacles = (Wall) obstacles[j];
                    if (tmpParticipant.checkJump(tmpObstacles.getHeightWall())) {
                        tmpParticipant.jump(tmpObstacles.getHeightWall());
                        tmpParticipant.setLimitJump((tmpObstacles.getHeightWall()));
                        fl = false;
                    }
                }
                if (participant[i] instanceof Robot && obstacles[j] instanceof Treadmill) {
                    Robot tmpParticipant = (Robot) participant[i];
                    Treadmill tmpObstacles = (Treadmill) obstacles[j];
                    if (tmpParticipant.checkRun(tmpObstacles.getLengthDistance())) {
                        tmpParticipant.run(tmpObstacles.getLengthDistance());
                        tmpParticipant.setLimitRun(tmpObstacles.getLengthDistance());
                        fl = false;
                    }
                }
            }
        }
        return fl;

    }

}

