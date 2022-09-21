package Util;

public class ArithmeticSymbol {

    private String value;
    private Type type;


    public String getValue() {
        return value;
    }

    public ArithmeticSymbol(Type type, String value){
        this.type = type;
        this.value = value;
    }

    public Type getType() {
        return type;
    }

}
