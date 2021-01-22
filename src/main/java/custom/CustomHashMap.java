package custom;

import java.util.*;

public class CustomHashMap<K, V> implements Map<K,V> {
    private int size = 0;
    private  static int default_capacity = 16;
    private Entry<K,V> arr[];



   public CustomHashMap(){
      arr=new Entry[default_capacity];
  }

  public CustomHashMap(int capacity){
       arr=new Entry[capacity];

  }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    private int hash(Object k) {
        return Objects.hash(k) % arr.length;
    }


    public void print() {
        System.out.println(Arrays.toString(arr));
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return null;
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
        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;

            }

            if (!(o instanceof Entry)) {
                return false;
            }

            Entry e = (Entry) o;
            return Objects.equals(e.key, this.key)
                    && Objects.equals(e.value, this.value);
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.key, this.value);
        }
    }
}