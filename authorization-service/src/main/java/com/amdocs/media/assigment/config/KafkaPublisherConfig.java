package com.amdocs.media.assigment.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.amdocs.media.assigment.model.UserProfile;

@Configuration 
public class KafkaPublisherConfig {
	
	 @Bean
	public ProducerFactory<String,Object> producerFactory(){
		
	     Map<String, Object> config = new HashMap<>();

	        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

	        return new DefaultKafkaProducerFactory<>(config);
		
	}
	 @Bean
	    public KafkaTemplate<String, Object> kafkaTemplate() {
	        return new KafkaTemplate<>(producerFactory());
	    }
	 
	@Bean
	public ProducerFactory<String, String> producerStringFactory() {

		Map<String, Object> config = new HashMap<>();

		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

		return new DefaultKafkaProducerFactory<>(config);

	}

	@Bean
	public KafkaTemplate<String, String> kafkaStringTemplate() {
		return new KafkaTemplate<>(producerStringFactory());
	}

}
