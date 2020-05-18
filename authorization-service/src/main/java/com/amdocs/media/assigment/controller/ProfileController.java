package com.amdocs.media.assigment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.media.assigment.model.User;
import com.amdocs.media.assigment.model.UserProfile;

@RestController
@RequestMapping("/profile")
public class ProfileController {
	
	  @Autowired
	    private KafkaTemplate<String, Object> kafkaTemplate;
	  @Autowired
	    private KafkaTemplate<String, String> kafkaStringTemplate;
	  private static final String TOPIC = "Kafka_Micro";
	
	@PutMapping("/update")
	public String updateProfile(@RequestBody UserProfile userProfile ) {
		
		 kafkaTemplate.send(TOPIC,userProfile);
		
		 return "Updated successfully";
		
		
	}
	
	@DeleteMapping("/{id}")
	public String updateProfile(@PathVariable("id")String id ) {
		
		kafkaStringTemplate.send(TOPIC,id);
			
		 return "Deleted successfully";
		

	}
	


}
