package com.user.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.user.api.entity.User;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Testcontainers
@Slf4j
public class UserControllerTests  extends BasicTestController {
	
	@Autowired
	TestRestTemplate testRestTemplate;
	
	@Test
	public void testGetUserById() {
		
		User user = testRestTemplate.exchange("/users/1", HttpMethod.GET,null,User.class).getBody();
		
		assertTrue(Objects.nonNull(user));
		assertTrue(user.getId() == 1);
		assertEquals("John", user.getName());
	}
	
	@Test
	public void testGetAllUsers() {
		
		List<User> users = testRestTemplate.exchange("/users", HttpMethod.GET,null,new ParameterizedTypeReference<List<User>>() {
		}).getBody();
		
		assertTrue(Objects.nonNull(users));

        users.forEach(e-> log.info(e.toString()));
		
	}

}
