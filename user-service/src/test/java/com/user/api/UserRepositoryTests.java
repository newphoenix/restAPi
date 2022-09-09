package com.user.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.user.api.entity.User;
import com.user.api.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Testcontainers
@Slf4j
public class UserRepositoryTests extends BasicTestController {
	

	@Autowired
	UserRepository userRepo;
	
	@Test
	public void testSaveUser() {
		
		User user = User.builder().name("Jamie").surname("Smith").age(31).build();
		User savedUser = userRepo.save(user);
		
		log.info("******* id: "+savedUser.getId());
		
		assertTrue(Objects.nonNull(savedUser.getId()));
	}
	
	@Test
	public void fetchUser() {
		
		
		User user = User.builder().name("Oliver").surname("Twist").age(31).build();
		User savedUser = userRepo.save(user);
		
		User fetchedUSer =  userRepo.findById(savedUser.getId()).get();
		
		assertTrue(Objects.nonNull(fetchedUSer));
		assertEquals("Oliver",fetchedUSer.getName());
		
	}

}
