package Util;

public class ArithmeticSymbol {

    private String value;
    private Type type;


    public String getValue() {
        return value;
    }

    public Type getType() {
        switch (value){
            case "+":
                type = Type.ADD;
                return type;
            case "-":
                type = Type.SUBTRACT;
                return type;
            case "*":
                type = Type.MULTIPLY;
                return type;
            case "/":
                type = Type.DIVIDE;
                return type;
            default:
                type = Type.NUMBER;
                return type;
        }
    }

}
