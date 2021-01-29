package com.bdg.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.InvalidParameterException;

public class ExplicitChannelWriteNew {
    public static void main(String[] args) {
        try (FileChannel myFile = (FileChannel) Files.newByteChannel
                (Paths.get(Const.PATH + "fileTree.txt"),
                        StandardOpenOption.WRITE,
                        StandardOpenOption.READ,
                        StandardOpenOption.CREATE)) {
            MappedByteBuffer myBuf = myFile.map(FileChannel.MapMode.READ_WRITE, 0, 26);
            for (int i = 0; i < 26; i++) {
                myBuf.put((byte) ('A' + i));
            }
        } catch (IOException e) {
            System.out.println("Error" + e);

        }
        // read in the file
        int count;
        try (SeekableByteChannel myClan = Files.newByteChannel(
                Paths.get(Const.PATH + "fileTree.txt"))) {
            ByteBuffer myBuf1 = ByteBuffer.allocate(26);
            do {
                count = myClan.read(myBuf1);
                if (count != -1) {
                    myBuf1.rewind();
                    for (int i = 0; i < count; i++) {
                        System.out.print((char) myBuf1.get());
                    }
                }
            } while (count != -1);

        } catch (InvalidParameterException | IOException e) {
            e.printStackTrace();
        }
    }
}
