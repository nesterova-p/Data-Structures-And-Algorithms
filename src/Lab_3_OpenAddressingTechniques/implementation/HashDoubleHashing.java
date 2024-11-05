package Lab_3_OpenAddressingTechniques.implementation;


public class HashDoubleHashing<T extends Comparable<T>> extends HashOpenAddressing<T> {

    public HashDoubleHashing() {
        super();
    }

    public HashDoubleHashing(int size) {
        super(size);
    }

    @Override
    int hashFunc(int key, int i) {
        int m = getSize();
        int h1 = key % m;
        int h2 = 1 + (key % (m - 1));

        int hash = (h1 + i * h2) % m;

        if (hash < 0) {
            hash += m;
        }
        return hash;
    }
}
