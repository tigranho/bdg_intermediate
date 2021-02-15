package aboutlistdemo;

import java.util.Iterator;
public class ArrayListDemo<E> implements ListDemo<E>{

    private E[] values;

    public ArrayListDemo(){
    values = (E[]) new Object[0];
    }
    @Override
    public boolean add(E e) {
        try{
            E[] temp= values;
            values = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = e;
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }
    @Override
    public void delete(int index) {
        try{E[] temp= values;
            values = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, index);
            int amountElementAftherIndex = temp.length - index - 1;
            System.arraycopy(temp, index + 1, values, index, amountElementAftherIndex);

        }catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    @Override
    public E get(int index) {
        return values[index];
    }
    @Override
    public int size() {
        return values.length;
    }
    @Override
    public void update(int index, E e) {
        values[index] = e;
    }
    @Override
    public boolean hasNext() {
        return false;
    }
    @Override
    public Object next() {
        return null;
    }
    @Override
    public void remove() {

    }
    public Iterator<E> iterator(){
        return new ArrayIterator<>(values);
    }
}
