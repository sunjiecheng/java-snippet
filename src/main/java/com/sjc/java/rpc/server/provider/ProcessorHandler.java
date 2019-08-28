package com.sjc.java.rpc.server.provider;

import com.sjc.java.rpc.server.api.RpcRequest;

import java.io.*;
import java.net.Socket;

public class ProcessorHandler implements Runnable {

    private Socket socket;

    public ProcessorHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        ObjectInputStream objectInputStream;
        ObjectOutputStream objectOutputStream;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            RpcRequest rpcRequest = (RpcRequest) objectInputStream.readObject();


            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Object invoke(RpcRequest rpcRequest) {
        // 反射调用
        return null;
    }
}
