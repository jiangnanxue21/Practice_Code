package com.example.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by xue on 15/9/12.
 */

/**
 * UTF-8中文三个字节，英文一个字节
 * java是双字节编码，utf-16be
 */
public class RafDemo {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("xue") ;
        if (!Files.exists(path))
            Files.createFile(path) ;
        try(RandomAccessFile raf = new RandomAccessFile(path.toFile(),"rw")) {
            System.out.println(raf.getFilePointer());
          raf.write('a');
        System.out.println(raf.getFilePointer());
            int i = 0x7fffffff;
            System.out.println(Integer.toHexString(i));
            System.out.println(i);
            raf.write(i >>> 24);
            raf.write(i >>> 16);
            raf.write(i >>> 8);
            raf.write(i);
            raf.writeBytes(Integer.toString(i));
            System.out.println(raf.getFilePointer());


            raf.seek(0);
            byte[] buf = new byte[(int) raf.length()];
            raf.read(buf);
            for (byte b : buf)
                System.out.println(Integer.toHexString(b) + " ");
            int b = raf.readInt();
            System.out.println(Integer.toHexString(b));
            System.out.println(b);


        }

    }
}
