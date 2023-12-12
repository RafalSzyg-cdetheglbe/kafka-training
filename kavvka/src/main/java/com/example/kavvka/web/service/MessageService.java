package com.example.kavvka.web.service;

import com.example.kavvka.configuration.KafkaConfiguration;
import com.example.kavvka.producer.KafkaEventProducer;

public class MessageService
{
	private final KafkaConfiguration kafkaConfiguration;
	private final KafkaEventProducer kafkaEventProducer;

	MessageService(final KafkaConfiguration kafkaConfiguration, final KafkaEventProducer kafkaEventProducer)
	{
		this.kafkaConfiguration = kafkaConfiguration;
		this.kafkaEventProducer = kafkaEventProducer;
	}

	public void postMessage()
	{
		
	}
}
