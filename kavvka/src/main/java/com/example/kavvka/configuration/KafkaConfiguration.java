package com.example.kavvka.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfiguration
{
	private static final String DEFAULT_KAFKA_HOST = "localhost:9092";

	private static final String CONSUMER_GROUP_ID = "kavvkaApi";
	private static final String DEFAULT_KAFKA_TOPIC = "kafka-training-topic";
	private final String kafkaHost;
	private final String kafkaTopic;

	public KafkaConfiguration()
	{
		this.kafkaHost = DEFAULT_KAFKA_HOST;
		this.kafkaTopic = DEFAULT_KAFKA_TOPIC;
	}

	public Map<String, Object> createProducerConfiguration()
	{
		final Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaHost);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		return config;
	}

	public Map<String, Object> createConsumerConfiguration()
	{
		final Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaHost);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, CONSUMER_GROUP_ID);
		config.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 50);
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		return config;
	}

}
