package com.rabbitmq.uitls;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by lenovo on 2019/6/26.
 */
public class ConnectionUtils {

    /**
     * 获取MQ连接
     * @return
     */
    public static Connection getConnection() throws IOException, TimeoutException {
        //定义一个连接工厂
        ConnectionFactory factory = new ConnectionFactory();

        //设置服务器地址
        factory.setHost("127.0.0.1");

        //AMQP
        factory.setPort(5672);

        //vhost
        factory.setVirtualHost("/vhost_xjl");

        //用户名
        factory.setUsername("xiejianlun");

        //密码
        factory.setPassword("123456");

        return factory.newConnection();
    }
}
