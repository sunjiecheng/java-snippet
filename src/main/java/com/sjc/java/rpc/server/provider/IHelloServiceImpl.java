package com.sjc.java.rpc.server.provider;

import com.sjc.java.bean.Student;
import com.sjc.java.rpc.server.api.IHelloService;

public class IHelloServiceImpl implements IHelloService {

    @Override
    public String sayHello(String content) {
        System.out.println("request in :" + content);
        return "Say Hello" + content;
    }

    @Override
    public String saveStudent(Student student) {
        System.out.println("request in save" + student);
        return "SUCCESS";
    }
}
