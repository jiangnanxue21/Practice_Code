package com.example.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by xue on 15/9/12.
 */
public class IOUtil {


    public static void printHex(String fileName) throws IOException {
        try(FileInputStream in = new FileInputStream(fileName)){
            int b ;
            int i = 1;
            while ((b = in.read())!=-1){
                if(b <= 0xf){
                    System.out.println("0");
                }
                System.out.print(Integer.toHexString(b)+" ");
                if (i++%10==0)
                    System.out.println(i);
            }
        }
    }

    public static void bufferPrintHex(String filename) throws IOException{
        try(BufferedInputStream in = new BufferedInputStream(new FileInputStream(filename))){
            int c ;
            byte[] buffer = new byte[1024] ;
            while ((c = in.read(buffer,0,buffer.length))!=-1){
                for (int i = 0 ;i < c ; i ++){
//                    if (buffer[i]<=0xf)
//                        System.out.print("0");
                    System.out.print(Integer.toHexString((int)buffer[i]&0xff)+" ");
                    if (i++%10==0)
                        System.out.println();
                }
            }
        }
    }

    public static void copyFile(String src, String dst) throws IOException{
        Path path = Paths.get(dst) ;
        if (!Files.exists(path))
            Files.createFile(path) ;
        try(BufferedInputStream in = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dst))){
            byte[] buffer = new byte[1024] ;
            int c ;
            while ((c = in.read(buffer,0,buffer.length))!=-1){
                out.write(buffer,0,c);
            }
        }
    }
}
