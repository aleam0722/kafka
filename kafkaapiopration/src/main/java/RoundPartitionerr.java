import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class RoundPartitionerr implements Partitioner {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        int parCount = cluster.partitionCountForTopic(topic);
        int partition = atomicInteger.getAndIncrement() % parCount;
        return partition;
    }

    public void close() {

    }

    public void configure(Map<String, ?> configs) {

    }
}
