package pl.edu.pw.ee.aisd2024zex6.matrixchainorder;

public class MatrixChainOrderExtendedResult extends MatrixChainOrderResult {

    private final int[][] solutions;

    public MatrixChainOrderExtendedResult(int minMultiplyCost, int[][] solutions) {
        super(minMultiplyCost);
        this.solutions = solutions;
    }

    /*
    Zwraca tekstowa reprezentacje optymalnego nawiasowania lancucha macierzy na podstawie tabl solutions
     */
    public String reconstructOptimalSolutions() {
        // bottom-up- ciąg macierzy od 1 do (solutions[0].length - 1.
        int n = solutions[0].length - 1;
        return buildOptimalParenthesization(1, n);
    }

    /* rekurencyjna met odtwarza nawiasowanie dla łańcucha (i..j)
     */
    private String buildOptimalParenthesization(int i, int j) {
        // war bazowy: tylko 1 macierz
        if (i == j) {
              return "A" + i;
        }
        // pobieramy pivot
        int pivot = solutions[i][j];

        // sklejenie nawiasowania lewej i prawej strony
        String leftPart = buildOptimalParenthesization(i, pivot);
        String rightPart = buildOptimalParenthesization(pivot + 1, j);

        return "(" + leftPart + " x " + rightPart + ")";
    }

    public int[][] getSolutions() {
        return solutions;
    }

    public static void main(String[] args) {
        int numberOfMatrices = 4;
        int[][] solutions = new int[numberOfMatrices + 1][numberOfMatrices + 1];
        // A1..A4 dzielimy na A1..A2 i A3..A4 (pivot=2)
        // A1..A2 dzielimy na A1 i A2 (pivot=1)
        // A3..A4 dzielimy na A3 i A4 (pivot=3)
        for (int i = 1; i <= numberOfMatrices; i++) {
            solutions[i][i] = i;
        }

        solutions[1][2] = 1;
        solutions[1][3] = 1;
        solutions[1][4] = 2;
        solutions[2][3] = 2;
        solutions[2][4] = 2;
        solutions[3][4] = 3;

        // Przykładowy koszt minimalny mnożeń
        int minMultiplyCost = 2010;

        MatrixChainOrderExtendedResult result = new MatrixChainOrderExtendedResult(minMultiplyCost, solutions);

        String optimalParenthesization = result.reconstructOptimalSolutions();

        System.out.println("Optymalne nawiasowanie: " + optimalParenthesization);
        System.out.println("Minimalny koszt mnożeń: " + result.getMinMultiplyCost());
    }

}
