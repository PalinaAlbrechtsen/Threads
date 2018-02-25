package Homework;

import java.util.ArrayList;
import java.util.List;

public class RunActionsOnTheDump {

    public static void main(String[] args) {
        List<String> dump = new ArrayList<>();
        Dump.fillTheDump(dump);

        List<String> firstScientistsDetails = new ArrayList<>();
        List<String> secondScientistsDetails = new ArrayList<>();
        Thread firstAcolyte = new Scientist(firstScientistsDetails, dump);
        Thread secondAcolyte = new Scientist(secondScientistsDetails, dump);
        Thread factory = new Thread(new RobotFactory(dump));

        firstAcolyte.start();
        secondAcolyte.start();
        factory.start();

        try {
            firstAcolyte.join();
            secondAcolyte.join();
            factory.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        RobotFactory.showWhoIsABoss(firstScientistsDetails, secondScientistsDetails);
    }
}
