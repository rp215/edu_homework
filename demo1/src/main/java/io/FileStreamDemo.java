package io;

import java.io.*;

/**
 * @author：renpeng
 * @date：2019/8/13
 */
public class FileStreamDemo {
    public static void main(String[] args) {

        /*File file = new File("e:\\test");
        if (!file.exists()){
            file.mkdir();// 若e:\test\test 改目录不存在，则创建
        }*/

        // 创建输出流
        // System.getProperty("line.separator")获取换行符
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("e:\\test\\test1.txt", true);
            String str = "txt11";
//            str = System.getProperty("line.separator") + str;
//            System.out.println(System.getProperty("line.separator"));
//            fos.write(str.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        // 创建输入流
        // read()方法是单个字节的读取（ASCII码 a->97）
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("e:\\test\\test1.txt");
            int b = 0;
            // 第一种，单个字节读取
            /*while ((b = fin.read()) != -1) {
                System.out.println(b);
            }*/

            // 第二种，创建字节缓冲区，需要先定义一个byte数组，默认大小是1024的倍数
            /*byte[] bytes = new byte[1024];
            while ((b = fin.read(bytes)) != -1) {

                System.out.println(new String(bytes));
            }*/

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != fin) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



        // 案例：复制一个文件的内容到新文件中
        FileInputStream fins = null;
        FileOutputStream fots = null;
        try {
            File fi = new File("e:\\test\\test1.txt");

            if (!fi.exists()){
                System.out.println("该文件不存在");
            }
            fins = new FileInputStream(fi);

            // 第一步：读取文件内容
            // 定义一个字节缓冲区(利用自定义缓冲区实现高效的字节流读取，也就是一次读取多个字节)
            byte[] bt = new byte[1024];

            int len = 0;

            String str = "";
            // fins.read(bt) 一次读取多个字节
            while((len = fins.read(bt)) != -1){
                str = new String(bt);
            }

            // 第二步：将读取到的文件内容写入新文件中

            fots = new FileOutputStream("e:\\test\\test2.txt");

            fots.write(str.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != fins) {
                try {
                    fins.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != fots) {
                try {
                    fots.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
