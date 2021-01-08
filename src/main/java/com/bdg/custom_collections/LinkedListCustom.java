package com.bdg.custom_collections;

class Node<T> {

    private T data;
    private Node<T> node;

    public Node(T data) {
        this.data = data;
    }

    public Node<T> getNode() {
        return node;
    }

    public void setNode(Node<T> node) {
        this.node = node;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data + "";
    }
}

public class LinkedListCustom<T> {
    private int size = 0;
    private Node<T> node;

    /**
     * Add element at last.
     *
     * @param data
     */
    public void add(T data) {
        if (data == null) {
            return;
        }
        if (node == null) {
            node = new Node<T>(data);
        } else {
            Node<T> newNode = new Node<T>(data);
            Node<T> lastNode = getLastNode(node);
            lastNode.setNode(newNode);
        }
        size++;
    }


    private Node<T> getLastNode(Node<T> node) {

        Node<T> lastNode = node;
        if (lastNode.getNode() != null) {
            return getLastNode(lastNode.getNode());
        } else {
            return lastNode;
        }
    }

    /**
     * Returns the number of elements in this LinkedListCustom.
     */
    public int size() {
        return this.size;
    }

    private Node<T> next(Node<T> node) {
        if (node.getNode() != null) {
            return node.getNode();
        } else {
            return null;
        }
    }

    /**
     * Delete the data by index.
     *
     * @param index
     * @return boolean
     */
    public boolean deleteByIndex(int index) {
        if (this.node == null) {
            return false;
        }
        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException("Index not available.");
        }
        // If index=0 , put head node = Node at index 1.
        if (index == 0) {
            if (this.node.getNode() != null) {
                this.node = getNode(index + 1);
            } else {
                this.node = null;
            }
            size--;
            return true;
        }
        // If index= size -1 means need to delete last node, get the 2nd last node and
        // set next node as null.
        if (index == this.size - 1) {
            getNode(index - 1).setNode(null);
            size--;
            return true;
        }

        // if index is in between 0 and size of linked list , set Node of leftNode as
        // rightNode
        Node<T> leftNode = getNode(index - 1);
        Node<T> rightNode = getNode(index + 1);
        leftNode.setNode(rightNode);
        size--;
        return true;
    }

    /**
     * Returns the index of data. Index starts from 0 to n. If data not found in
     * list, return -1
     *
     * @param data
     * @return
     */
    public int indexof(T data) {
        Node<T> pointerNode = this.node;
        int index = 0;

        while (pointerNode != null && pointerNode.getData() != null) {
            if (pointerNode.getData().equals(data)) {
                return index;
            } else {
                pointerNode = pointerNode.getNode();
                index++;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String represent = "[";
        Node<T> nextNode = this.node;
        while (nextNode != null) {
            represent = represent + nextNode.toString();
            nextNode = next(nextNode);
            if (nextNode != null) {
                represent = represent + ",";
            }
        }
        represent = represent + "]";
        return represent;
    }

    public Node<T> getNode(int index) {
        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException("Index not available.");
        }
        // If index=0 , return head
        if (index == 0) {
            return this.node;
        }
        // If index= size, return last node
        if (index == this.size - 1) {
            return getLastNode(this.node);
        }
        int pointer = 0;
        Node<T> pointerNode = this.node;
        while (pointer <= index) {
            if (pointer == index) {
                return pointerNode;
            } else {
                pointerNode = next(pointerNode);
                pointer++;
            }
        }
        return null;
    }

    /**
     * Clear the linked list
     */
    public void clear() {
        this.node = null;
        this.size = 0;
    }

}