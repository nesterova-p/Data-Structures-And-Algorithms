package Lab_3_OpenAddressingTechniques.test;

import Lab_3_OpenAddressingTechniques.implementation.HashLinearProbing;
import Lab_3_OpenAddressingTechniques.implementation.HashOpenAddressing;
import Lab_3_OpenAddressingTechniques.implementation.services.HashTable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class GeneralHashTableTest<T extends Comparable<T>> {

    protected HashOpenAddressing<T> hashTable;

    public GeneralHashTableTest(HashOpenAddressing<T> hashTable) {
        this.hashTable = hashTable;
    }

    @Before
    public void setup() {
        hashTable.clear();
    }

    @Test
    public void should_ThrowException_WhenInitialSizeIsLowerThanOne() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new HashLinearProbing<>(0);
        });
        assertEquals("Initial size of hash table cannot be lower than 1!", exception.getMessage());
    }

    @Test
    public void should_CorrectlyAddNewElements_WhenNotExistInHashTable() {
        T newElem = (T) "P. Czarnek";

        int nOfElemsBeforePut = getNumOfElems(hashTable);
        hashTable.put(newElem);
        int nOfElemsAfterPut = getNumOfElems(hashTable);

        assertEquals(0, nOfElemsBeforePut);
        assertEquals(1, nOfElemsAfterPut);
    }

    @Test
    public void should_CorrectlyRemoveElement_WhenExistsInHashTable() {
        T elem = (T) "ToRemove";
        hashTable.put(elem);

        assertTrue(hashTable.contains(elem));
        hashTable.delete(elem);
        assertFalse(hashTable.contains(elem));
    }

    @Test
    public void should_ReturnCorrectElement_WhenItExistsInHashTable() {
        T elem = (T) "ToFind";
        hashTable.put(elem);

        assertEquals(elem, hashTable.get(elem));
    }

    @Test
    public void should_ReturnNull_WhenElementNotInHashTable() {
        assertNull(hashTable.get((T) "NotInTable"));
    }

    @Test
    public void should_HandleCollisionsCorrectly() {
        T elem1 = (T) "Elem1";
        T elem2 = (T) "Elem2";

        hashTable.put(elem1);
        hashTable.put(elem2);

        assertEquals(elem1, hashTable.get(elem1));
        assertEquals(elem2, hashTable.get(elem2));
    }

    @Test
    public void should_CorrectlyUpdateElement_WhenAddingDuplicate() {
        T elem = (T) "Duplicate";
        hashTable.put(elem);
        hashTable.put(elem);

        int numOfElems = getNumOfElems(hashTable);
        assertEquals(1, numOfElems);
    }

    private int getNumOfElems(HashOpenAddressing<T> hashTable) {
        return hashTable.size();  // Zakładając metodę size(), lub zaktualizuj na podstawie implementacji
    }
}
