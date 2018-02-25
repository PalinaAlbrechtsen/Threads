package Homework;

import java.util.ArrayList;
import java.util.List;

public class Dump {

    public static final int INITIAL_COUNT_OF_DETAILS = 20;
    public static final int COUNT_OF_NIGHTS = 100;

    public void putDetails(List<String> dump) {
        Robot[] details = Robot.values();
        for (int j = 0; j < COUNT_OF_NIGHTS; j++) {
            int MAX_DETAILS_AT_NIGHT = RandomUtil.generateRandomValue(5);
            for (int i = 0; i < MAX_DETAILS_AT_NIGHT; i++) {
                synchronized (dump) {
                    int indexOfDetail = RandomUtil.generateRandomValue(details.length);
                    dump.add(details[indexOfDetail].getDescription());
                }
            }
            sleep100mc();
        }
    }

    public void getDetails(List<String> collectedDetails, List<String> dump) {
        for (int j = 0; j < COUNT_OF_NIGHTS; j++) {
            int MAX_COUNT_OF_DETAILS = RandomUtil.generateRandomValue(5);
            for (int i = 0; i < MAX_COUNT_OF_DETAILS; i++) {
                synchronized (dump) {
                    if (!dump.isEmpty()) {
                        String detail = dump.get(0);
                        dump.remove(0);
                        collectedDetails.add(detail);
                    }
                }
            }
            sleep100mc();
        }
    }

    private void sleep100mc() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static List<String> fillTheDump(List<String> dump) {
        List<String> listOfDetails = new ArrayList<>();
        for (Robot robot : Robot.values()) {
            listOfDetails.add(robot.getDescription());
        }
        for (int i = 0; i < INITIAL_COUNT_OF_DETAILS; i++) {
            int index = RandomUtil.generateRandomValue(Robot.values().length);
            dump.add(listOfDetails.get(index));
        }

        return dump;
    }
}
