package com.sheng.dubboclient;

import com.sheng.dubboserver.HelloWorld;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/6/28 0028.
 */
public class Client implements Runnable {
    public void run() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationConsumer.xml" });
        context.start();
        context.getBean("demoService");

        HelloWorld helloWorld = (HelloWorld) context.getBean("demoService");
        String hello = helloWorld.hello("小明");
        System.out.println(hello);
        System.out.println("执行完毕");
    }
    public static void main(String[] args) {
        new Thread(new Client()).start();
    }
}
