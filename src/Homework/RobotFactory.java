package Homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RobotFactory implements Runnable {

    List<String> dump;
    Dump svalka = new Dump();

    public RobotFactory(List<String> dump) {
        this.dump = dump;
    }

    @Override
    public void run() {
        svalka.putDetails(dump);
    }

    public static int makeRobots(List<String> details) {
        int robot = 0;
        List<Robot> robotsDetails = Arrays.asList(Robot.values());
        List<String> list = new ArrayList<>();
        for (Robot robotsDetail : robotsDetails) {
            String detail = robotsDetail.getDescription();
            list.add(detail);
        }
        while (details.containsAll(list)) {
            robot++;
            for (String s : list) {
                details.remove(s);
            }
        }

        return robot;
    }

    public static void showWhoIsABoss(List<String> firstListWithDetails, List<String> secondListWithDetails) {
        String mess;
        int firstScientist = makeRobots(firstListWithDetails);
        int secondScientist = makeRobots(secondListWithDetails);
        if (firstScientist < secondScientist) {
            mess = "Победил второй учёный! У него " + secondScientist + " роботов! У первого учёного - " + firstScientist + " роботов!";
        } else {
            if (secondScientist < firstScientist) {
                mess = "Победил первый учёный! У него " + firstScientist + " роботов! У второго учёного - " + secondScientist + " роботов!";
            } else {
                mess = "Ничья! У обоих учёных по " + firstScientist + " роботов!";
            }
        }
        System.out.println(mess);
    }
}

