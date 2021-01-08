package com.bdg.homework.customCollections.MyLinkedList;

public class CustomLinkedList {
    private Node head;
    private Node rear;
    private int size = 0;
    private static final int DEFAULT_SIZE = 16;

    public CustomLinkedList() {
        head = null;
        rear = null;
    }

    //return size
    public int returnSize() {
        return size;
    }

    public void addFirst(Object o) {
        if (size == 0) {
            Node newHead = new Node(null, null, o);
            head = newHead;
            rear = head;
        } else {
            Node newHead = new Node(null, null, o);
            // next prev
            newHead.next = head;
            head.prev = newHead;
            //head
            head = newHead;
        }
        //size
        size++;
    }

    public void addLast(Object o) {
        if (size == 0) {
            addFirst(o);
        } else {
            Node newRear = new Node(null, null, o);
            newRear.prev = rear;
            rear.next = newRear;
            rear = newRear;
            size++;
        }
    }

    public void add(int index, Object o) {
        if (index >= 0 || index < size) {
            if (size == 0) {
                addFirst(o);
            } else if (size == 1) {
                addLast(o);
            } else {
                Node current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
                Node newNode = new Node(null, null, o);
                newNode.prev = current;
                newNode.next = current.next;
                current.next = newNode;
                newNode.next.prev = newNode;

            }
        } else {
           throw  new IndexOutOfBoundsException();
        }
    }

    public void add(Object o) {

    }

    public void print() {
        Node current = head;
        while (current.next != null) {
            System.out.println(current.data.toString());
            current = current.next;
        }
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

