import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class KafkaConsumerOperation {
    private Properties properties = new Properties();
    @Test
    public void consumerTest() throws IOException {
        properties.load(KafkaConsumerOperation.class.getClassLoader().getResourceAsStream("consumer.properties"));
        Consumer consumer = new KafkaConsumer(properties);
        consumer.subscribe(Arrays.asList("hadoop"));
        while (true) {
            ConsumerRecords<Integer,String>  records = consumer.poll(1000);
            for (ConsumerRecord<Integer,String> record : records) {
                String message = record.value();
                System.out.println(message);
            }
        }
    }
}
