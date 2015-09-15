package com.example.io.NIO.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by xue on 15/9/15.
 */
public class Student implements Serializable{

    private String name ;
    private transient int stuNo ;

    public void setName(String name) {
        this.name = name;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public String getName() {

        return name;
    }

    public int getStuNo() {
        return stuNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", stuNo=" + stuNo +
                '}';
    }

    public Student(String name, int stuNo) {
        this.name = name;
        this.stuNo = stuNo;
    }

    /**
     * 手动序列化的原因，例如arraylist的源码，element是手动序列化的，在于list可能没有存满，则可以序列化
     * 存储的元素而不是全部的元素
     * @param out
     * @throws IOException
     */
    private void writeObject(ObjectOutputStream out) throws IOException
    {
        out.defaultWriteObject();
        out.writeInt(stuNo);
    }
    private void readObject(ObjectInputStream in ) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stuNo = in.readInt();
    }
}
