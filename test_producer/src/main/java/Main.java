import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/10/05
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        while(true) {
            Properties configs = new Properties();
            // bootstrap 서버 설정, 일반적으로 2개 이상의 ip와 port사용을 권장
            configs.put("bootstrap.servers", "localhost:9092");
            configs.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            configs.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

            KafkaProducer<String, String> producer = new KafkaProducer<String, String>(configs);

            ProducerRecord<String, String> record = new ProducerRecord<String, String>("click_log", "test");

            producer.send(record);
            producer.close();
            Thread.sleep(500);
        }
    }
}
