package com.bdg;

public class CustomArrayList {

    /**
     * size variable for keeping the size of our array.
     **/
    private int size = 0;

    /**
     * String type array which has 10 element length by default
     **/
    private String[] array = new String[10];

    /**
     * Method add, which gets the string which you want to pass:
     * it assign the string to the array of index of our current * size, and if we don't have enough capacity, the method
     * multiplies capacity of array by 2 and only after passed
     * the string to the end of our array.
     **/
    public void add(String s)
    {
        array[size] = s;
        size++;
        if(size == array.length)
        {
            String[] newArray = new String[array.length*2];
            for(int i = 0; i < array.length; i++)
            {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    /**
     * Method removeByIndex gets an index of the elemenet which * the user wants to remove, as a parameter. It checks if
     * there is an index such that coresponds to any element and * as a result remove it. The part of the elements which are * situated right after the removed element change their
     * index by -1. And in the end the array size is decreasing * by 1.
     **/
    public void removeByIndex(int index)
    {
        if(index >= 0 && index < size)
        {
            for(int i = index; i < size; i++)
            {
                array[i] = array[i+1];
            }
            size--;
        }
        else {
            System.out.println("There is no element coresponding to this index");
        }
    }

    /**
     * Method removeByElement gets the element which the user
     * wants to remove as a parameter. After the method creates * a variable "index" which restores the index of the
     * string which we pass as a parameter. And finnaly it calls * method removeByIndex because at this moment we can remove * the element which user wants by its index.
     **/
    public void removeByElement(String element)
    {
        int index = -1;
        for(int i = 0; i < size; i++)
        {
            if(element.equals(array[i]))
            {
                index = i;
            }
        }
        if(index != -1)
        {
            removeByIndex(index);
        }
    }

    /**
     * Simple method for printing the elements of our array.
     **/
    public void printList()
    {
        for(int i=0; i < size; i++)
        {
            System.out.println(array[i]);
        }
    }

    /***
     * Method getSize which just return the size of our current * array
     ***/
    public int getSize()
    {
        return size;
    }

    /***
     * Method getElement which gets index as a parameter and
     * returns the value corresponding to the passed index. If
     * there is no such element which correspond to the index
     * which the user passed, it just return a massage.
     ***/
    public String getElement(int index)
    {
        if(index >= 0 && index < size)
        {
            return array[index];
        }
        else
        {
            String s = "There is no element coresponding to this index";
            return s;
        }
    }
}


