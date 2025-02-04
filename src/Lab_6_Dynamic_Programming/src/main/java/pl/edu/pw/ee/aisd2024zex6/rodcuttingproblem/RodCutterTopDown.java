package pl.edu.pw.ee.aisd2024zex6.rodcuttingproblem;

import static java.lang.Math.max;

public class RodCutterTopDown extends RodCutter {

    @Override
    public RodCutterResult cutRod(int[] prices, int rodLength) {
        validateInput(prices, rodLength);

        int[] results = initResults(rodLength + 1);

        int maxSumResult = cutRodTopDown(prices, rodLength, results);

        RodCutterResult finalResult = new RodCutterResult(maxSumResult);

        return finalResult;
    }

    private int[] initResults(int size) {
        int[] results = new int[size];

        for (int i = 0; i < size; i++) {
            results[i] = Integer.MIN_VALUE;
        }

        return results;
    }

    private int cutRodTopDown(int[] prices, int rodLength, int[] results) {
        if (results[rodLength] >= 0) {
            return results[rodLength];
        }

        results[0] = 0;

        for (int len = 1; len <= rodLength; len++) {
            if (results[len] < 0) {
                int best = Integer.MIN_VALUE;
                for (int cut = 1; cut <= len; cut++) {
                    best = max(best, prices[cut - 1] + results[len - cut]);
                }
                results[len] = best;
            }
        }

        return results[rodLength];
    }


}
