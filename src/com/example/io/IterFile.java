package com.example.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by xue on 15/9/12.
 */
public class IterFile {
    public static void main(String[] args) throws IOException {
        Path dir = Paths.get("/Users/xue/Downloads");
        /**
         * 迭代目录中的文件
         */
        try(DirectoryStream<Path> entries = Files.newDirectoryStream(dir,"*pdf")){
            for (Path entry :entries)
                System.out.println(entry);
        }
        /**
         *打印文件夹
         *   walkFileTree(Path start, FileVisitor<? super Path> visitor)
         *  you need to implement all four of FileVisitor methods, implement the FileVisitor interface
         *
         *  If you don't need to implement all four of the FileVisitor methods,
         *  instead of implementing the FileVisitor interface, you can extend the SimpleFileVisitor class
         *
         *  需要覆盖visitFileFailed方法，否则，访问会再遇到不允许打开的目录时立即失败
         */
        Files.walkFileTree(dir,new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult postVisitDirectory(Path dir,IOException exc){
                System.out.format("Directory:%s%n",dir);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(attrs.size());
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.err.println(exc);
                return FileVisitResult.CONTINUE;
            }
        });

    }
}
