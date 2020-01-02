import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

public class KafkaProducerOpration  {
    private Properties properties = new Properties();
    @Test
    public void myTest() throws IOException {
        properties.load(KafkaProducerOpration.class.getClassLoader().getResourceAsStream("producer.properties"));
        Producer<Integer,String> producer = new KafkaProducer<Integer, String>(properties);
        System.out.println(producer);

        ProducerRecord<Integer, String> record = new ProducerRecord<Integer, String>("hadoop", 10, "xixi");

        producer.send(record);
        producer.close();
    }

}
