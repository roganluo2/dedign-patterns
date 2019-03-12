package com.gupaoedu.singleton.destroy;

import java.io.*;

public class SerializableDestory {

    public static void main(String[] args) throws Exception{
        SerializableSingleton singleton1 = null;
        SerializableSingleton singleton2 = SerializableSingleton.getInstance();

        String fileName = "SerializableSingleton.obj";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
        oos.writeObject(singleton2);
        oos.flush();
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
        singleton1 = (SerializableSingleton) ois.readObject();
        ois.close();


        System.out.println(singleton1 == singleton2);

    }

}
