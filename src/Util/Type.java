package Util;

public enum Type {
    FINISHED("Done"),
    COMPLETE("Go"),
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    NUMBER("0");

    String s;

    Type(String s) {
        this.s = s;
    }
}
