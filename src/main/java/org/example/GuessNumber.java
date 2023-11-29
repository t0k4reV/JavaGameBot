package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class GuessNumber {
    public static Integer rand() {
        List<Integer> coin = new ArrayList<>();
        Random rand = new Random();
        return coin.get(rand.nextInt(coin.size()));
    }

}
