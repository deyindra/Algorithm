package org.idey.algo.dynamic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CoinChangeCombination {


    private static Set<CoinCombo> findAllScoreCombinations(final int amount, int[] coinTypes) {
        int highestScore = 0;
        for (int i = 0; i < coinTypes.length; i++) {
            highestScore = Math.max(highestScore, coinTypes[i]);
        }

        Map<Integer, Set<CoinCombo>> memoizedResults = new HashMap<>();
        memoizedResults.put(0, new HashSet<>());

        for (int i = 1; i <= amount; i++) {
            // create score combination set for intermediate score i
            Set<CoinCombo> comboSet = new HashSet<>();
            for (int j = 0; j < coinTypes.length; j++) {
                // add a new score combo to the set
                if (i == coinTypes[j]) {
                    CoinCombo newCombo = new CoinCombo(coinTypes.length);
                    newCombo.coinAmount[j]++;
                    comboSet.add(newCombo);
                }

                // create a copy of the memoized results with the new result added
                if (memoizedResults.containsKey(i - coinTypes[j])) {
                    for (CoinCombo c : memoizedResults.get(i - coinTypes[j])) {
                        CoinCombo newCombo = new CoinCombo(c);
                        newCombo.coinAmount[j]++;
                        comboSet.add(newCombo);
                    }
                }
            }
            if (comboSet.size() > 0) {
                memoizedResults.put(i, comboSet);
            }

            // remove unneeded results to save memory
            memoizedResults.remove(i - highestScore);
        }

        if (memoizedResults.containsKey(amount)) {
            return memoizedResults.get(amount);
        } else {
            return new HashSet<>();
        }
    }

    public static void displayAllScoreCombinations(final int amount, int[] coinTypes) {
        System.out.println("All combinations for amount " + amount);
        for (CoinCombo c : findAllScoreCombinations(amount, coinTypes)) {
            for (int i = 0; i < c.coinAmount.length; i++) {
                if(c.coinAmount[i]!=0) {
                    System.out.print(c.coinAmount[i] + "X" + coinTypes[i] + "\t");
                }
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        //This can be further optimized by discarding a coin type if its value > amount
        displayAllScoreCombinations(63, new int[]{1,5,10,25,64});
    }

}
