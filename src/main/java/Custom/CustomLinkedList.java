package Custom;

import java.util.*;

class Test{
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list);


        list.remove(2);
        System.out.println(list);

        System.out.println( list.get(0) );
       System.out.println( list.get(1) );


        System.out.println(list.size());
      //  list.clear();
        //System.out.println(list);
        System.out.println(list.isEmpty());

    }
}
public class  CustomLinkedList<E>  implements List<E> {

    private static int counter;
    private Node<E> head;

     public  CustomLinkedList(){

     }


      class Node<E> {

         private Object data;
        private Node<E> next;

        Node(Object dataValue)
        {
            data = dataValue;
            next = null;
        }

        Node(Object dataValue,Node nextValue){
            data=dataValue;
            next=nextValue;
        }

         public Object getData() {
             return data;
         }

         public void setData(Object data) {
             this.data = data;
         }


         public Node<E> getNext() {
             return next;
         }

         public void setNext(Node<E> next)
         {
             this.next = next;
         }
     }



    @Override
    public int size()
    {
        return counter;
    }

    @Override
    public boolean isEmpty()
    {
        return counter==0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {

        if(head==null){
            this.head = new Node<>(e);
            counter++;
            return true;
        }
        Node temp = head;
        while(temp.getNext()!=null){
            temp = temp.getNext();
        }
        temp.setNext(new Node<>(e));
        counter++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {

        int currentIndex = 0;
        Node temp = head;
        while(temp!=null){
            if(currentIndex == index){
                return (E) temp.getData();
            }else{
                temp = temp.getNext();
                currentIndex++;
            }

        }
        throw new IllegalArgumentException();

}

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {
        Node crunchifyTemp = new Node(element);
        Node crunchifyCurrent = head;

        if (crunchifyCurrent != null) {
            for (int i = 0; i < index && crunchifyCurrent.getNext() != null; i++) {
                crunchifyCurrent = crunchifyCurrent.getNext();
            }
        }


        crunchifyTemp.setNext(crunchifyCurrent.getNext());
        crunchifyCurrent.setNext(crunchifyTemp);


        incrementCounter();

    }

    @Override
    public E remove(int index) {

        int currentIndex = 0;
        Node temp = head;
        while(temp!=null){
            if ((currentIndex+1)==index){
                temp.setNext(temp.getNext().getNext());
                counter--;
                break;
            }else{
                temp = temp.getNext();
                currentIndex++;
            }
        }

        return (E) temp.getData();
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) { return 0; }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    private static void incrementCounter() {
        counter++;
    }

    private void decrementCounter() {
        counter--;
    }

    @Override
    public String toString() {
         Node temp=head;
         int i=0;
         Object arr[]=new Object[counter];
         while(temp!=null){
             arr[i++]=temp.getData();
             temp=temp.getNext();
         }
      return Arrays.toString(arr);
    }
}
