package com.example.io;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.CRC32;

/**
 * Created by xue on 15/9/13.
 */
public class MemoryMapTest {

    public  static long checksumInputStream(Path filename) throws IOException {
        try(InputStream in = Files.newInputStream(filename)){
            CRC32 crc = new CRC32() ;
            int c ;
            while ((c=in.read())!= -1)
                crc.update(c);
            return crc.getValue() ;
        }
    }


    public static long checksumBufferedInputStream(Path filename) throws IOException {

        try(InputStream in = new BufferedInputStream(Files.newInputStream(filename))){
            CRC32 crc = new CRC32() ;
            int c ;
            while ((c = in.read())!=-1){
                crc.update(c);
            }
            return crc.getValue();
        }
    }

    public static long checksumRandomAccessFile(Path filename) throws IOException{
        try(RandomAccessFile file = new RandomAccessFile(filename.toFile(),"rw")){
            long length = file.length() ;
            CRC32 crc = new CRC32();
            for (long p = 0 ; p < length ; p++){
                file.seek(p);
                int c = file.readByte();
                crc.update(c);
            }
            return crc.getValue();
        }
    }

    public static long checksumMappedFile(Path filename) throws IOException{
        try(FileChannel channel = FileChannel.open(filename)){
            CRC32 crc = new CRC32() ;
            int length = (int)channel.size();
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY,0,length);
            for (int p = 0 ;p <length ;p++)
            {
                int c = buffer.get(p) ;
                crc.update(c);
            }
            return crc.getValue();
        }
    }
}
