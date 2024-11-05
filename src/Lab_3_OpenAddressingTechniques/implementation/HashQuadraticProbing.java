package Lab_3_OpenAddressingTechniques.implementation;


public class HashQuadraticProbing<T extends Comparable<T>> extends HashOpenAddressing<T> {

    public HashQuadraticProbing() {
        super();
    }

    public HashQuadraticProbing(int size) {
        super(size);
    }

    @Override
    int hashFunc(int key, int i) {
        int m = getSize();
        int c1 = 1;
        int c2 = 3;

        int hash = (key % m + c1 * i + c2 * i * i) % m;
        if (hash < 0) {
            hash += m;
        }
        return hash;
    }
}
