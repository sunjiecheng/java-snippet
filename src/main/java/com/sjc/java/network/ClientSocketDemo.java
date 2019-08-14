package com.sjc.java.network;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocketDemo {

    public static void main(String[] args) {
        // 找到目标的IP和端口
        try (Socket socket = new Socket("localhost", 8080)) {

            PrintStream printStream = new PrintStream(socket.getOutputStream(),true);

            printStream.println("HELLO server,i am client");


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
