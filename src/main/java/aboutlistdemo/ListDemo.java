package aboutlistdemo;

import java.util.Iterator;

public interface ListDemo<E> extends Iterator {
    boolean add(E e);
    void delete(int index);
    E get(int index);
    int size();
    void update(int index, E e);

}
