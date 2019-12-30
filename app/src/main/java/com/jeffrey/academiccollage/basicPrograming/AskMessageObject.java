package com.jeffrey.academiccollage.basicPrograming;

public class AskMessageObject {

    private String nameOfSender;
    private String textToShow;
    private String timeCommented;

    public AskMessageObject() {
    }

    public AskMessageObject(String nameOfSender, String textToShow, String timeCommented) {
        this.nameOfSender = nameOfSender;
        this.textToShow = textToShow;
        this.timeCommented = timeCommented;
    }

    public String getNameOfSender() {
        return nameOfSender;
    }

    public void setNameOfSender(String nameOfSender) {
        this.nameOfSender = nameOfSender;
    }

    public String getTextToShow() {
        return textToShow;
    }

    public void setTextToShow(String textToShow) {
        this.textToShow = textToShow;
    }

    public String getTimeCommented() {
        return timeCommented;
    }

    public void setTimeCommented(String timeCommented) {
        this.timeCommented = timeCommented;
    }
}
