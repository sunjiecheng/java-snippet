package com.sjc.java.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {

    public static void main(String[] args) {

        // 服务端一定需要去监听一个端口号，ip默认是本地ip
        try (ServerSocket serverSocket = new ServerSocket(8080)) {

            // 阻塞（连接阻塞） 接收客户端的连接阻塞
            Socket socket = serverSocket.accept();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // 打印客户端传送的内容
            System.out.println(bufferedReader.readLine());


        } catch (IOException e) {

        }

    }
}
