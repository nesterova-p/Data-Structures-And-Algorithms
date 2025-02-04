package pl.edu.pw.ee.aisd2024zex6.rodcuttingproblem;

public class RodCuttingPerformanceTest {

    public static void main(String[] args) {
        RodCutter recursiveCutter = new RodCutterRecursive();
        RodCutter topDownCutter = new RodCutterTopDown();
        RodCutter bottomUpCutter = new RodCutterBottomUp();

        RandomDataGenerator dataGen = new RandomDataGenerator();

        final long TIME_LIMIT = 1_000_000_000L; // 4 sek * 10^9 ns
        final int MAX_PRICE = 100;

        System.out.println("Szukanie granicznego N dla implementacji rekurencyjnej:");
        int recursiveN = findBoundaryN(recursiveCutter, dataGen, MAX_PRICE, TIME_LIMIT);
        System.out.println("Dla rekurencyjnej, N ~ " + recursiveN);
/*
        System.out.println("\nSzukanie granicznego N dla implementacji zstępującej (top-down):");
        int topDownN = findBoundaryN(topDownCutter, dataGen, MAX_PRICE, TIME_LIMIT);
        System.out.println("Dla top-down, N ~ " + topDownN);

        System.out.println("\nSzukanie granicznego N dla implementacji wstępującej (bottom-up):");
        int bottomUpN = findBoundaryN(bottomUpCutter, dataGen, MAX_PRICE, TIME_LIMIT);
        System.out.println("Dla bottom-up, N ~ " + bottomUpN);
 */

    }

    private static int findBoundaryN(RodCutter cutter, RandomDataGenerator dataGen, int maxPrice, long timeLimit) {
        int step = 10;
        int n = step;

        while (true) {
            int[] prices = dataGen.generatePrices(n, maxPrice);

            long start = System.nanoTime();
            cutter.cutRod(prices, n);
            long end = System.nanoTime();

            long duration = end - start;

            if (duration >= timeLimit) {
                // Osiągnięto lub przekroczono limit czasu
                return n;
            } else {
                // Jeżeli czas jest jeszcze krótki, zwiększamy N
                n += step;
            }
        }
    }
}
