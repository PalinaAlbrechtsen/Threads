package Homework;

import java.util.List;

public class Scientist extends Thread {

    List<String> collectedDetails;
    List<String> dump;
    Dump svalka = new Dump();

    public Scientist(List<String> collectedDetails, List<String> dump) {
        this.collectedDetails = collectedDetails;
        this.dump = dump;
    }

    @Override
    public void run() {
        svalka.getDetails(collectedDetails, dump);
    }
}
