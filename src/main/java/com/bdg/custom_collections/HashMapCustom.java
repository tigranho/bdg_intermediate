package com.bdg.custom_collections;

/**
 * @param <K>
 * @param <V>
 * @author Artur
 * This class provides custom implementation of HashMap()
 * which allows us to store data in key-value pair form.
 */
public class HashMapCustom<K, V> {
    private Entry[] table;   //Array of Entry.
    private int capacity = 4;  //Initial capacity of HashMap

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public HashMapCustom() {
        table = new Entry[capacity];
    }

    /**
     * Method allows you put key-value pair in HashMapCustom.
     * If the map already contains a mapping for the key, the old value is replaced.
     * Note: method does not allows you to put null key though it allows null values.
     * Implementation allows you to put custom objects as a key as well.
     *
     * @param newKey
     * @param data
     */
    public void put(K newKey, V data) {
        if (newKey == null)
            return;
        //calculate hash of key.
        int hash = hash(newKey);
        //create new entry.
        Entry<K, V> newEntry = new Entry<K, V>(newKey, data, null);

        //if table location does not contain any entry, store entry there.
        if (table[hash] == null) {
            table[hash] = newEntry;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];

            while (current != null) { //we have reached last entry of bucket.
                if (current.key.equals(newKey)) {
                    if (previous == null) {  //node has to be insert on first of bucket.
                        newEntry.next = current.next;
                        table[hash] = newEntry;
                        return;
                    } else {
                        newEntry.next = current.next;
                        previous.next = newEntry;
                        return;
                    }
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
        }
    }

    /**
     * Method removes key-value pair from HashMapCustom.
     *
     * @param deleteKey
     */
    public boolean remove(K deleteKey) {

        int hash = hash(deleteKey);

        if (table[hash] == null) {
            return false;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];

            while (current != null) { //we have reached last entry node of bucket.
                if (current.key.equals(deleteKey)) {
                    if (previous == null) {  //delete first entry node.
                        table[hash] = table[hash].next;
                        return true;
                    } else {
                        previous.next = current.next;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }
            return false;
        }

    }

    /**
     * Method displays all key-value pairs present in HashMapCustom.
     */
    public void display() {

        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                Entry<K, V> entry = table[i];
                while (entry != null) {
                    System.out.print("{" + entry.key + "=" + entry.value + "}" + " ");
                    entry = entry.next;
                }
            }
        }

    }

    /**
     * Method implements hashing functionality, which helps in finding the appropriate
     * bucket location to store our data.
     *
     * @param key
     */
    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }
}


class Entry<K, V> {
    K key;
    V value;
    HashMapCustom.Entry<K, V> next;

    public Entry(K key, V value, HashMapCustom.Entry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
