package rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author：renpeng
 * @date：2019/8/30
 */
public class RabbitProducer {
    //创建交换机
    private static final String EXCHANGE_NAME="SIMPLE_EXCHANGE";

    public static void main(String[] args) throws IOException, TimeoutException {
        //1、通过连接工厂建立连接
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");//IP
        factory.setPort(5672);//端口
        factory.setVirtualHost("/");//虚拟机
        factory.setUsername("guest");//用户名（默认）
        factory.setPassword("guest");//密码（默认）

        //2、建立连接
        Connection conn = factory.newConnection();

        //3、建立信道
        Channel channel = conn.createChannel();

        /*验证生产者消息发送到rabbitmq*/
        /*① 事务transaction模式*/
        try {
            channel.txSelect();//将信道设置成事务模式

            //4、发送消息
            String msg = "my fist msg";

            /*
             * String exchange 交换机
             * String routingKey 路由关键字
             * BasicProperties props 属性
             * byte[] body 消息体
             * */
            channel.basicPublish(EXCHANGE_NAME, "best.msg", null, msg.getBytes());
            channel.txCommit();
            System.out.println("消息发送成功");
        } catch (Exception e) {
            channel.txRollback();
            System.out.println("消息发送失败，回滚消息");
        }

        channel.close();
        conn.close();
    }

}
