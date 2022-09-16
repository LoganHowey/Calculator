package Util;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArithmeticEvaluatorTest {

    ArithmeticEvaluator evaluator = new ArithmeticEvaluator();



    @Test
    public void ifNumberAddToStack(){
        evaluator.evaluate("1", "2", "+", "COMPLETE", "FINISHED"));
    }

}