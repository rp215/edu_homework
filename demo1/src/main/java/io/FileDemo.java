package io;

import java.io.File;
import java.io.IOException;

/**
 * @author：renpeng
 * @date：2019/8/13
 */
public class FileDemo {

    public static void main(String[] args) throws IOException {

//        File file = new File("E:\\test\\test1.txt");
        File file = new File("E:\\test\\test");

//        System.out.println(file.createNewFile());//定义文件的路径，该方法创建文件，如果存在不会创建返回false
//        System.out.println(file.delete());//若删除目录时，改目录下存在文件，则删除失败（window删除动作是从里往外）
//        System.out.println(file.exists());
        System.out.println(file.mkdir());// 创建目录，若被创建的目录存在，则返回false
    }
}
