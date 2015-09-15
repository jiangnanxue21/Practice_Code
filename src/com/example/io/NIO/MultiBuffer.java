package com.example.io.NIO;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by xue on 15/9/14.
 */
public class MultiBuffer {
//    public static void main(String[] args) throws IOException{
//        ByteBuffer buffA = ByteBuffer.allocate(6) ;
//        ByteBuffer buffB = ByteBuffer.allocate(5) ;
//        ByteBuffer[] buffArr = {buffA,buffB} ;
//        try(RandomAccessFile raf = new RandomAccessFile("test.txt","rw");
//        FileChannel fc = raf.getChannel()){
//            fc.read(buffArr);
//            System.out.println(new String(buffA.array()));
//            System.out.println(new String(buffB.array()));
//        }
//    }
    public static void MultiBufferRead()throws IOException{
        ByteBuffer buffA = ByteBuffer.allocate(6) ;
        ByteBuffer buffB = ByteBuffer.allocate(5) ;
        ByteBuffer[] buffArr = {buffA,buffB} ;
        try(RandomAccessFile raf = new RandomAccessFile("test.txt","rw");
        FileChannel fc = raf.getChannel()){
            fc.read(buffArr);
            System.out.println(new String(buffA.array()));
            System.out.println(new String(buffB.array()));
        }
    }

    public static void MultiBufferWrite() throws IOException{

        byte[] byteA = "hello".getBytes("UTF-8") ;
        byte[] byteB = "world!".getBytes("UTF-8");
        ByteBuffer buffC = ByteBuffer.wrap(byteA) ;
        ByteBuffer buffD = ByteBuffer.wrap(byteB) ;
        ByteBuffer[] allBuf = {buffC,buffD} ;
        try(RandomAccessFile raf = new RandomAccessFile("test.txt","rw");
            FileChannel fc = raf.getChannel()){
            fc.write(allBuf) ;
        }
    }

    public static void main(String[] args) {
        try {
            MultiBufferWrite();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
