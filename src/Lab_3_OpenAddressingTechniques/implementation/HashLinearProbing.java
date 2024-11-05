package Lab_3_OpenAddressingTechniques.implementation;

public class HashLinearProbing<T extends Comparable<T>> extends HashOpenAddressing<T> {

    public HashLinearProbing() {
        super();
    }

    public HashLinearProbing(int size) {
        super(size);
    }

    @Override
    int hashFunc(int key, int i) {
        int m = getSize();

        key = key & Integer.MAX_VALUE;

        int hash = (key % m + i) % m;

        return hash;
    }

}
