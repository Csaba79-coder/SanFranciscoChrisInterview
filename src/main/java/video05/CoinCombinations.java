package video05;

public class CoinCombinations {

    // good to practice recursion!

    public static void main(String[] args) {

        // https://www.youtube.com/watch?v=d5x8aejKUSQ&list=PLyriihBWoulxiXbyBTxu7GF6R_FDVwXEs&index=5


        // count how many combination can be made to get a result

        int[] coins = {1, 2};
        int totalAmount = 4;


        // first combination: 4 x 1;
        // second combination: 2 x 2;
        // third combination: 2x 1 and 1 x 2;


        System.out.println(calculateCombo(coins, totalAmount, 0));
    }

    // I need to parameters to calculate combo, the coins I have + the amount!

    private static int calculateCombo(int[] coins, int amount, int currentIndex) {

        if (amount == 0) {
            return 1;
        }

        if (amount < 0) {
            return 0;
        }

        int combo = 0;

        for (int i = currentIndex; i < coins.length; i++) {
            combo += calculateCombo(coins, amount - coins[i], i);
        }
        return combo;
    }
}
