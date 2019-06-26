package com.rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.uitls.ConnectionUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by lenovo on 2019/6/26.
 */
public class Receive {
    private static final String QUEUE_NAME = "test_simple_queue";

    public static void send() throws IOException, TimeoutException {
        //获取一个连接
        Connection connection = ConnectionUtils.getConnection();

        //从连接中获取一个通道
        Channel channel = connection.createChannel();

        //创建队列声明
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        //
        DefaultConsumer consumer = new DefaultConsumer(channel);


        channel.basicConsume(QUEUE_NAME,true,consumer);


    }

    public static void oldSend() throws IOException, TimeoutException, InterruptedException {
        //获取一个连接
        Connection connection = ConnectionUtils.getConnection();

        //从连接中获取一个通道
        Channel channel = connection.createChannel();

        //定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);

        //监听队列
        channel.basicConsume(QUEUE_NAME,true,consumer);

        while(true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();

            String msg = new String(delivery.getBody());
            System.out.print("--recevie msg"+msg);
        }


    }

    @Test
    public void test() throws IOException, TimeoutException, InterruptedException {
        this.send();
    }

}
