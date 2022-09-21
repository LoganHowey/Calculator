package Util;

import javax.swing.*;
import java.util.Stack;

public class ArithmeticEvaluator {

    private Stack<ArithmeticSymbol> stack = new Stack<>();

    private Environment environment = new Environment();

    public void evaluate(ArithmeticStream stream) {
        // start adding stream data to stack
        int current = 0;
        while (true) {
            ArithmeticSymbol symbol = stream.next();
            Type type = symbol.getType();
            if (type.equals(Type.NUMBER)) {
                stack.push(symbol);
            }
            if (type.equals(Type.ADD) || type.equals(Type.SUBTRACT) || type.equals(Type.MULTIPLY) || type.equals(Type.DIVIDE)) {
                ArithmeticSymbol b = stack.pop();
                ArithmeticSymbol a = stack.pop();
                ArithmeticSymbol result = calculate(type, b, a);
                stack.push(result);
            }
            if (type.equals(Type.COMPLETE)) {
                environment.allResults.add(Double.parseDouble(stack.pop().getValue()));
            }
            if (type.equals(Type.FINISHED)){
                if (stack.size() != 0){
                    System.out.println("Invalid Equation");
                }
                environment.print();
                environment.printCount();
                break;
            }
        }
        //if data is number, contntinue to add
        //if data is symbol, set aside
        //pop off number and put into B
        //pop off number and put into A
        //do A by symbol to B
        //repeat
        //if data is complete return final number
        //if data is finished end calculation
    }

    private ArithmeticSymbol calculate(Type type, ArithmeticSymbol b, ArithmeticSymbol a) {
        ArithmeticSymbol results;
        if (type.equals(Type.ADD)) {
            Double temp = Double.parseDouble(a.getValue()) + Double.parseDouble(b.getValue());
            results = new ArithmeticSymbol(Type.NUMBER, Double.toString(temp));
            return results;
        }
        if (type.equals(Type.SUBTRACT)) {
            Double temp = Double.parseDouble(a.getValue()) - Double.parseDouble(b.getValue());
            results = new ArithmeticSymbol(Type.NUMBER, Double.toString(temp));
            return results;
        }
        if (type.equals(Type.MULTIPLY)) {
            Double temp = Double.parseDouble(a.getValue()) * Double.parseDouble(b.getValue());
            results = new ArithmeticSymbol(Type.NUMBER, Double.toString(temp));
            return results;
        }
        if (type.equals(Type.DIVIDE)) {
            Double temp = Double.parseDouble(a.getValue()) / Double.parseDouble(b.getValue());
            results = new ArithmeticSymbol(Type.NUMBER, Double.toString(temp));
            return results;
        }
        return null;
    }

    public int printCount(){
        int num = environment.printCount();
        return num;
    }
}

