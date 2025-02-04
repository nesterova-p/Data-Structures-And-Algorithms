package pl.edu.pw.ee.aisd2024zex4;

import static pl.edu.pw.ee.aisd2024zex4.Color.BLACK;
import static pl.edu.pw.ee.aisd2024zex4.Color.RED;
import pl.edu.pw.ee.aisd2024zex4.exceptions.NotYetImplementedException;

public class RedBlackTree<K extends Comparable<K>, V> {

    private Node<K, V> root;
    private int currentNumOfPut = 0;

    public V get(K key) {
        validateKey(key);
        Node<K, V> node = root;

        V result = null;

        while (node != null) {

            if (shouldCheckOnTheLeft(key, node)) {
                node = node.getLeft();

            } else if (shouldCheckOnTheRight(key, node)) {
                node = node.getRight();

            } else {
                result = node.getValue();
                break;
            }
        }
        return result;
    }

    public void put(K key, V value) {
        validateParams(key, value);
        currentNumOfPut = 0;
        root = put(root, key, value);
        root.setColor(BLACK);
    }

    public void deleteMin() {
        if (root == null) {
            return;
        }

        root = deleteMin(root);

        if (root != null) {
            root.setColor(BLACK);
        }
    }

    private void validateKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null.");
        }
    }

    private Node<K, V> deleteMin(Node<K, V> node) {
        if (node == null) {
            return null; // Zabezpieczenie przed operacją na pustym drzewie
        }

        // Krok 1: Sprawdzamy, czy lewy potomek jest czerwony
        if (isRed(node.getLeft())) {
            node = rotateRight(node); // Wykonujemy rotację w prawo
        }

        // Krok 2: Jeśli dotarliśmy do węzła bez lewego potomka, usuwamy go
        if (node.getLeft() == null) {
            return null; // Usunięcie najmniejszego elementu
        }

        // Krok 3: Jeśli lewy i jego lewy nie są czerwone, wymaga to balansowania
        if (!isRed(node.getLeft()) && !isRed(node.getLeft().getLeft())) {
            node = moveRedLeft(node);
        }

        // Krok 4: Rekurencyjne wywołanie na lewym poddrzewie
        node.setLeft(deleteMin(node.getLeft()));

        // Krok 5: Naprawa drzewa po usunięciu
        return fixUp(node);
    }


    private boolean shouldCheckOnTheLeft(K key, Node<K, V> node) {
        return key.compareTo(node.getKey()) < 0;
    }

    private boolean shouldCheckOnTheRight(K key, Node<K, V> node) {
        return key.compareTo(node.getKey()) > 0;
    }

    private void validateParams(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Input params (key, value) cannot be null.");
        }
    }

    private Node<K, V> put(Node<K, V> node, K key, V value) {
        currentNumOfPut++;

        if (node == null) {
            return new Node<>(key, value);
        }

        if (isKeyBiggerThanNode(key, node)) {
            putOnTheRight(node, key, value);

        } else if (isKeySmallerThanNode(key, node)) {
            putOnTheLeft(node, key, value);

        } else {
            node.setValue(value);
        }

        node = reorganizeTree(node);

        return node;
    }

    private boolean isKeyBiggerThanNode(K key, Node<K, V> node) {
        return key.compareTo(node.getKey()) > 0;
    }

    private void putOnTheRight(Node<K, V> node, K key, V value) {
        Node<K, V> rightChild = put(node.getRight(), key, value);
        node.setRight(rightChild);
    }

    private boolean isKeySmallerThanNode(K key, Node<K, V> node) {
        return key.compareTo(node.getKey()) < 0;
    }

    private void putOnTheLeft(Node<K, V> node, K key, V value) {
        Node<K, V> leftChild = put(node.getLeft(), key, value);
        node.setLeft(leftChild);
    }

    private Node<K, V> reorganizeTree(Node<K, V> node) {
        node = rotateLeftIfNeeded(node);
        node = rotateRightIfNeeded(node);
        changeColorsIfNeeded(node);

        return node;
    }

    private Node<K, V> rotateLeftIfNeeded(Node<K, V> node) {
        if (isBlack(node.getLeft()) && isRed(node.getRight())) {
            node = rotateLeft(node);
        }
        return node;
    }

    private Node<K, V> rotateLeft(Node<K, V> node) {
        Node<K, V> head = node.getRight();
        node.setRight(head.getLeft());
        head.setLeft(node);
        head.setColor(node.getColor());
        node.setColor(RED);

        return head;
    }

    private Node<K, V> rotateRightIfNeeded(Node<K, V> node) {
        if (isRed(node.getLeft()) && isRed(node.getLeft().getLeft())) {
            node = rotateRight(node);
        }
        return node;
    }

    private Node<K, V> rotateRight(Node<K, V> node) {
        Node<K, V> head = node.getLeft();
        node.setLeft(head.getRight());
        head.setRight(node);
        head.setColor(node.getColor());
        node.setColor(RED);

        return head; 
    }

    private void changeColorsIfNeeded(Node<K, V> node) {
        if (isRed(node.getLeft()) && isRed(node.getRight())) {
            changeColors(node);
        }
    }

    private void changeColors(Node<K, V> node) {
        swapColor(node);
        swapColor(node.getLeft());
        swapColor(node.getRight());
    }

    private void swapColor(Node<K, V> node) {
        if (node.isRed()) {
            node.setColor(BLACK);
        } else {
            node.setColor(RED);
        }
    }

    private boolean isBlack(Node<K, V> node) {
        return !isRed(node);
    }

    private boolean isRed(Node<K, V> node) {
        return node == null
                ? false
                : node.isRed();
    }

    private Node<K, V> moveRedLeft(Node<K, V> node) {
        changeColors(node); // Zamień kolory, aby przygotować przesunięcie
        if (isRed(node.getRight().getLeft())) {
            node.setRight(rotateRight(node.getRight())); // Rotacja prawego poddrzewa
            node = rotateLeft(node); // Rotacja w lewo
            changeColors(node); // Przywróć kolory
        }
        return node;
    }

    private Node<K, V> fixUp(Node<K, V> node) {
        if (isRed(node.getRight())) {
            node = rotateLeft(node);
        }
        if (isRed(node.getLeft()) && isRed(node.getLeft().getLeft())) {
            node = rotateRight(node);
        }
        if (isRed(node.getLeft()) && isRed(node.getRight())) {
            changeColors(node);
        }
        return node;
    }

}
