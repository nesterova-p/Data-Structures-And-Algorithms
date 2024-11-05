package Lab_2_HashingTechniques.implementation;

public class HashListChainingMultiplicativeHashing<T extends Comparable<T>> extends HashListChaining<T> {

    public HashListChainingMultiplicativeHashing() {
        super();
    }

    public HashListChainingMultiplicativeHashing(int size) {
        super(size);
    }


    @Override
    int countHashId(T value) {
        int hashCode = value.hashCode();
        double A = (Math.sqrt(7) - 1) / 2; // A constant for multiplicative hashing
        double fractionalPart = (hashCode * A) % 1; // Multiply and take the fractional part

        // Ensure the fractional part is non-negative
        if (fractionalPart < 0) {
            fractionalPart += 1;
        }

        int index = (int) (fractionalPart * size); // Scale to the array size

        index = index % size;

        return index;
    }
}
