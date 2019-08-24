package com.sjc.java.serialization.jdk;

import com.sjc.java.bean.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);


        Student student = new Student();
        student.setName("sjc");
        student.setAge(18);




        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(student);

        out.close();
        socket.close();



    }
}
