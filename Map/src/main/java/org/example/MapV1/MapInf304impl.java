package org.example.MapV1;

import java.util.*;

public class MapInf304impl<K extends Number & Comparable<K>, V> implements MapInf304<K, V>{

    LinkedList<Node<K, V>> list = new LinkedList<>();
    public MapInf304impl() {}
    @Override
    public V put(K key, V value) {
        Node<K, V> cur = new Node<>(key, value);
        if (containsKey(key)) {
            for(Node<K, V> node : list) {
                if (key.equals(node.key)) {
                    V res = node.value;
                    node.value = value;
                    return res;
                }
            }
        } else {
            list.add(cur);
        }
        return cur.value;
    }

    @Override
    public V get(K key) {
        for(Node<K, V> node : list) {
            if (key.equals(node.key)) {
                return node.value;
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        for(Node<K, V> node : list) {
            if (key.equals(node.key)) {
                V res = node.value;
                list.remove(node);
                return res;
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        for(Node<K, V> node : list) {
            if (key.equals(node.key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> arrayList = new ArrayList<>();
        for (Node<K, V> Node : list) {
            arrayList.add(Node.value);
        }
        return arrayList;
    }

    @Override
    public Set<K> keySet() {
        Set<K> arrayList = new HashSet<>();
        for (Node<K, V> Node : list) {
            arrayList.add(Node.key);
        }
        return arrayList;
    }

    public void print() {
        for(Node<K, V> node : list) {
            System.out.println(node.key + " " + node.value);
        }
    }
}
