package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Randomchoice {
    public static String rand() {
        List<String> coin = new ArrayList<>();
        coin.add("orel");
        coin.add("reshka");
        Random rand = new Random();
        String randomElement = coin.get(rand.nextInt(coin.size()));
        return randomElement;   
    }
}
