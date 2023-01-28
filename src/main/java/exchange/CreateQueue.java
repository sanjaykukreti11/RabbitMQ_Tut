package exchange;

import basicQueue.CommonConfig;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class CreateQueue {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection(CommonConfig.AMQP_URL);

        Channel channel = connection.createChannel();

        channel.queueDeclare("q-1", true, false, false, null);
        channel.queueDeclare("q-2", true, false, false, null);
        channel.queueDeclare("q-3", true, false,false,null);

        channel.close();
        connection.close();

    }

}
