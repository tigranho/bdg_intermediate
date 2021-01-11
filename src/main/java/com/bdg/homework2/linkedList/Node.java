package com.bdg.homework2.linkedList;

public class Node<T> {
    T data;
    Node<T> next;
    public Node(T data)
    {
        this.data=data;
    }
    public Node()
    {
        data=null;
        next=null;
    }

    public Node<T> getNode()
    {
        return(next);
    }

    public T getData()
    {
        return(data);
    }

    public void setData(T data)
    {
        this.data=data;
    }

    public void setNext(Node<T> next)
    {
        this.next=next;
    }
}
