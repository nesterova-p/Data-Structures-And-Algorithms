package pl.edu.pw.ee.aisd2024zex6.matrixchainorder;

public class MatrixChainOrderTopDown extends MatrixChainOrder {

    @Override
    public MatrixChainOrderResult findOptimalOrder(int[] matrixSizes) {
        validateInput(matrixSizes);

        int n = matrixSizes.length - 1;
        int[][] M = new int[n + 1][n + 1];
        int[][] S = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                M[i][j] = -1;
            }
        }

        int minCost = matrixChainTopDown(matrixSizes, 1, n, M, S);

        return new MatrixChainOrderExtendedResult(minCost, S);
    }

    /*
    p    tablica rozmiarów macierzy, p.length = n+1
    i    indeks pierwszej macierzy w łańcuchu
    j    indeks ostatniej macierzy w łańcuchu
    M    tablica memo (koszty)
    S    tablica pivotów (miejsce podziału)
    return minimalny koszt wymnożenia macierzy od i do j
     */

    private int matrixChainTopDown(int[] p, int i, int j, int[][] M, int[][] S) {
        if (M[i][j] != -1) {
            return M[i][j];
        }

        if (i == j) {
            M[i][j] = 0;
        } else {
            M[i][j] = Integer.MAX_VALUE;

            for (int k = i; k < j; k++) {
                // Koszt = koszt lewej części + koszt prawej części + koszt wymnożenia wyników
                int costLeft = matrixChainTopDown(p, i, k, M, S);
                int costRight = matrixChainTopDown(p, k + 1, j, M, S);
                int costMultiply = p[i - 1] * p[k] * p[j];

                int totalCost = costLeft + costRight + costMultiply;

                if (totalCost < M[i][j]) {
                    M[i][j] = totalCost;
                    S[i][j] = k;
                }
            }
        }
        return M[i][j];
    }
}
