package com.bdg.collections.and.map.map;

import java.util.Objects;

public class HashMap<K, V> {
    Node<K, V> [] array;
    int size;
    int count;

    /**
     * Basic hash bin node, used for most entries.  (See below for
     * TreeNode subclass, and in LinkedHashMap for its Entry subclass.)
     */
    static class Node<K, V> {
        int hash;
        K key;
        V value;
        HashMap.Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public void setValue(V value) {
            this.value = value;
        }
    }



    /**
     * Returns {@code true} if this map contains no key-value mappings.
     *
     * @return {@code true} if this map contains no key-value mappings
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return the number of key-value mappings in this map
     */
    public int size() {
        return size;
    }

    /**
     * Removes all of the mappings from this map.
     * The map will be empty after this call returns.
     */
    public void clear() {
        Node<K, V>[] tab;
        count++;
        if ((tab = array) != null && size > 0) {
            size = 0;
            for (int i = 0; i < array.length; ++i)
                tab[i] = null;
        }
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     *
     * @param  key key whose mapping is to be removed from the map
     * @return the previous value associated with {@code key}, or
     *         {@code null} if there was no mapping for {@code key}.
     *         (A {@code null} return can also indicate that the map
     *         previously associated {@code null} with {@code key}.)
     */
    public V remove(Object key) {
        return (V) key;
    }
}
