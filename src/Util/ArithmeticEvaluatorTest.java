package Util;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArithmeticEvaluatorTest {

    ArithmeticEvaluator evaluator = new ArithmeticEvaluator();

    private ArithmeticStream toStream() {
    }

    @Test
    public void ifNumberAddToStack(){
        evaluator.evaluate(toStream("1", "2", "+", "COMPLETE", "FINISHED"));
    }



}