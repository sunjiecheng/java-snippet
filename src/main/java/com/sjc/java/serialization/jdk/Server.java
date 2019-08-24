package com.sjc.java.serialization.jdk;

import com.sjc.java.bean.Student;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ServerSocket serverSocket = new ServerSocket(8080);

        Socket server = serverSocket.accept();

        ObjectInputStream in = new ObjectInputStream(server.getInputStream());

        Student student = (Student) in.readObject();

        System.out.println(student.toString());

        server.close();
        serverSocket.close();
    }
}
