package Util;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArithmeticEvaluatorTest {

    ArithmeticEvaluator evaluator = new ArithmeticEvaluator();

    private ArithmeticStream toStream(String ... values) {
        String[] aStringArray = new String[values.length];
        int i = 0;
        for (String item : values){
            aStringArray[i] = item;
        }
        return aStringArray;
    }

    @Test
    public void ifNumberAddToStack(){
        evaluator.evaluate(toStream("1", "2", "+", "COMPLETE", "FINISHED"));
    }



}