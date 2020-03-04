package simplemq;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author：renpeng
 * @date：2019/9/5
 * 消息生产者
 */
public class SimpleProducer {

    // 交换机的名称
    private static final String EXCHANGE_NAME = "SIMPLE_EXCHANGE";

    public static void main(String[] args) throws IOException, TimeoutException {

        // 1、通过连接工厂建立连接
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("guest");
        factory.setPassword("guest");

        Connection conn = factory.newConnection();
        // 2、创建消息信道
        Channel channel = conn.createChannel();

        // 3、发送消息
        channel.basicPublish(EXCHANGE_NAME, "test.simple", null, "你好，世界".getBytes());


        channel.close();
        conn.close();
    }
}
