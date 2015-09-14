package com.example.junit;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xue on 15/9/7.
 */
public class MessageUtil {


    public static void main(String[] args) throws IOException {
        Path relative = Paths.get("/Users", "xue","Downloads") ;
//        try {
//            getPath(relative);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        System.out.println(Files.readAttributes(relative,BasicFileAttributes.class).isDirectory()?"true":"false");

//        Files.walkFileTree(relative,new SimpleFileVisitor<Path>(){
//            public FileVisitResult visitFile(Path path,BasicFileAttributes attrs){
////                if (attrs.isDirectory())
//                    System.out.println(path);
//                return FileVisitResult.CONTINUE;
//            }
//            public FileVisitResult visitFileFailed(Path path,IOException exc){
//                return FileVisitResult.CONTINUE;
//            }
//        });
        List<String> list = new ArrayList<>();
     try(InputStream in = new DataInputStream(new FileInputStream("xue.txt"))){

     }
    }

}

