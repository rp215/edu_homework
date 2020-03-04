package io;

import jdk.internal.util.xml.impl.ReaderUTF8;

import java.io.*;

/**
 * @author：renpeng
 * @date：2019/8/14
 */
public class BufferedReaderAndWriter {
    /**
     * 字符流缓冲区
     * @param args
     */
    public static void main(String[] args) {

        // 创建字符输入流
        BufferedReader bfr = null;
        InputStreamReader isr = null;

        // 创建字符输出流
        BufferedWriter bfw = null;
        OutputStreamWriter osw = null;

        try {
            /*
             * 使用BufferedReader和BufferedWriter读写文件时，在不指定特定的编码格式时，可能会出现乱码的问题。
             * 这是因为JVM的默认编码格式跟我们读写的文件编码格式正好是一致的，但是在遇到JVM默认编码格式和文件编码格式不一样时，就会出现中文乱码的问题，
             * */

            // 创建文件字符输入流的渠道
            /*
            * InputStreamReader 是字符流Reader的子类，是字节流通向字符流的桥梁。
            * 可以在构造器重指定编码的方式，如果不指定的话将采用底层操作系统的默认编码方式，例如 GBK 等。
            * 要启用从字节到字符的有效转换，可以提前从底层流读取更多的字节，使其超过满足当前读取操作所需的字节。
            * 一次只读一个字符。
            * */
            isr = new InputStreamReader(new FileInputStream("e:\\test\\test2.txt"), "GBK");
            bfr = new BufferedReader(isr);

            // 创建文件字符输出流的渠道
            /*
            * OutputStreamWriter 是字符流Writer的子类，是字符流通向字节流的桥梁。
            * 每次调用 write()方法都会导致在给定字符（或字符集）上调用编码转换器。
            * 在写入底层输出流之前，得到的这些字节将在缓冲区中累积。一次只写一个字符。
            * */
            osw = new OutputStreamWriter(new FileOutputStream("e:\\test\\test4.txt"), "GBK");
            bfw = new BufferedWriter(osw);

            // 每次读取一行的内容
            String str = null;
            while ((str = bfr.readLine()) != null){
                bfw.write(str);
                // 换行，str 是一行数据，所以每次写一行就要换行
                bfw.newLine();
            }
            bfw.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != bfw) {
                try {
                    bfw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != osw) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != bfr) {
                try {
                    bfr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != isr) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
