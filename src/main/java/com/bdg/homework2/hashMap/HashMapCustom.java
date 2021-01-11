package com.bdg.homework2.hashMap;

import java.util.Arrays;

/**
 * @author Ara Chilingaryan
 * This class provides custom implementation of HashMap
 * which allows us to store data in key-value pair form.
 * insertion order of key-value pairs is not maintained.
 * @param <K>
 * @param <V>
 */
class HashMapCustom<K, V>  implements MapCustom<K,V> {

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

    private Entry<K, V>[] table;   //Array of Entry.
    private int capacity = 4;  //Initial capacity of HashMap
    private int size = 0;

    /**
     * @return the number of key-value mappings in this map
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    /**
     * Returns {@code true} if this map contains no key-value mappings.
     *
     * @return {@code true} if this map contains no key-value mappings
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Removes all of the mappings from this map.
     * The map will be empty after this call returns.
     */
    @Override
    public void clear() {
        for (int i = 0; i < this.table.length; i++) {
            this.table[i] = null;
        }
       size = 0;
    }

    /**
     *
     * @param k
     * @return true if hashmap contains key,else false
     */

    @Override
    public boolean containsKey(K k) {
        int hash = hash(k);
        if (table[hash] == null) {
            return false;
        } else {
            Entry<K, V> temp = table[hash];
            while (temp != null) {
                if (temp.key.equals(k))
                    return true;
                temp = temp.next; //return value corresponding to key.
            }
            return false; //returns false if key is not found.
        }
    }

    /**
     *
     * @param value
     * @return true if hashmap contains value, else false
     */

    @Override
    public boolean containsValue(V value) {
        Entry<K,V>[] tab; V v;
        if ((tab = table) != null && table.length > 0) {
            for (Entry<K,V> e : tab) {
                for (; e != null; e = e.next) {
                    if ((v = e.value) == value ||
                            (value != null && value.equals(v)))
                        return true;
                }
            }
        }
        return false;
    }


    @SuppressWarnings("unchecked")
    public HashMapCustom(){
        table = new Entry[capacity];
    }



    /**
     * Method allows you put key-value pair in HashMapCustom.
     * If the map already contains a mapping for the key, the old value is replaced.
     * Note: method does not allows you to put null key though it allows null values.
     * Implementation allows you to put custom objects as a key as well.
     * Key Features: implementation provides you with following features:-
     *     >provide complete functionality how to override equals method.
     *  >provide complete functionality how to override hashCode method.
     * @param newKey
     * @param data
     */
    @Override
    public void put(K newKey, V data){
        if(newKey == null)
            return;    //does not allow to store null.

        //calculate hash of key.
        int hash = hash(newKey);
        //create new entry.
        Entry<K,V> newEntry = new Entry<K,V>(newKey, data, null);

        //if table location does not contain any entry, store entry there.
        if(table[hash] == null){
            table[hash] = newEntry;
            size++;
        }else{
            Entry<K,V> previous = null;
            Entry<K,V> current = table[hash];

            while(current != null){ //we have reached last entry of bucket.
                if(current.key.equals(newKey)){
                    if(previous == null){  //node has to be insert on first of bucket.
                        newEntry.next = current.next;
                        table[hash] = newEntry;
                        size++;
                        return;
                    }
                    else{
                        newEntry.next = current.next;
                        previous.next = newEntry;
                        size++;
                        return;
                    }
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
            size++;
        }
    }

    /**
     * Method returns value corresponding to key.
     * @param key
     */
    public V get(K key){
        int hash = hash(key);
        if(table[hash] == null){
            return null;
        }else{
            Entry<K,V> temp = table[hash];
            while(temp != null){
                if(temp.key.equals(key))
                    return temp.value;
                temp = temp.next; //return value corresponding to key.
            }
            return null;   //returns null if key is not found.
        }
    }


    /**
     * Method removes key-value pair from HashMapCustom.
     * @param deleteKey
     */
    public  boolean remove(K deleteKey){

        int hash=hash(deleteKey);

        if(table[hash] == null){
            return false;
        }else{
            Entry<K,V> previous = null;
            Entry<K,V> current = table[hash];

            while(current != null){ //we have reached last entry node of bucket.
                if(current.key.equals(deleteKey)){
                    if(previous == null){  //delete first entry node.
                        table[hash] = table[hash].next;
                        size--;
                        return true;
                    }
                    else{
                        previous.next = current.next;
                        size--;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
                size--;
            }
            return false;
        }

    }


    /**
     * Method displays all key-value pairs present in HashMapCustom.,
     * insertion order is not guaranteed, for maintaining insertion order
     * refer LinkedHashMapCustom.
     *
     */
    public void display(){

        for(int i = 0; i < capacity; i++){
            if(table[i] != null){
                Entry<K, V> entry = table[i];
                while(entry != null){
                    System.out.print("{"+entry.key + "=" + entry.value+"}" +" ");
                    entry = entry.next;
                }
            }
        }

    }
    /**
     * Method implements hashing functionality, which helps in finding the appropriate
     * bucket location to store our data.
     * This is very important method, as performance of HashMapCustom is very much
     * dependent on  this method's implementation.
     * @param key
     */
    private int hash(K key){
        return Math.abs(key.hashCode()) % capacity;
    }

}