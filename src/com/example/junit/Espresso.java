package com.example.junit;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by xue on 15/9/10.
 */
public class Espresso  {
    public static void main(String[] args) throws IOException {
        Path p = Paths.get("/home", "cay", "myprog.properties") ;
        Path parent = p.getParent() ;
        Path file = p.getFileName() ;
        Path root = p.getRoot();

        /*字节读入*/
        p = Paths.get("xue.txt") ;
        byte[] bytes = Files.readAllBytes(p) ;
        String content = new String(bytes) ;
        /**/
//        p = Paths.get("guo.txt") ;
//        Files.createFile(p);
//        List<String> lines = Files.readAllLines(p) ;
//        Files.write(p,content.getBytes(), StandardOpenOption.APPEND) ;
//        Files.write(p, lines, StandardOpenOption.APPEND);


        Path p1 = Paths.get("Scala 教程 - v1.0.pdf");
       Path p2 = Paths.get("1.pdf");
        Path p3 = Paths.get("2.pdf") ;
//        Files.copy(p1,p2);
//        Files.move(p1,p2, StandardCopyOption.REPLACE_EXISTING,StandardCopyOption.COPY_ATTRIBUTES);
//        Files.move(p1,p2, StandardCopyOption.ATOMIC_MOVE) ;
        boolean deleted = Files.deleteIfExists(p2) ;
       if(! Files.exists(p1))
       {
           Files.createFile(p1);

       }


    }

}


