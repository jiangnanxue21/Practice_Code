package com.example.io.NIO.serializable;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by xue on 15/9/15.
 */
public class ObjectSerialDemo1 {

    public static void main(String[] args) throws IOException{
        String filename = "Object.dat" ;
        Path path = Paths.get(filename) ;
        if (!Files.exists(path)){
            Files.createFile(path);
        }
        try(FileInputStream fileInputStream = new FileInputStream(filename);
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            ObjectInputStream in = new ObjectInputStream(fileInputStream)){

            Student stu = new Student("张三",23020) ;
            out.writeObject(stu);
            try {
                Student su = (Student)in.readObject();
                System.out.println(su.toString());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
