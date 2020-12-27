package com.bdg;

public class SingletonFile {

    private static SingletonFile singletonFile;
    private static String file = "this is singleton file. \n\n";

    public static synchronized SingletonFile getSingletonFile()
    {
        if(singletonFile == null) {
            singletonFile = new SingletonFile();
        }
        return singletonFile;
    }

    private SingletonFile()
    {

    }

    public void addFileInfo(String info)
    {
        file += info + "\n";
    }

    public void showFile()
    {
        System.out.println(file);
    }
}