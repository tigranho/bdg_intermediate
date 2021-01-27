package com.bdg.collections.map;

public class CustomHashMap<K, V> {

    private Entry[] array;
    private static final float DEFAULT_LOAD_FACTOR = 0.75F;
    private float loadFactor;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private int size = 0;

    public CustomHashMap() {
        this.array = new Entry[DEFAULT_INITIAL_CAPACITY];
        loadFactor = DEFAULT_LOAD_FACTOR;
    }

    public CustomHashMap(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        }
        this.array = new Entry[initialCapacity];
        loadFactor = DEFAULT_LOAD_FACTOR;

    }

    public CustomHashMap(int initialCapacity, float loadFactory) {
        this.array = new Entry[initialCapacity];
        this.loadFactor = loadFactory;

    }

    public V put(K key, V value) {
        checkTrashHold();
        int index = getIndex(key);

        Entry newEntry = new Entry(key, value, null);

        Entry current = array[index];
        if (current == null) {
            array[index] = newEntry;
            size++;
            return null;
        }

        Entry previous = array[index];
        while (current != null) {
            if (key.hashCode() == current.key.hashCode()
                    && key.equals(current.key)) {
                V temp = (V) current.value;
                current.value = value;
                size++;
                return temp;
            }

            previous = current;
            current = current.next;
        }

        previous.next = newEntry;
        size++;

        return null;
    }


    public V get(K key) {
        int index = getIndex(key);
        Entry current = array[index];

        while (current != null) {
            if (key.hashCode() == current.key.hashCode()
                    && key.equals(current.key)) {
                return (V) current.value;
            }

            current = current.next;
        }

        return null;
    }

    public V remove(K key) {
        int index = getIndex(key);
        Entry current = array[index];

        Entry previous = current;
        while (current != null) {
            if (key.hashCode() == current.key.hashCode()
                    && key.equals(current.key)) {
                V temp = (V) current.value;

                previous.next = current.next;
                size--;

                return temp;
            }

            previous = current;
            current = current.next;
        }

        return null;
    }

    private void checkTrashHold() {
        int trashHold = (int) (array.length * loadFactor);
        if (size == 0) {
            return;
        }
        if (size == trashHold) {
            rehash();
        }
    }

    private void rehash() {

        Entry[] temp = new Entry[DEFAULT_INITIAL_CAPACITY * 2];
        System.arraycopy(array, 0, temp, 0, size);
        array = temp;
    }

    private int getIndex(K key) {
        return key == null ? 0 : key.hashCode() & (array.length - 1);
    }

    @Override
    public String toString() {
        StringBuilder builder = getStringBuilder();
        return builder.toString();
    }

    private StringBuilder getStringBuilder() {
        int count = 0;
        StringBuilder builder = new StringBuilder();
        for (Entry item : array) {
            if (item == null) {
                continue;
            }


            Entry current = item;
            while (current != null) {
                count++;
                builder.append("[");
                builder.append(current.key + "=" + current.value);
                builder.append("]");
                current = current.next;
            }


        }
        if (count == 0) {
            builder.append("[]");
        }
        return builder;
    }

    public void print() {
        for (Entry item : array) {
            if (item == null) {
                System.out.println("[]");
                continue;
            }

            System.out.print("[");

            Entry current = item;
            while (current != null) {
                System.out.print(current.key + ":" + current.value + " => ");
                current = current.next;
            }
            System.out.print("]");
            System.out.println();
        }


    }

    public void clear() {
        CustomHashMap.Entry[] tab;

        if (this.array != null && this.size > 0) {
            this.size = 0;
            tab = array;

            for (int i = 0; i < array.length; ++i) {
                tab[i] = null;
            }
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }


    class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }
}
