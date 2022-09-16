package Util;

import javax.swing.*;
import java.util.Stack;

public class ArithmeticEvaluator {

    private Stack<ArithmeticSymbol> stack;

    private Environment environment;

    public void evaluate(ArithmeticStream stream) {
        // start adding stream data to stack
        int current = 0;
        while (true){
            ArithmeticSymbol symbol = stream.next();
            Type type = symbol.getType();
            if (type.equals(Type.NUMBER)){
                stack.push(symbol);
            }
            if (type.equals(Type.ADD) || type.equals(Type.SUBTRACT) || type.equals(Type.MULTIPLY) || type.equals(Type.DIVIDE)){
                ArithmeticSymbol b = stack.pop();
                ArithmeticSymbol a = stack.pop();
                ArithmeticSymbol result = calculate(type, b, a);
                stack.push(result);
            }
            if (type.equals(Type.COMPLETE)){
                environment = (Environment) stack.pop();
            }
            if (type.equals(Type.FINISHED)){
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
        if (type.equals(Type.ADD)){
            return results = a + b;
        }
        if (type.equals(Type.SUBTRACT)){
            return results = a - b;
        }
        if (type.equals(Type.MULTIPLY)){
            return results = a * b;
        }
        if (type.equals(Type.DIVIDE)){
            return results = a / b;
        }
    }
}
