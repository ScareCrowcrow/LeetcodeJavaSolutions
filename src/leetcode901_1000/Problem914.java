package leetcode901_1000;

import java.util.HashMap;

public class Problem914 {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck == null || deck.length < 2) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < deck.length; i++){
            map.put(deck[i], map.getOrDefault(deck[i], 0) + 1);
        }
        int maxGcd = map.get(deck[0]);
        for (int value: map.values()){
            if (value == 1){
                return false;
            }
            if (value > 1){
                maxGcd = gcd(maxGcd, value);
            }
            if (maxGcd == 1)
                return false;
        }
        return true;
    }

    private int gcd(int a, int b){
        if (b == 0){
            return a;
        }
        return gcd(b, a%b);
    }
}
