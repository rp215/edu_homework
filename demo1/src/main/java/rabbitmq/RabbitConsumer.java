package rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author：renpeng
 * @date：2019/8/30
 */
public class RabbitConsumer {

    //交换机
    private static final String EXCHANGE_NAME="SIMPLE_EXCHANGE";
    //队列
    private static final String QUEUE_NAME="SIMPLE_QUEUE";

    public static void main(String[] args) throws IOException, TimeoutException {

        // 1、通过连接工厂建立连接
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("guest");
        factory.setPassword("guest");

        Connection conn = factory.newConnection();

        // 2、建立信道
        Channel channel = conn.createChannel();

        // 3、声明交换机
        /*
        * EXCHANGE_NAME  交换机的名字
        * direct  交换机的类型（direct：直连类型, topic：主题类型，可加通配符 *代表一个英文字符，#代表0个或多个, fanout：广播类型）
        * durable 是否持久化，代表交换机在服务器重启后是否还存在。
        * autoDelete 是否自动删除。如果为 true，至少有一个消费者连接到这个队列，之后所有与这个队列连接的消费者都断开时，队列会自动删除
        * arguments 交换机的属性
        *
        * */
        channel.exchangeDeclare(EXCHANGE_NAME, "direct", false, false, null);

        // 4、声明队列
        /*
        * QUEUE_NAME 队列的名字
        * durable 是否持久化，代表队列在服务器重启后是否还存在。
        * exclusive 是否排他性队列。排他性队列只能在声明它的 Connection中使用（可以在同一个 Connection 的不同的 channel 中使用），连接断开时自动删除。
        * autoDelete 是否自动删除。如果为 true，至少有一个消费者连接到这个队列，之后所有与这个队列连接的消费者都断开时，队列会自动删除
        * arguments 队列的属性（包括队列消息过期时间、队列消息最大数等）
        *
        * */
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 5、建立绑定关系
        /*
        * routingKey 绑定关键字
        * */
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "best.msg");

        // 6、创建消费者
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "UTF-8");
                System.out.println("Consumer received msg:" + msg);
            }
        };

        //7、开始消费消息
        /*
        * QUEUE_NAME 队列的名字
        * autoAck 如果服务器在传递消息后应将消息视为已确认，则为true；如果服务器希望得到明确的确认，则为false
        * */
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
