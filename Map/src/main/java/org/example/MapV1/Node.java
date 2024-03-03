package org.example.MapV1;

public class Node<K extends Comparable<K>, V> implements Comparable<Node<K, V>>{
    public K key;
    public V value;
    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node<K, V> o) {
        return this.key.compareTo(o.key);
    }
}
