package com.sjc.java.rpc.server.provider;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RpcProxyServer {


    ExecutorService executorService = Executors.newCachedThreadPool();
    public void publisher(int port) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            // 不断接收请求
            while (true) {
                Socket accept = serverSocket.accept();
                // 每一个socket 交给一个processorHandler来处理
                executorService.execute(new ProcessorHandler(accept));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
