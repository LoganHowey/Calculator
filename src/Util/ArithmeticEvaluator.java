package Util;

import javax.swing.*;
import java.util.Stack;

import static Util.Type.FINISHED;

public class ArithmeticEvaluator {

    private Stack<ArithmeticSymbol> stack;

    private Environment environment;

    public void evaluate(ArithmeticStream stream) {
        // start adding stream data to stack
        int current = 0;
        while (true){
            ArithmeticSymbol symbol = stream.next();
            if (symbol.equals(Type.NUMBER)){
                stack.push(symbol);
            }
            else if (symbol.equals(Type.ADD) || symbol.equals(Type.SUBTRACT) || symbol.equals(Type.MULTIPLY) || symbol.equals(Type.DIVIDE)){

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
}
