package edu.otaviotarelho.consumer;

import com.google.gson.Gson;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.UUID;
import java.util.logging.Logger;

public class MessageQueueConsumer {
    private static Logger logger = Logger.getLogger(MessageQueueConsumer.class.getName());

    private static KafkaConsumer<String, String> createKafkaConsumer(){

        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, UUID.randomUUID().toString());
        properties.put(ConsumerConfig.CLIENT_ID_CONFIG, "ID_CLIENT" + UUID.randomUUID().toString());
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        return new KafkaConsumer<>(properties);
    }


    public static void executeConsumer(){
        KafkaConsumer<String, String> consumer = createKafkaConsumer();

        consumer.subscribe(Collections.singleton("EMAIL_TOPIC"));

        while (true){
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));

            records.forEach( record -> {
                EventInformation event = new Gson().fromJson(record.value(), EventInformation.class);

                //TODO:SOME PROCESSING WITH THE INFORMATION HERE

                logger.info(event.toString());
            });

        }
    }
}
