package com.rp.edu.singleton;

import com.rp.edu.designpattern.singleton.serialize.SerializeSigleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @功能描述：
 */
public class SerializeTest {
    public static void main(String[] args) {

        SerializeSigleton s1 = null;
        SerializeSigleton s2 = SerializeSigleton.getInstance();

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("SerializeSigleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("SerializeSigleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (SerializeSigleton) ois.readObject();
            ois.close();

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1 == s2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
