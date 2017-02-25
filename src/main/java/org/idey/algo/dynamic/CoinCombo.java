package org.idey.algo.dynamic;

import java.util.Arrays;

/**
 * Class which is responsible for holding the number of coins of each type
 */
public class CoinCombo {
    int[] coinAmount;

    public CoinCombo(int numTypes) {
        coinAmount = new int[numTypes];
    }

    public CoinCombo(CoinCombo copy) {
        coinAmount = new int[copy.coinAmount.length];
        for (int i = 0; i < coinAmount.length; i++) {
            coinAmount[i] = copy.coinAmount[i];
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CoinCombo)) {
            return false;
        }

        CoinCombo c = (CoinCombo) o;
        if (coinAmount.length != c.coinAmount.length) {
            return false;
        }
        for (int i = 0; i < coinAmount.length; i++) {
            if (coinAmount[i] != c.coinAmount[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        for (int i = 0; i < coinAmount.length; i++) {
            hashCode += coinAmount[i];
            hashCode = hashCode << 1;
        }
        return hashCode;
    }

    @Override
    public String toString() {
        return Arrays.toString(coinAmount);
    }
}
