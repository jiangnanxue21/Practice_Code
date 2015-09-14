package com.example.io.NIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by xue on 15/9/12.
 */
public class RafNIO2 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("xue") ;
        String s = "I was here!\n" ;
        byte[] data = s.getBytes() ;
        ByteBuffer out = ByteBuffer.wrap(data) ;//通过包装的方法创建的缓冲区保留了被包装数组内保存的数据
        ByteBuffer copy = ByteBuffer.allocateDirect(12) ;
        System.out.println(copy.isDirect());
        try(FileChannel fc = FileChannel.open(path,
                StandardOpenOption.READ,StandardOpenOption.WRITE)){
            int nread ;
            do {
                nread = fc.read(copy) ;
            }while (nread != -1 && copy.hasRemaining());

            fc.position(0) ;
            while (out.hasRemaining())//位置和界限之间的差距
                fc.write(out) ;
            out.rewind();//将读写位置复位为0，并保持界限不变，使这个缓冲区为重新读入相同的值做好准备

            long len = fc.size();
            fc.position(len-1);
            copy.flip();//界限设置到当前位置，并且把位置复位为0
            while (copy.hasRemaining())
                fc.write(copy);
            while (out.hasRemaining())
                fc.write(out);
        }
    }

}
