package pl.edu.pw.ee.aisd2024zex6.matrixchainorder;

public class MatrixChainPerformanceTest {

    public static void main(String[] args) {
        final long TIME_LIMIT = 1_000_000_000L;

        MatrixChainDataGenerator dataGen = new MatrixChainDataGenerator();

        MatrixChainOrder recursiveMco = new MatrixChainOrderRecursive();
        MatrixChainOrder bottomUpMco = new MatrixChainOrderBottomUp();

        MatrixChainOrder topDownMco = new MatrixChainOrderTopDown();

        // 1. Rekurencyjna (bez memoizacji)
        System.out.println("Rekurencyjna");
        int recursiveN = findBoundaryN(recursiveMco, dataGen, TIME_LIMIT);
        System.out.println("Dla rekurencyjnej N ~ " + recursiveN);

        // 2. Zstępująca (top-down) – jeśli istnieje

        System.out.println("\nZstępująca (top-down)");
        int topDownN = findBoundaryN(topDownMco, dataGen, TIME_LIMIT);
        System.out.println("Dla top-down N ~ " + topDownN);


        // 3. Wstępująca (bottom-up)
        System.out.println("\nWstępująca (bottom-up)");
        int bottomUpN = findBoundaryN(bottomUpMco, dataGen, TIME_LIMIT);
        System.out.println("Dla bottom-up N ~ " + bottomUpN);
    }

    private static int findBoundaryN(MatrixChainOrder mco,
                                     MatrixChainDataGenerator dataGen,
                                     long TIME_LIMIT) {

        int step = 5;   // wartość przyrostu N w każdej iteracji
        int n = step;   // zaczynamy od 5 macierzy (można zacząć od 1, 2, 10... wedle potrzeb)

        while (true) {
            // Przygotowujemy np. "jednolite" wymiary macierzy
            // w łańcuchu (A1: 10x10, A2: 10x10, itd.)
            // => N macierzy => tablica size = N+1
            int[] matrixSizes = dataGen.generateUniformMatrixSizes(n, 10);

            // lub losowe:
            // int[] matrixSizes = dataGen.generateRandomMatrixSizes(n, 5, 50);

            long start = System.nanoTime();
            mco.findOptimalOrder(matrixSizes);
            long end = System.nanoTime();

            long duration = end - start;

            if (duration >= TIME_LIMIT) {
                // Gdy czas >= limit, zwracamy aktualne N
                return n;
            } else {
                // W przeciwnym razie zwiększamy N i próbujemy dalej
                n += step;
            }
        }
    }
}
