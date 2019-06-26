package com.rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.uitls.ConnectionUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by lenovo on 2019/6/26.
 */
public class Send {
    private static final String QUEUE_NAME = "test_simple_queue";

    public static void send() throws IOException, TimeoutException {
        //获取一个连接
        Connection connection = ConnectionUtils.getConnection();

        //从连接中获取一个通道
        Channel channel = connection.createChannel();

        //创建队列声明
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        String msg = "Hello simple";

        channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());

        System.out.print("--send msg"+msg);
        channel.close();
        connection.close();

    }

    @Test
    public void test() throws IOException, TimeoutException {
        this.send();
    }
}
