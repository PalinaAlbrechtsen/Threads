package Homework;

import java.util.Random;

public final class RandomUtil {

    private final static Random RANDOM = new Random();

    private RandomUtil() {
    }

    public static int generateRandomValue(int bound){
        return RANDOM.nextInt(bound);
    }
}
