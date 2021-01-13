package com.bdg.secondhomework.Pattern.Prototype;

public abstract class Animal {
    abstract void move();
    public Object clone(){
        Object clone = null;
        try
        {
            clone = super.clone();
        }
        catch (CloneNotSupportedException a) {}
        return clone;
    }
}
