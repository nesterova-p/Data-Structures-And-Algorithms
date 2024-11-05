package Lab_3_OpenAddressingTechniques.implementation;

import Lab_3_OpenAddressingTechniques.implementation.services.HashTable;

public abstract class HashOpenAddressing<T extends Comparable<T>> implements HashTable<T> {

    private final T nil = null;
    private int size;
    private int nElems;
    private T[] hashElems;
    private final double correctLoadFactor;

    HashOpenAddressing() {
        this(2039); // initial size as random prime number
    }

    HashOpenAddressing(int size) {
        validateHashInitSize(size);

        this.size = size;
        this.hashElems = createTable(this.size);
        this.correctLoadFactor = 0.75;
    }

    @Override
    public void put(T newElem) {
        validateInputElem(newElem);
        resizeIfNeeded();

        int key = newElem.hashCode();
        int i = 0;
        int hashId = hashFunc(key, i);

        while (hashElems[hashId] != nil && !hashElems[hashId].equals(newElem)) {
            i++;
            if (i == size) {
                doubleResize();
                i = 0;
            }
            hashId = hashFunc(key, i);
        }

        if (hashElems[hashId] == nil) {
            nElems++;
        }

        hashElems[hashId] = newElem;
    }

    @Override
    public T get(T elem) {
        validateInputElem(elem);

        int key = elem.hashCode();
        int i = 0;
        int hashId = hashFunc(key, i);

        while (hashElems[hashId] != nil) {
            if (hashElems[hashId].equals(elem)) {
                return hashElems[hashId];
            }
            i++;
            if (i == size) {
                break;
            }
            hashId = hashFunc(key, i);
        }
        return null;
    }

    @Override
    public void delete(T elem) {
        validateInputElem(elem);

        int key = elem.hashCode();
        int i = 0;
        int hashId = hashFunc(key, i);

        while (hashElems[hashId] != nil) {
            if (hashElems[hashId].equals(elem)) {
                hashElems[hashId] = nil;
                nElems--;
                return;
            }
            i++;
            if (i == size) {
                break;
            }
            hashId = hashFunc(key, i);
        }
        throw new IllegalArgumentException("Element not found in hash table.");
    }

    public void clear() {
        hashElems = createTable(size);
        nElems = 0;
    }

    public boolean contains(T elem) {
        return get(elem) != null;
    }

    public int size() {
        return nElems;
    }

    private void validateHashInitSize(int initialSize) {
        if (initialSize < 1) {
            throw new IllegalArgumentException("Initial size of hash table cannot be lower than 1!");
        }
    }

    private void validateInputElem(T newElem) {
        if (newElem == null) {
            throw new IllegalArgumentException("Input elem cannot be null!");
        }
    }

    abstract int hashFunc(int key, int i);

    int getSize() {
        return size;
    }

    private T[] createTable(int size) {
        return (T[]) new Comparable[size];
    }

    private void resizeIfNeeded() {
        double loadFactor = countLoadFactor();

        if (loadFactor >= correctLoadFactor) {
            doubleResize();
        }
    }

    private double countLoadFactor() {
        return (double) nElems / size;
    }

    private void doubleResize() {
        this.size *= 2;

        T[] oldElems = hashElems;
        hashElems = createTable(size);
        nElems = 0;

        for (T currentElem : oldElems) {
            if (currentElem != nil) {
                put(currentElem);
            }
        }
    }
}
