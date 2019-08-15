package com.sjc.java.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocketDemo {

    public static void main(String[] args) {
        // 找到目标的IP和端口
        try (Socket socket = new Socket("localhost", 8080)) {
            // 在当前链接上写入输入
            PrintStream out = new PrintStream(socket.getOutputStream(),true);

            // 控制台的输入流
            BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));

            // 拿到server的输入流
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String cString = cin.readLine();

            while (!"bye".equals(cString)) {
                out.println(cString);
                System.out.println("server:" + in.readLine());
                cString = cin.readLine();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
