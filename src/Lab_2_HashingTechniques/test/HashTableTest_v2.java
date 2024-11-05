package Lab_2_HashingTechniques.test;

import Lab_2_HashingTechniques.implementation.HashTable_v2;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest_v2 {

    @Test
    public void testPositiveSize() {
        HashTable_v2<Integer, String> HashTable_v2 = new HashTable_v2<>(5);
        assertNotNull(HashTable_v2);
    }

    @Test
    public void testNegativeSize() {
        HashTable_v2<Integer, String> HashTable_v2 = new HashTable_v2<>(0);
        assertNotNull(HashTable_v2);
    }

    @Test
    public void testAddElement() {
        HashTable_v2<Integer, String> HashTable_v2 = new HashTable_v2<>(5);
        HashTable_v2.add(1, "one");
        assertEquals("one", HashTable_v2.get(1));
        assertEquals(1, HashTable_v2.size());
    }

    // test to check the process of creating a table, adding and deleting elements
    @Test
    public void testHashTable_v2Operations(){
        HashTable_v2<String, String> HashTable_v2 = new HashTable_v2<>(1);
        assertDoesNotThrow(() -> new HashTable_v2<String, String>(1));

        HashTable_v2.add("A", "Value A");
        HashTable_v2.add("B", "Value B");
        HashTable_v2.add("C", "Value C");
        assertEquals(3, HashTable_v2.size());

        HashTable_v2.remove("A");
        assertNull(HashTable_v2.get("A"));
        assertEquals("Value B", HashTable_v2.get("B"));
        assertEquals("Value C", HashTable_v2.get("C"));
        assertEquals(2, HashTable_v2.size());

        HashTable_v2.remove("B");
        assertNull(HashTable_v2.get("B"));
        assertEquals("Value C", HashTable_v2.get("C"));
        assertEquals(1, HashTable_v2.size());

        HashTable_v2.remove("C");
        assertNull(HashTable_v2.get("C"));

        assertEquals(0, HashTable_v2.size());
    }

    // tests for null value (add, remove, get)
    @Test
    public void testNullValueAdding(){
        HashTable_v2<String, String> HashTable_v2 = new HashTable_v2<>(1);
        assertThrows(HeadlessException.class, () -> HashTable_v2.add(null, "V"));
        assertThrows(HeadlessException.class, () -> HashTable_v2.add("K", null));
    }

    @Test
    public void testNullValueGet(){
        HashTable_v2<String, String> HashTable_v2 = new HashTable_v2<>(1);
        assertThrows(HeadlessException.class, () -> HashTable_v2.get(null));
    }

    @Test
    public void testNullValueRemoving(){
        HashTable_v2<String, String> HashTable_v2 = new HashTable_v2<>(1);
        assertThrows(HeadlessException.class, () -> HashTable_v2.remove(null));
    }

    @Test
    public void testLargeDataSetPerformance() {
        HashTable_v2<Integer, Integer> HashTable_v2 = new HashTable_v2<>(1000);
        for (int i = 0; i < 10000; i++) {
            HashTable_v2.add(i, i);
        }
        assertEquals(10000, HashTable_v2.size());
    }


    @Test
    public void testRemoveNonExistent() {
        HashTable_v2<Integer, String> HashTable_v2 = new HashTable_v2<>(1);
        HashTable_v2.add(1, "one");
        HashTable_v2.remove(2);
        assertEquals(1, HashTable_v2.size());
    }

    // size should not increase
    @Test
    public void testAddDuplicateKey() {
        HashTable_v2<Integer, String> HashTable_v2 = new HashTable_v2<>(5);
        HashTable_v2.add(1, "one");
        HashTable_v2.add(1, "newOne");
        assertEquals("newOne", HashTable_v2.get(1));
        assertEquals(1, HashTable_v2.size());
    }

    @Test
    public void testRemoveElementTwice() {
        HashTable_v2<Integer, String> HashTable_v2 = new HashTable_v2<>(5);
        HashTable_v2.add(1, "one");
        HashTable_v2.remove(1);
        HashTable_v2.remove(1);
        assertNull(HashTable_v2.get(1));
    }


}