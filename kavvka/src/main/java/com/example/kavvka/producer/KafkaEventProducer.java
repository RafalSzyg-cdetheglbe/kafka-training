package com.example.kavvka.producer;

import java.util.Map;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.databind.util.JSONPObject;

public class KafkaEventProducer
{
	@Value("${kafka.topic}")
	private String kafkaTopic;

	JSONPObject jsonpObject;
	private final KafkaProducer<String, Object> kafkaProducer;

	public KafkaEventProducer(final Map<String, Object> configs)
	{
		this.kafkaProducer = new KafkaProducer(configs);
		kafkaProducer.send(new ProducerRecord<>(kafkaTopic, jsonpObject.toString()));
	}

}
