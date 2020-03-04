package simplemq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author：renpeng
 * @date：2019/9/5
 */
public class SimpleConsumer {
    private static final String EXCHANGE_NAME = "SIMPLE_EXCHANGE";
    private static final String QUEUE_NAME = "SIMPLE_QUEUE";
    public static void main(String[] args) throws IOException, TimeoutException {

        // 1、通过连接工厂创建连接（TCP长连接）
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");//ip地址
        factory.setPort(5672);//端口号
        factory.setVirtualHost("/");//虚拟机
        factory.setUsername("guest");//用户名
        factory.setPassword("guest");//密码
        Connection conn = factory.newConnection();

        // 2、创建信道
        Channel channel = conn.createChannel();

        // 3、声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME, "direct", false, false, null);

        // 4、声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 5、声明绑定关系
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "test.simple");

        System.out.println("Waiting for message....");

        // 6、创建消费者
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope, 
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String msg = new String(body, "UTF-8");
                System.out.println("Received message : '" + msg + "'");
                System.out.println("consumerTag : " + consumerTag );
                System.out.println("deliveryTag : " + envelope.getDeliveryTag() );

            }
        };

        // 7、消费消息
        channel.basicConsume(QUEUE_NAME, consumer);
    }
}
