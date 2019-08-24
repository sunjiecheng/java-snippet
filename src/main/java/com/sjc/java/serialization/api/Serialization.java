package com.sjc.java.serialization.api;

public interface Serialization {
    <T> byte[] serialize(T obj);

    <T> T deserialize(byte[] data, Class<T> clazz);

}
