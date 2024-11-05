package Lab_3_OpenAddressingTechniques.implementation.services;

public interface HashTable<T extends Comparable<T>> {

    void put(T newElem);

    T get(T elem);

    void delete(T elem);

}
