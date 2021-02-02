package com.bdg.examples.file;

import java.io.*;

public class FileTest {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\test\\1.txt");
        File file1 = new File("D:\\test\\2.txt");
////        File file = new File(parent);]
//        System.out.println("File Exists:" + file.exists());
//        if (file.exists()) {
//            System.out.println(file.getAbsolutePath());
//            System.out.println(file.isDirectory());
//            System.out.println(file.getParent());
//            if (file.isFile()) {
//                System.out.println(file.length());
//                System.out.println(file.lastModified());
//            }else {
//                for (File f : file.listFiles()) {
//                    System.out.println(f.getName());
//                }
//            }
//        }

//        try {
//            BufferedReader  bufferedReader= new BufferedReader(new FileReader("D:\\test\\1.txt"));
//            System.out.println(bufferedReader.readLine());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        InputStream is = new BufferedInputStream(new FileInputStream(file));
//        System.out.print((char) is.read());
//        if (is.markSupported()) {
//            is.mark(600);
//            System.out.print((char) is.read());
//            System.out.print((char) is.read());
//            is.reset();
//        }
//        System.out.print((char) is.read());
//        System.out.print((char) is.read());
//        System.out.print((char) is.read());
//        System.out.println(is.skip(2));
//        is.read();
//        System.out.print((char)is.read());
//        System.out.print((char)is.read());
//        try (InputStream in= new FileInputStream(file)){
//            OutputStream out= new FileOutputStream(file1);
//            int b;
//            while ((b=in.read())!=-1){
//                out.write(b);
//                out.flush();
//            }
//        }

        InputStream in= new BufferedInputStream(new FileInputStream(file));
        OutputStream out= new BufferedOutputStream(new FileOutputStream(file1));
        byte[] buffer= new byte[2048];
        int lent;
        while ((lent=in.read(buffer))>0){
            out.write(buffer,0,lent);
            out.flush();
        }

    }
}
