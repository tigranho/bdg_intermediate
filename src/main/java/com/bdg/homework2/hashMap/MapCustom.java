package com.bdg.homework2.hashMap;

public interface MapCustom<K,V>{
    /**
     * @return the number of key-value mappings in this map
     */
    int size();

    /**
     * Returns {@code true} if this map contains no key-value mappings.
     *
     * @return {@code true} if this map contains no key-value mappings
     */
    boolean isEmpty();

    /**
     * clear this map
     */
    void clear();

    /**
     *
     * @param k
     * @return true if map contains key k,
     * else returns false
     */
    boolean containsKey(K k);

    /**
     *
     * @param v
     * @return true if map contains value V,
     * else returns false
     */
    boolean containsValue(V v);

    /**
     *
     * @param key
     * @return Value through Key
     */
    V get(K key);

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
    void put(K newKey, V data);

    /**
     *
     * @param k
     * @return
     */
    boolean remove(K k);






}
