package com.jane.kafka.broker.message;

public class HelloPositiveMessage {
    private int positiveInt;

    private String upperCaseString;

    public HelloPositiveMessage() {
    }

    public HelloPositiveMessage(int positiveInt, String upperCaseString) {
        this.positiveInt = positiveInt;
        this.upperCaseString = upperCaseString;
    }

    public int getPositiveInt() {
        return positiveInt;
    }

    public void setPositiveInt(int positiveInt) {
        this.positiveInt = positiveInt;
    }

    public String getUpperCaseString() {
        return upperCaseString;
    }

    public void setUpperCaseString(String upperCaseString) {
        this.upperCaseString = upperCaseString;
    }

    @Override
    public String toString() {
        return "HelloPositiveMessage{" +
                "positiveInt=" + positiveInt +
                ", upperCaseString='" + upperCaseString + '\'' +
                '}';
    }
}
