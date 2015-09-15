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
        //try with resource的正确用法是为各个资源声明独立的变量
        try( FileInputStream fileInputStream = new FileInputStream(filename);
             BufferedInputStream in = new BufferedInputStream(fileInputStream)){
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

    public static void copyFileByBuffer(String src, String dst) throws IOException{
        Path path = Paths.get(dst) ;
        if (!Files.exists(path))
            Files.createFile(path) ;
        try(    FileInputStream fileInputStream = new FileInputStream(src);
                FileOutputStream fileOutputStream = new FileOutputStream(dst);
                BufferedInputStream in = new BufferedInputStream(fileInputStream);
                 BufferedOutputStream out = new BufferedOutputStream(fileOutputStream)){
            byte[] buffer = new byte[1024] ;
            int c ;
            while ((c = in.read(buffer, 0, buffer.length))!=-1){
                out.write(buffer, 0, c);
            }
        }

    }

    public static void bufferedReader(String filename) throws IOException
    {
        try(FileInputStream fileInputStream = new FileInputStream(filename);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader in = new BufferedReader(inputStreamReader);
            PrintWriter pw = new PrintWriter("guo.txt")) {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);//一次读一行，不能识别换行

                pw.println(line);
                pw.flush();
            }

        }
    }

    public static void main(String[] args) {
        try {
            bufferedReader("xue");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
