package Util;

import java.util.LinkedList;
import java.util.Queue;

public interface ArithmeticStream {

    Queue<ArithmeticSymbol> conveyer = new LinkedList<>();
    public ArithmeticSymbol next();
}
