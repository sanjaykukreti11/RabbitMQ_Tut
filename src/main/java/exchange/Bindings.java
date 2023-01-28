package exchange;

import basicQueue.CommonConfig;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Bindings {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection(CommonConfig.AMQP_URL);

        Channel channel = connection.createChannel();

        channel.queueBind("q-1", "direct1", "firstBind");
        channel.queueBind("q-2", "direct1", "mySecond");

        channel.close();
        connection.close();
    }

}
