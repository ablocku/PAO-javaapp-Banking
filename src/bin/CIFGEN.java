package bin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract public class CIFGEN {
    private List<Integer> CIF = new ArrayList<>(100000);

    private void generate(){
        for(int i = 0; i < 100000; i++) {
            Random random = new Random();
            Integer x = random.nextInt();
            if (!CIF.contains(x))
                CIF.add(x);
        }
    }

    public int getRandCIF(){
        Random random = new Random();
        int idx = random.nextInt()%100000;
        return CIF.get(idx);
    }

}
