package io;

import java.io.*;

/**
 * @author：renpeng
 * @date：2019/8/14
 */
public class InputOutputDemo {

    /**
     * 转换流InputStreamReader/OutputStreamWriter 演示
     * @param args
     */
    public static void main(String[] args) {
        // 创建文件字节输入/输出流
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileReader fr = null;

        // 创建转换流
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        FileWriter fw = null;

        try {
            /*// 定义目标源/字节输出流
            fos = new FileOutputStream(new File("e:\\test\\asd.txt"));
            // 创建字符通向字节的桥梁
            osw = new OutputStreamWriter(fos);
            osw.write("你好");
            // 需要刷新该字符流的缓冲区。将查表得到的字节数据写到fos流中，然后通过Windows底层资源写入
            osw.flush();*/

            // 创建文件处理的节点流，和上面等效
            fw = new FileWriter("e:\\test\\asd.txt");
            fw.write("你好世界");
            fw.flush();


            /*fis = new FileInputStream(new File("e:\\test\\asd.txt"));
            isr = new InputStreamReader(fis);
            int len = 0;
            // 需要强转，字符流=字节流+编码表
            System.out.println((char) isr.read());
            System.out.println((char) isr.read());
            System.out.println((char) isr.read());*/
            fr = new FileReader("e:\\test\\asd.txt");
            //
            char[] chars = new char[1024];
            int len = 0;

            fw = new FileWriter("e:\\test\\asd2.txt");
            while ((len = fr.read(chars)) != -1){
                fw.write(chars, 0, len);
            }
            fw.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            /*if (null != osw){
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != fos){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }*/

            if (null != fr){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != fw){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
