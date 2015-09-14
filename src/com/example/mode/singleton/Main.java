package com.example.mode.singleton;

/**
 * Created by xue on 15/9/11.
 */
public class Main {

    public static void main(String[] args) {
        /**
         * 饿汉模式
         * 区别：
         *      饿汉模式的特点是加载类时比较慢，但运行时获取对象的速度比较快，线程安全
         *      懒汉模式的特点是加载类时比较快，但运行时获取对象的速度比较慢，线程不安全
         */
        Singleton sing1 = Singleton.getInstance() ;
        Singleton sing2 = Singleton.getInstance() ;
        System.out.println(sing1==sing2);
        Singleton2 instance1 = Singleton2.getInstance() ;
        Singleton2 instacne2 = Singleton2.getInstance() ;
        System.out.println(instacne2==instance1);
    }
}
