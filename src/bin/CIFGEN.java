package bin;

import org.jetbrains.annotations.NotNull;

import java.util.*;

import static java.lang.Math.abs;

abstract public class CIFGEN {
    private Set<Integer> CIF = new HashSet<>();

    private void generate(){
        for(int i = 0; i < 100000; i++) {
            Random random = new Random();
            Integer x = abs(random.nextInt());
            CIF.add(x);
        }
    }


    public int getRandCIF(){
        generate();
        Random random = new Random();
        int idx = abs(random.nextInt()%100000);
        Integer[] arr = CIF.toArray(new Integer[CIF.size()]);
        return arr[idx];
    }

}
