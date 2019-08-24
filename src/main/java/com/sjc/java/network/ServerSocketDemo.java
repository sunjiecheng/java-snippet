package com.sjc.java.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {

    public static void main(String[] args) {

        // 服务端一定需要去监听一个端口号，ip默认是本地ip
        try (ServerSocket serverSocket = new ServerSocket(8080)) {

            // 阻塞（连接阻塞） 接收客户端的连接阻塞
            Socket socket = serverSocket.accept();
            // 拿到输入流（阻塞，read/write阻塞）
            BufferedReader clientIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 拿到输出流
             PrintStream printStream = new PrintStream(socket.getOutputStream(),true);
            // 构造控制台输出流
            BufferedReader out = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(clientIn.readLine());
            // 写出输出流
            String sString = out.readLine();

            while (!"bye".equals(sString)) {
                printStream.println(sString);
                // 打印客户端传送的内容
                System.out.println(clientIn.readLine());
                sString = out.readLine();
            }

        } catch (IOException e) {

        }

    }
}
