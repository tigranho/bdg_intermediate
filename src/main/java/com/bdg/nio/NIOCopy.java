package com.bdg.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class NIOCopy {
    public static void main(String[] args) {
        try {
            Path first = Paths.get(Const.PATH + "fileOan.txt");
            Path second = Paths.get(Const.PATH + "fileFor.txt");
            Files.copy(first, second, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
