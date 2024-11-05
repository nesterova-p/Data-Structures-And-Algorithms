package Lab_2_HashingTechniques.test.utils;

import Lab_2_HashingTechniques.implementation.HashListChaining;
import Lab_2_HashingTechniques.implementation.services.HashTable;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static Lab_2_HashingTechniques.test.utils.AdvancedConstructors.createHashInstance;
import static Lab_2_HashingTechniques.test.utils.AdvancedGetters.getHashElemById;
import static Lab_2_HashingTechniques.test.utils.AdvancedGetters.getNumOfElems;
import static org.junit.jupiter.api.Assertions.*;

public abstract class GeneralHashListChainingTest {

    private final Class<? extends HashListChaining> hashListClass;
    private HashTable<String> hashString;

    public GeneralHashListChainingTest(Class<? extends HashListChaining> hashListClass) {
        this.hashListClass = hashListClass;
    }

    @Before
    public void setup() {
        hashString = createHashInstance(hashListClass);
    }

    @Test
    public void should_ThrowException_WhenTryingAddNullValue() {
        // given
        String nullValue = null;

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            hashString.add(nullValue);
        });
        assertEquals("Value of elem in hash table cannot be null!", exception.getMessage());
    }

    @Test
    public void should_ThrowException_WhenTryingGetNullValue() {
        // given
        String nullValue = null;
        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            hashString.get(nullValue);
        });
        assertEquals("Value of elem in hash table cannot be null!", exception.getMessage());
    }

    @Test
    public void should_ThrowException_WhenTryingToCreateHashWithSizeEqualZero() {
        // given
        int size = 0;

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            createHashInstance(size, hashListClass);
        });
        assertEquals("Hash size cannot be less than \"1\"!", exception.getMessage());
    }

    @Test
    public void should_ReturnCorrectSize_AfterAddingElement() {
        // given
        String value = "Ala";

        // when
        int nOfElemsBeforeAdd = getNumOfElems(hashString);
        hashString.add(value);
        int nOfElemsAfterAdd = getNumOfElems(hashString);

        // then
        assertEquals(0, nOfElemsBeforeAdd);
        assertEquals(1, nOfElemsAfterAdd);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 100, 1000})
    void should_NotThrowException_WhenCreatingHashWithSizeBiggerThanZero(int hashSize) {
        // given, when & then
        createHashInstance(hashSize, hashListClass);
        assertTrue(true);
    }

    @Test
    public void should_ReturnCorrectValue_WhenHeapIsNotEmpty() {
        // given
        hashString.add("Ala");
        hashString.add("Ola");
        hashString.add("Ewa");

        // when
        String returnedName = hashString.get("Ola");

        // then
        assertEquals("Ola", returnedName);
    }

    @Test
    public void should_CorrectlyAddThreeDifferentElems_WhenHashSizeIsOne() {
        // given
        int hashSize = 1;
        HashTable<String> names = createHashInstance(hashSize, hashListClass);
        names.add("Ola");
        names.add("Ala");
        names.add("Ula");

        // when
        int nOfElemsInHash = getNumOfElems(names);
        String firstName = getHashElemById(names, 0);
        String secondName = getHashElemById(names, 1);
        String thirdName = getHashElemById(names, 2);

        // then
        assertEquals(3, nOfElemsInHash);
        assertEquals("Ula", firstName);
        assertEquals("Ala", secondName);
        assertEquals("Ola", thirdName);
    }
}
