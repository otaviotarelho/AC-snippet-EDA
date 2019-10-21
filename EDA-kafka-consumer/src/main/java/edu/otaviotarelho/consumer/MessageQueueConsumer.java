package edu.otaviotarelho.consumer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import static org.apache.kafka.common.requests.DeleteAclsResponse.log;

public class MessageQueueConsumer {

    public static String groupid = "email-queue";

    private static KafkaConsumer<String, String> createKafkaConsumer(){

        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupid);
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        return new KafkaConsumer<>(properties);
    }


    public static void executeConsumer(){
        KafkaConsumer<String, String> consumer = createKafkaConsumer();

        consumer.subscribe(Collections.singleton("EMAIL_TOPIC"));

        while (true){
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));

            for(ConsumerRecord record : records){
                //TODO:SOME PROCESSING WITH THE INFORMATION HERE
                log.info("Value:" + record.value());

                EventInformation event = new Gson().fromJson(record.value().toString(), EventInformation.class);
            }
        }
    }
}
