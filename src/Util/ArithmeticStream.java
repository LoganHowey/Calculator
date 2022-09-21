package Util;

import java.util.LinkedList;
import java.util.Queue;

public class ArithmeticStream {

    LinkedList<ArithmeticSymbol> conveyor = new LinkedList<>();

    public ArithmeticStream(LinkedList conveyor){
        this.conveyor = conveyor;
    }

    public ArithmeticSymbol next() {
        if (conveyor.size() == 0) return null;
        return conveyor.remove(0);
    }
}
