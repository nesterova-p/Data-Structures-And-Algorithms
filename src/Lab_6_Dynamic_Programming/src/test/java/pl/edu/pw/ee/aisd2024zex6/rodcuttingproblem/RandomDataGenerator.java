package pl.edu.pw.ee.aisd2024zex6.rodcuttingproblem;

import java.util.Random;

public class RandomDataGenerator {
    private final Random random;

    public RandomDataGenerator() {
        this.random = new Random();
    }

    /*
     Generuje tablicę cen dla każdej długości pręta od 1 do n.
     n długość pręta
     maxPrice maksymalna cena dla jednego kawałka
     return tablica cen o długości n
     */
    public int[] generatePrices(int n, int maxPrice) {
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = random.nextInt(maxPrice) + 1;
        }
        return prices;
    }
}
