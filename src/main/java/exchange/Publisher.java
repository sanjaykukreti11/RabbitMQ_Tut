package exchange;

import basicQueue.CommonConfig;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Publisher {
    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection(CommonConfig.AMQP_URL);

        Channel channel = connection.createChannel();

        for (int i=0;i<4;i++){
            String message = " The id of this message is  " + (i+1);
            channel.basicPublish("direct1", "firstBind"  , null, message.getBytes());
        }

        for (int i=0;i<4;i++){
            String message = " Hi everyone .";
            channel.basicPublish("direct1", "mySecond" , null , message.getBytes());
        }

        channel.close();
        connection.close();
    }
}
