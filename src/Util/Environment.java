package Util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Environment {

    LinkedList<Double> allResults = new LinkedList<>();
    public void print(){
        for (Double allResult : allResults) {
            System.out.println(allResult);
        }
    }

    public int printCount(){
        int i = 0;
        for (Double allResult : allResults) {
            i++;
        }
        return i;
    }

    public String[] printResults(){
        int i = 0;
        String[] demResults = new String[allResults.size()];
        for (Double allResult : allResults) {
            demResults[i] = String.valueOf(allResult);
            i++;
        }
        System.out.println(Arrays.toString(demResults));
        return demResults;
    }
}
