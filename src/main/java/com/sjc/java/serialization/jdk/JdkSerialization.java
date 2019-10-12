package com.sjc.java.serialization.jdk;

import com.sjc.java.bean.Student;

import java.io.*;

/**
 * @author jiecheng
 * @create 2019-08-30 下午7:03
 */
public class JdkSerialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 序列化输出流指向了字节输出流
        //ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("a")));
        Student student = new Student("sjc", 18);
        //oos.writeObject(student);

        byte[] str = baos.toByteArray();
        // java序列化的字节数组长度为96
        System.out.println(str.length);

        // 序列化输入流指向了字节输入流
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(new File("a")));
        Student obj = (Student) ois.readObject();
        System.out.println(obj);
    }
}

