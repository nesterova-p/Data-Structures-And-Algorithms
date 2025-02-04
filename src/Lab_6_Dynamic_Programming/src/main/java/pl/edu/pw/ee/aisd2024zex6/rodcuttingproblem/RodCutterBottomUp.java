package pl.edu.pw.ee.aisd2024zex6.rodcuttingproblem;

import static java.lang.Math.max;

public class RodCutterBottomUp extends RodCutter {

    @Override
    public RodCutterResult cutRod(int[] prices, int rodLength) {
        validateInput(prices, rodLength);

        // tablica results z minimalnymi wartościami
        int[] results = initResults(rodLength + 1);

        results[0] = 0;

        //  results iteracyjnie (iteracyjne podejście zamiast pełnej rekurencji)
        for (int len = 1; len <= rodLength; len++) {
            int best = Integer.MIN_VALUE;

            for (int cut = 1; cut <= len; cut++) {
                best = max(best, prices[cut - 1] + results[len - cut]);
            }

            results[len] = best;
        }

        RodCutterResult finalResult = new RodCutterResult(results[rodLength]);

        return finalResult;
    }

    private int[] initResults(int size) {
        int[] results = new int[size];

        for (int i = 0; i < size; i++) {
            results[i] = Integer.MIN_VALUE;
        }

        return results;
    }
}
