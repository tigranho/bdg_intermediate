package customDataStructures;

import java.util.HashMap;

public class CustomHashMap<K, V> extends HashMap<K, V> {
    private int size = 0;
    private Node<K, V>[] entities = new Node[10];


    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the value to which the specified key is mapped,
     * or {@code null} if this map contains no mapping for the key.
     *
     * <p>More formally, if this map contains a mapping from a key
     * {@code k} to a value {@code v} such that {@code (key==null ? k==null :
     * key.equals(k))}, then this method returns {@code v}; otherwise
     * it returns {@code null}.  (There can be at most one such mapping.)
     *
     * <p>A return value of {@code null} does not <i>necessarily</i>
     * indicate that the map contains no mapping for the key; it's also
     * possible that the map explicitly maps the key to {@code null}.
     * The {@link #containsKey containsKey} operation may be used to
     * distinguish these two cases.
     *
     * @see #put(Object, Object)
     */
    @Override
    public V get(Object key) {
        int hash = key.hashCode() % entities.length;
        if (!(key.getClass().isAssignableFrom(entities[hash].key.getClass()))) {
            throw new ClassCastException();
        }
        Node<K, V> currentNode = entities[hash];
        while (currentNode != null) {
            if (currentNode.key == key) {
                return currentNode.value;
            } else {
                currentNode = currentNode.next;
            }
        }
        return null;
    }

    private void checkForNullAndCast(Object key) {
        int hash = key.hashCode() % entities.length;
        if (entities[hash] == null) {
            throw new NullPointerException();
        }
        if (!(key.getClass().isAssignableFrom(entities[hash].key.getClass()))) {
            throw new ClassCastException();
        }
    }

    @Override
    public boolean containsKey(Object key) {
        int hash = key.hashCode() % entities.length;
        Node<K, V> currentNode = entities[hash];
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old
     * value is replaced.
     *
     * @param key   key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with {@code key}, or
     * {@code null} if there was no mapping for {@code key}.
     * (A {@code null} return can also indicate that the map
     * previously associated {@code null} with {@code key}.)
     */
    @Override
    public V put(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value, null);
        int hash = key.hashCode() % entities.length;
        if (entities[hash] == null) {
            entities[hash] = newNode;
        } else {
            Node<K, V> currentNode = entities[hash];
            Node<K, V> oldNode = currentNode;
            while (currentNode != null) {
                if (currentNode.key == newNode.key) {
                    V oldValue = currentNode.value;
                    currentNode.value = newNode.value;
                    return oldValue;
                } else {
                    oldNode = currentNode;
                    currentNode = currentNode.next;
                }
            }
            oldNode.next = newNode;
        }
        size++;
        return null;
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     *
     * @param key key whose mapping is to be removed from the map
     * @return the previous value associated with {@code key}, or
     * {@code null} if there was no mapping for {@code key}.
     * (A {@code null} return can also indicate that the map
     * previously associated {@code null} with {@code key}.)
     */
    @Override
    public V remove(Object key) {
        checkForNullAndCast(key);
        int hash = key.hashCode() % entities.length;
        Node<K, V> currentNode;
        Node<K, V> prevNode;

        if (entities[hash].key == key) {
            prevNode = entities[hash];
            entities[hash] = prevNode.next;
            size--;
            return prevNode.value;
        } else {
            currentNode = entities[hash].next;
            prevNode = entities[hash];
            while (currentNode != null) {
                if (currentNode.key == key) {
                    prevNode.next = currentNode.next;
                    size--;
                    return currentNode.value;
                }
                currentNode = currentNode.next;
            }
        }
        return null;
    }

    /**
     * Removes all of the mappings from this map.
     * The map will be empty after this call returns.
     */
    @Override
    public void clear() {

        Node<K, V> currentNode;
        for (int i = 0; i < entities.length; i++) {
            currentNode = entities[i];
            while (currentNode != null) {
                Node<K, V> nextNode = currentNode.next;
                currentNode.next = null;
                currentNode = nextNode;
                size--;
            }
            entities[i] = null;
        }
    }

    @Override
    public boolean containsValue(Object value) {
        for (int i = 0; i < entities.length; i++) {
            Node<K, V> currentNode = entities[i];
            while (currentNode != null) {
                if (currentNode.value.equals(value)) {
                    return true;
                }
                currentNode = currentNode.next;
            }
        }
        return false;
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        int hash = key.hashCode() % entities.length;
        if (entities[hash] == null) {
            throw new NullPointerException();
        }
        Node<K, V> currentNode = entities[hash];
        while (currentNode != null) {
            if (currentNode.key == key && currentNode.value == oldValue) {
                currentNode.value = newValue;
                return true;
            } else {
                currentNode = currentNode.next;
            }
        }
        return false;
    }

    @Override
    public V replace(K key, V value) {
        int hash = key.hashCode() % entities.length;
        if (entities[hash] == null) {
            throw new NullPointerException();
        }
        Node<K, V> currentNode = entities[hash];
        while (currentNode != null) {
            if (currentNode.key == key) {
                V oldValue = currentNode.value;
                currentNode.value = value;
                return oldValue;
            } else {
                currentNode = currentNode.next;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (isEmpty()) {
            str.append("HashMap is Empty");
        } else {
            Node<K, V> currentNode;
            for (int i = 0; i < entities.length; i++) {
                currentNode = entities[i];
                while (currentNode != null) {
                    str.append(currentNode.value);
                    str.append(" ");
                    currentNode = currentNode.next;

                }
            }
        }
        return str.toString();
    }
}
