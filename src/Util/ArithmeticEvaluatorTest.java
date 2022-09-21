package Util;

import com.sun.source.tree.EmptyStatementTree;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EmptyStackException;
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
            else if (s.matches("^-[1-9]\\d*|0$")) {
                stream.add(new ArithmeticSymbol(Type.NUMBER, s));
            } else if (s.equals("+")) {
                stream.add(new ArithmeticSymbol(Type.ADD, s));
            }
            else if (s.equals("-")) {
                stream.add(new ArithmeticSymbol(Type.SUBTRACT, s));
            }
            else if (s.equals("*")) {
                stream.add(new ArithmeticSymbol(Type.MULTIPLY, s));
            }
            else if (s.equals("/")) {
                stream.add(new ArithmeticSymbol(Type.DIVIDE, s));
            }
            else if (s.equals("Finished")) {
                stream.add(new ArithmeticSymbol(Type.FINISHED, s));
            }
            else if (s.equals("Go")) {
                stream.add(new ArithmeticSymbol(Type.COMPLETE, s));
            }
            else{
                stream.add((new ArithmeticSymbol(Type.INVALID, s)));
            }
        }
        return new ArithmeticStream(stream);
    }

        @Test
        public void simpleAddEquation() {
            evaluator.evaluate(toStream("1", "2", "+", "Go", "Finished"));
            Assert.assertThat(evaluator.printCount(), Is.is(1));
            Assert.assertThat(evaluator.printResults(), Is.is(new String[]{"3.0"}));
        }
        @Test
        public void simpleSubtractEquation() {
            evaluator.evaluate(toStream("2", "1", "-", "Go", "Finished"));
            Assert.assertThat(evaluator.printCount(), Is.is(1));
            Assert.assertThat(evaluator.printResults(), Is.is(new String[]{"1.0"}));
        }
        @Test
        public void simpleSubtractNegEquation() {
            evaluator.evaluate(toStream("1", "2", "-", "Go", "Finished"));
            Assert.assertThat(evaluator.printCount(), Is.is(1));
            Assert.assertThat(evaluator.printResults(), Is.is(new String[]{"-1.0"}));
        }
        @Test
        public void simpleMultiplyEquation() {
            evaluator.evaluate(toStream("1", "2", "*", "Go", "Finished"));
            Assert.assertThat(evaluator.printCount(), Is.is(1));
            Assert.assertThat(evaluator.printResults(), Is.is(new String[]{"2.0"}));
        }
        @Test
        public void simpleMultiplyNegEquation() {
            evaluator.evaluate(toStream("1", "-2", "*", "Go", "Finished"));
            Assert.assertThat(evaluator.printCount(), Is.is(1));
            Assert.assertThat(evaluator.printResults(), Is.is(new String[]{"-2.0"}));
        }
        @Test
        public void simpleDivEquation() {
            evaluator.evaluate(toStream("1", "2", "/", "Go", "Finished"));
            Assert.assertThat(evaluator.printCount(), Is.is(1));
            Assert.assertThat(evaluator.printResults(), Is.is(new String[]{"0.5"}));
        }
        @Test
        public void simpleDivNegEquation() {
            evaluator.evaluate(toStream("1", "-2", "/", "Go", "Finished"));
            Assert.assertThat(evaluator.printCount(), Is.is(1));
            Assert.assertThat(evaluator.printResults(), Is.is(new String[]{"-0.5"}));
        }
        @Test (expected = EmptyStackException.class)
        public void tooManySymbolsEquation() {
            evaluator.evaluate(toStream("1", "-2", "/", "+", "Go", "Finished"));
        }

        @Test
        public void tooManyNumbersEquation(){
            evaluator.evaluate(toStream("1", "-2", "3", "/", "Go", "Finished"));
            Assert.assertThat(evaluator.printCount(), Is.is(0));
        }
        @Test
        public void complexEquation(){
            evaluator.evaluate(toStream("1", "-2", "4", "/", "+", "Go", "Finished"));
            Assert.assertThat(evaluator.printCount(), Is.is(1));
            Assert.assertThat(evaluator.printResults(), Is.is(new String[]{"0.5"}));
        }
        @Test
        public void multipleSimpleEquation(){
            evaluator.evaluate(toStream("1", "-2", "/", "Go", "3", "4", "+", "Go", "Finished"));
            Assert.assertThat(evaluator.printCount(), Is.is(2));
            Assert.assertThat(evaluator.printResults(), Is.is(new String[]{"-0.5", "7.0"}));
        }
        @Test
        public void multipleComplexEquation(){
            evaluator.evaluate(toStream("1", "-2", "3", "-","/", "Go", "3", "4", "7", "*", "+", "Go", "Finished"));
            Assert.assertThat(evaluator.printCount(), Is.is(2));
            Assert.assertThat(evaluator.printResults(), Is.is(new String[]{"-0.2", "31.0"}));
        }
    }