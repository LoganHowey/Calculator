package Util;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class ArithmeticEvaluatorTest {

    ArithmeticEvaluator evaluator = new ArithmeticEvaluator();
    Environment environment = new Environment();

    public  ArithmeticStream toStream(String...list) {
        LinkedList<ArithmeticSymbol> stream = new LinkedList<>();
        for (String s : list) {
            if (s.matches("[0-9]+")) {
                stream.add(new ArithmeticSymbol(Type.NUMBER, s));
            }
            if (s.equals("+")) {
                stream.add(new ArithmeticSymbol(Type.ADD, s));
            }
            if (s.equals("-")) {
                stream.add(new ArithmeticSymbol(Type.SUBTRACT, s));
            }
            if (s.equals("*")) {
                stream.add(new ArithmeticSymbol(Type.MULTIPLY, s));
            }
            if (s.equals("/")) {
                stream.add(new ArithmeticSymbol(Type.DIVIDE, s));
            }
            if (s.equals("Finished")) {
                stream.add(new ArithmeticSymbol(Type.FINISHED, s));
            }
            if (s.equals("Go")) {
                stream.add(new ArithmeticSymbol(Type.COMPLETE, s));
            }
            else return null;
        }
        return new ArithmeticStream(stream);
    }

        @Test
        public void simpleEquation() {
            evaluator.evaluate(toStream("1", "poop", "+", "Go", "Finished"));
            Assert.assertThat(evaluator.printCount(), Is.is(1));
        }
    }