package com.example.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * Created by xue on 15/9/12.
 */
public class Main {
    public static void main(String[] args)throws IOException{
//        IOUtil in = new IOUtil();
//        try {
//            in.printHex("xue");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        String name = "薛国治ABC" ;
//        byte[] bytes = name.getBytes();
//        for (byte b :bytes)
//            System.out.print(Integer.toHexString(b&0xff)+" ");
//        IOUtil io = new IOUtil();
//        try {
//            io.bufferPrintHex("1.pdf");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            io.copyFile("1.pdf", "2.pdf");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        ByteBuffer byteBuff = ByteBuffer.allocate(6);
        byteBuff.position(2);
        byteBuff.limit(6);
        System.out.println();
        CharBuffer charBuff = byteBuff.asCharBuffer();
        System.out.println(charBuff.position()+" "+charBuff.limit()+charBuff.capacity());



    }
}
