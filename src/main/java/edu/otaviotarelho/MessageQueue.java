package edu.otaviotarelho;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.Future;
import java.util.logging.Logger;

public class MessageQueue {

    private static Properties properties;
    private static final String EMAIL_TOPIC = "EMAIL_TOPIC";
    private static final String KAFKA_IP = "127.0.0.1:9092";
    private static final String SERIALIZER_CLASS = "org.apache.kafka.common.serialization.StringSerializer";
    private static Logger logger = Logger.getLogger(MessageQueue.class.getName());

    private static KafkaProducer<String, String> createKafkaProducer() {

        properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_IP);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, SERIALIZER_CLASS);
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, SERIALIZER_CLASS);
        return new KafkaProducer<String, String>(properties);

    }

    public static void sendEvent(String JSON){

        KafkaProducer<String, String> producer = createKafkaProducer();

        ProducerRecord<String, String> record = new ProducerRecord<String, String>(EMAIL_TOPIC, JSON);

        Future<RecordMetadata> metadataFuture = producer.send(record);

        try{

            logger.warning("TOPIC: " + metadataFuture.get().topic());
            logger.info("isDone? : " + metadataFuture.isDone());
            logger.info("isCanceled? : " + metadataFuture.isCancelled());

        } catch (Exception e ){

        }

        producer.close();
    }
}
