package com.bdg.homework2.linkedList;
/**
 * @param <T>
 * @author Ara Chilingaryan
 * This class provides custom implementation of LinkedList
 * Insertion order of objects is maintained.
 * Implementation allows you to store null as well.
 */


public class LinkedListCustom<T>  {

    private  Node<T> head;
    private  int numNodes;

    public LinkedListCustom() {
        head = null;
        numNodes = 0;
    }

    /**
     *  adding data at the end of LinkedList
     * @param data
     */

    public void add(T data) {
        Node<T> temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
        }

        temp.next = new Node<T>(data);
        numNodes++;
    }

    /**
     * add element at the first of linked List
     * @param data
     */
    public void addFirst(T data)
    {
        Node<T> temp = head;
        head = new Node<T>(data);
        head.next = temp;
        numNodes++;

    }

    /**
     *remove element in that index
     */
    public void remove(int index) {
        Node<T> temp = head;
        for(int i=0; i< index - 1 && temp.next != null; i++)
        {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        numNodes--;
    }

    /**
     *
     * @param index
     * @return Node by index
     */
    public Node<T> get(int index) {
        Node<T> temp=head;
        for(int i=0; i<index; i++)
        {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * Removes all of the elements from this list.
     * The list will be empty after this call returns.
     */
    public void clear() {
        // Clearing all of the links between nodes is "unnecessary", but:
        // - helps a generational GC if the discarded nodes inhabit
        //   more than one generation
        // - is sure to free memory even if there is a reachable Iterator
        for (Node<T> x = head; x != null; ) {
            Node<T> next = x.next;
            x.next = null;
            x = next;
        }
        head = null;
        numNodes = 0;
    }

    /**
     *
     * @return true if linked list is empty else false
     */
    public boolean isEmpty() {
        return numNodes == 0;
    }


    /**
     *
     * @return size of Linked List
     */
    public int size() {
        return numNodes;
    }


    /**
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @return true if index is normal else return false
     */

    public boolean add(int index, T element) {
        if(index >= 0 || index <= numNodes) {
            Node<T> temp = head;
            Node<T> holder;
            for (int i = 0; i < index - 1 && temp.next != null; i++) {
                temp = temp.next;
            }
            holder = temp.next;
            temp.next = new Node<T>(element);
            temp.next.next = holder;
            numNodes++;
            return true;
        }else return false;
    }

    /**
     * prints List
     */
    public  void printList()
    {
        Node<T> temp = head;
        while(temp != null)
        {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }


}
