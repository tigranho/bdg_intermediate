package com.bdg.homework.customCollections.MyLinkedList;

import java.util.*;

public class CustomLinkedList <E> implements List<E> {
    private Node headNode;
    private Node tailNode;
    private int size = 0;
    private static final int DEFAULT_SIZE = 16;

    public CustomLinkedList() {
        headNode = null;
        tailNode = null;
    }

     public void addFirst(E element){
    	Node new_node= new  Node(null, null,element);
    	new_node.next=headNode;
    	new_node.prev=null;
    	if (headNode!=null){
    		headNode.prev=new_node;
    		headNode=new_node;
		}
		 size++;
   
	 }
	 
	 @Override
    public void add(int index, E element) {
    Node new_node= new Node(null, null, element);
    int current=0;

    while (current<index){
        headNode.next=headNode.next.next;
        current++;

        if (current<index-1){
            headNode.next=new_node;
            new_node.next=headNode.next.next;
            headNode.next.next.prev=new_node;
            new_node.prev=headNode;
            size++;
        }
    }
 }
	
	@Override
	public boolean add(E e) {
		return false;
	}

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
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
	public <T> T[] toArray(T[] a) {
		return null;
	}
	

    @Override
    public Object[] toArray() {
        return new Object[0];
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
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

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
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof CustomLinkedList)) return false;
		CustomLinkedList<?> that = (CustomLinkedList<?>) o;
		return size == that.size && Objects.equals(headNode, that.headNode) && Objects.equals(tailNode, that.tailNode);
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(headNode, tailNode, size);
	}
	
	
	
	static class Node {
        Node next;
        Node prev;
        Object data;

        public Node(Node next, Node prev, Object data) {
            this.next = next;
            this.prev = prev;
            this.data = data;
        }

    }
}

