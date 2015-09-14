package com.example.io.NIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Created by xue on 15/9/14.
 */
public class ReadAndWriteChannel {
    public static void main(String[] args) throws IOException{

        // 创建一个可读通道
        ReadableByteChannel rbc = Channels.newChannel(System.in);
// 创建一个可写通道
        WritableByteChannel wbc = Channels.newChannel(System.out);
// 创建一个大小为8192字节的字节缓冲区
        ByteBuffer buff = ByteBuffer.allocate(8192);
// 轮询将可读通道的数据读到缓冲区
        while (rbc.read(buff) != -1) {//是一起读进去的，然后等待再输入
            // 翻转缓冲区
            buff.flip();
            byte[] store = new byte[1024] ;
            /*array()函数会把之前的数据一起读出，而不管limit*/
//            String str = new String(buff.array()).trim();
//            System.out.println("str:"+str);
            int i = 0 ;
            while (buff.hasRemaining()) {
                store[i] = buff.get();
                i++;
            }
            String str = new String(store).trim();
            // 若输入"bye"则关闭通道
            if (str.equals("bye")) {
                rbc.close();
                wbc.close();
                break;
            }
            buff.flip();
            // 将缓冲区的数据写入到可写通道
            wbc.write(buff);
            // 轮询缓冲区是否还有剩余数据
            while (buff.hasRemaining()) {
                wbc.write(buff);
            }
            // 清空缓冲区
            buff.clear();
//            buff.put(new byte[1024]) ;
//            buff.clear();

        }
    }
}
