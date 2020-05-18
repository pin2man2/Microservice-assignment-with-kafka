package com.amdocs.media.assigment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.client.RestTemplate;

import com.amdocs.media.assigment.dao.UserRepository;
import com.amdocs.media.assigment.model.User;


@EnableDiscoveryClient
@SpringBootApplication
@EnableZuulProxy
@EnableWebSecurity
public class AuthorizationServiceApplication implements CommandLineRunner{

	@Autowired
	private UserRepository repo;
	public static void main(String[] args) {
		SpringApplication.run(AuthorizationServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setUserName("ranjan");
		user.setPassword("password");
		try {
			repo.save(user);
		} catch (Exception e) {
		     e.printStackTrace();
		}
		
	}

	

}

