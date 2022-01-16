package video10;

public class StepOnStairsAmazonInterview {

    // https://www.youtube.com/watch?v=zFffmfDWhHY&list=PLyriihBWoulxiXbyBTxu7GF6R_FDVwXEs&index=10

    // you can step one or two stairs at one
    // how many combinations you can step up on stairs?

    public static void main(String[] args) {

        // 1 stair - 1 step - 1 combo
        // 2 stairs - 2x - 1 steps or 1 time 2 steps - 2 combination
        // 3 stairs - 3x - 1 step or 1  time 2 steps + 1 step or 2 times 1 steps + 2 times  1 step - 3 combo
        // 4 stairs - 1-1-1-1 and 2-1-1 and 1-2-1 and 1-1-2 and 2-2 --> 5 combo

        // we have n stairs
        // steps [1,2]

        int[] steps = {1, 2};
        int stair = 4;
        int currentIndex = 0;

        int result = countAllCombination(steps, stair);
        System.out.println(result);

        int resultNoDuplication = findComboNoDuplication(steps, stair, currentIndex);
        System.out.println(resultNoDuplication);

        int minResult = findMinCombo(steps, stair, currentIndex);
        System.out.println(minResult);
    }

    private static int countAllCombination(int[] steps, int stair) {
        if (stair == 0) {
            return 1;

        }

        if (stair < 0) {
            return 0;
        }

        int combo = 0;

        for (int i = 0; i < steps.length; i++) {
            combo += countAllCombination(steps, stair - steps[i]);
        }
        return combo;
    }

    private static int findComboNoDuplication(int[] steps, int stair, int currentIndex) {
        if (stair == 0) {
            return 1;
        }

        if (stair < 0) {
            return 0;
        }

        int combo = 0;
        for (int i = currentIndex; i < steps.length; i++) {
            combo += findComboNoDuplication(steps, stair - steps[i], i);
        }
        return combo;
    }

    private static int findMinCombo(int[] steps, int stair, int currentIndex) {
        if (stair == 0) {
            return 0;
        }

        int result = Integer.MAX_VALUE;

        for (int i = currentIndex; i < steps.length; i++) {
            if (steps[i] <= stair) {
                int subResult = findMinCombo(steps, stair - steps[i], i);

                if (subResult != Integer.MAX_VALUE && (subResult + 1) < result) {
                    result = subResult + 1;
                }
            }
        }
        return result;
    }
}