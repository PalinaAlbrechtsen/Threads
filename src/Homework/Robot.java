package Homework;

public enum Robot {

    BODY("body"),
    CPU("CPU"),
    HEAD("head"),
    HDD("HDD"),
    LEFT_HAND("leftHand"),
    LEFT_LEG("leftLeg"),
    RAM("RAM"),
    RIGHT_HAND("rightHand"),
    RIGHT_LEG("rightLeg");

    private String description;

    Robot(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
