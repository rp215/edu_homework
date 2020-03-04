package io;

import java.io.*;

/**
 * @author：renpeng
 * @date：2019/8/13
 */
public class BufferedStreamDemo {
    /**
     * Java将底层的缓冲区封装成一个对象（在类中封装了数组）
     * 实现复制图片
     * @param args
     */
    public static void main(String[] args) {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            // new一个BufferedInputStream 会在内存中创建一个比较大的数组，并且缓冲区建立时，必须有被缓冲的流与之关联
            bis = new BufferedInputStream(new FileInputStream(new File("e:\\test\\img\\11.png")));
            // 创建一个新的缓冲输出流，以将数据写入指定的底层输出流。
            bos = new BufferedOutputStream(new FileOutputStream(new File("e:\\test\\img\\44.png")));

            // 自定义一个数组，实现多个字节读取（代表一次最多读取1KB的内容）
            byte[] bytes = new byte[1024];

            // 代表实际读取的字节数
            int len = 0;
            // 当读流末尾时会返回-1
            /* bis.read(bytes)
             * 一次性从底层输入流（FileInpurStream）中读取多个字节来填充byte数组（BufferedInputStream）。
             * 当程序读取一个或多个字节时，可直接从byte数组(BufferedInputStream)中获取。
             * 当内存中的byte（BufferedInputStream）读取完后，会再次用底层输入流（FileInpurStream）填充缓冲区数组（BufferedInputStream）。
             *  */
            while ((len = bis.read(bytes)) != -1){
                // 写入到缓冲输出流中
                bos.write(bytes, 0, len);
            }
            // 缓冲区的内容写入到文件
            bos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 先打开的流后关闭，后打开的流先关闭

            if (null != bos) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != bis) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
