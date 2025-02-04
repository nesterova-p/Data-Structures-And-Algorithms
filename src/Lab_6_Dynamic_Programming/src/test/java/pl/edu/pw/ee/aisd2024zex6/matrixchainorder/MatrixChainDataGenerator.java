package pl.edu.pw.ee.aisd2024zex6.matrixchainorder;

import java.util.Random;

public class MatrixChainDataGenerator {

    private final Random random;

    public MatrixChainDataGenerator() {
        this.random = new Random();
    }

    /*
     Generuje tablicę rozmiarów macierzy dla łańcucha N macierzy,
     czyli zwraca tablicę długości N+1.
     każdy rozmiar jest w zakresie [minDim, maxDim].
     */
    public int[] generateRandomMatrixSizes(int n, int minDim, int maxDim) {
        int[] sizes = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            sizes[i] = random.nextInt(maxDim - minDim + 1) + minDim;
        }
        return sizes;
    }

    /*
     Generuje tablicę rozmiarów macierzy, w której wszystkie wymiary są równe "dim"
     długość zwracanej tablicy to N+1.
     */
    public int[] generateUniformMatrixSizes(int n, int dim) {
        int[] sizes = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            sizes[i] = dim;
        }
        return sizes;
    }
}
