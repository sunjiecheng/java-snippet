package com.sjc.java.rpc.server.api;

import com.sjc.java.bean.Student;

public interface IHelloService {

    String sayHello(String content);

    String saveStudent(Student student);
}
