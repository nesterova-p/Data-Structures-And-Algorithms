package Lab_2_HashingTechniques.implementation;

import java.awt.*;
import java.util.LinkedList;

public class HashTable_v2<K,V> {
    public LinkedList<Node<K,V>>[] table;
    private int size;

    public static class Node<K,V>{
        K key;
        V value;

        Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    // Hash table constructor
    public HashTable_v2(int capacity){
        if (capacity < 1 ) System.out.println("Table size must be greater than 0 ");
        table = new LinkedList[capacity];
        size = 0; // number of elements
    }

    // hash function
    private int hash(K key){
        // Math.abs to make sure the value is positive & remember that we have to divide by the length of the table
        return Math.abs(key.hashCode() % table.length);
    }

    // adding elements
    public void add(K key, V value){
        if(key == null || value == null) throw new HeadlessException("Key or value cannot be null");
        int index = hash(key);
        if(table[index] == null){
            table[index] = new LinkedList<>();
        }
        for (Node<K,V> node : table[index]){
            if (node.key.equals(key)){
                node.value = value;
                return;
            }
        }
        table[index].add(new Node<>(key,value));
        size++;
    }

    // getting value
    public V get(K key){
        if (key == null) throw new HeadlessException("Key cannot be null");
        int index = hash(key);
        LinkedList<Node<K,V>> bucket = table[index];
        if(bucket != null){
            for(Node<K,V> node : table[index]){
                if(node.key.equals(key)){
                    return node.value;
                }
            }
        }
        return null;
    }

    public int size(){
        return size;
    }

    // removing values
    public void remove(K key){
        if (key == null) throw new HeadlessException("Key cannot be null");
        int  index = hash(key);
        LinkedList<Node<K,V>> bucket = table[index];
        if(bucket != null){
            for(Node<K,V> node :bucket){
                if(node.key.equals(key)){
                    bucket.remove(node);
                    size--;
                    return;
                }
            }
        }
    }


}
