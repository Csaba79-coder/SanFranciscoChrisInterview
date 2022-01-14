package video06;

public class CoinMinimum {

    public static void main(String[] args) {

        // https://www.youtube.com/watch?v=p9tKIEBjUM4&list=PLyriihBWoulxiXbyBTxu7GF6R_FDVwXEs&index=6

        // using the example from the video number 6! and returns the smallest combination! --> using less coins for the combo!

        int[] coins = {1, 2};
        int totalAmount = 4;

        // first combination: 4 x 1; --> 4 pcs
        // second combination: 2 x 2; --> 2 pcs (good result!)
        // third combination: 2 x 1 and 1 x 2; --> 3 pcs

        System.out.println(calculateMinCombo(coins, totalAmount, 0));
    }

    private static int calculateMinCombo(int[] coins, int amount, int currentIndex) {

        if (amount == 0) {
            return 0;
        }

        int result = Integer.MAX_VALUE;

        for (int i = currentIndex; i < coins.length; i++) {
            if (coins[i] <= amount) {
                int subResult = calculateMinCombo(coins, amount - coins[i], i);

                if (subResult != Integer.MAX_VALUE && (subResult + 1) < result) {
                    result = subResult + 1;
                }
            }
        }
        return result;
    }
}