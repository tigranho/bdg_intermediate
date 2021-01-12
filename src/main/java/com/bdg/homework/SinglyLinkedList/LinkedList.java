package com.bdg.homework.SinglyLinkedList;

import java.util.*;

public class LinkedList<T> {

    private Node<T> prev;

    public LinkedList(){
        size = 0;
        head = null;
    }

    public int get_size(){
        return size;
    }

    public void push_back(T data) {
        if (head == null) {
            head = new Node<T>(data);
        }
        else {

            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<T>(data);
            ++size;
        }
    }

    public void push_front(T data){
        Node<T> current = head;
        head = new Node<T>(data);
        head.next = current;
        ++size;
    }

    public void insert(T data, int index){
        if(size == 0){
            push_front(data);
        }
        else{
            Node<T> prev = head;
            if(index <= size){
                for (int i = 0; i < index - 1; ++i){
                    prev = prev.next;
                }
                Node<T> current = new Node<T>(data);
                current.next = prev.next;
                prev.next = current;
                ++size;
            }
        }
    }

    public void pop_front(){
        if (head == null){
            return;
        }
        head = head.next;
        --size;
    }

    public void pop_back(){
        if (head == null){
            return;
        }
        Node<T> current = head;
        while (current.next.next != null){
            current = current.next;
        }
        current.next = null;
        --size;
    }

    public void remove_at(int index){
        Node<T> prev = head;
        if(index < size) {
            for (int i = 0; i < index - 1; ++i) {
                prev = prev.next;
            }
            prev.next = prev.next.next;
        }
    }

    public void print_list(){
        if (head == null){
            return;
        }
        Node<T> current = head;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    private class Node<T>{
        T data;
        Node next;
        Node(T data){
            this.data = data;
        }
        Node(){
            this.data = null;
            this.next = null;
        }
    }

    private int size;
    Node<T> head;

}
