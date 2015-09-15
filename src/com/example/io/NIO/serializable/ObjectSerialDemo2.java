package com.example.io.NIO.serializable;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by xue on 15/9/15.
 */


/**
 * you always need to construct the output stream first
 * and flush it before creating the input stream
 *
 *
 *
 */
public class ObjectSerialDemo2 {

    /*
		 * 对子类对象进行反序列化操作时，
		 * 如果其父类没有实现序列化接口
		 * 那么其父类的构造函数会被调用
		 *
		 *
		 * 反之，则不会被调用
		 */

    public static void main(String[] args) throws IOException {
        String filename = "Object1.dat" ;
        Path path = Paths.get(filename) ;
        if (!Files.exists(path)){
            Files.createFile(path);
        }
        try(FileInputStream fileInputStream = new FileInputStream(filename);
//            try(FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileInputStream);
//            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream)
        ){
//            Foo2 foo2 = new Foo2();
//            out.writeObject(foo2);
//                Bar1 bar1 = new Bar1() ;
//                out.writeObject(bar1);

            try {
                in.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}

/*
 *   一个类实现了序列化接口，那么其子类都可以进行序列化
 */
class Foo implements Serializable{
    public Foo() {
        System.out.println("Foo....");
    }

}

class Foo1 extends Foo{
    public Foo1() {
        System.out.println("Foo1...");
    }
}

class Foo2 extends Foo1{
    public Foo2() {
        System.out.println("Foo2...");
    }
}

class Bar {
    public Bar() {
        System.out.println("bar...");
    }

}

class Bar1 extends Bar implements Serializable{
    public Bar1() {
        System.out.println("bar1....");
    }
}
