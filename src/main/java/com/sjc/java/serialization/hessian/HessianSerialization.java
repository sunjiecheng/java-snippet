package com.sjc.java.serialization.hessian;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import com.sjc.java.bean.Student;
import com.sjc.java.serialization.api.Serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class HessianSerialization implements Serialization {
    @Override
    public <T> byte[] serialize(T obj) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        HessianOutput hessianOutput = new HessianOutput(outputStream);
        try {
            hessianOutput.writeObject(obj);
            return outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        HessianInput hessianInput = new HessianInput(inputStream);
        try {
            return (T) hessianInput.readObject(clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Serialization serialization = new HessianSerialization();
        Student student = new Student();
        student.setAge(18);
        student.setName("sjc");

        byte[] serialize = serialization.serialize(student);

        System.out.println(serialize.length);

        System.out.println(serialization.deserialize(serialize, Student.class));



    }
}
