package com.user.api;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;

public abstract class BasicTestController {
	
	@Container
	public static MySQLContainer<?> container = new MySQLContainer<>("mysql:8.0.28-oracle").withUsername("root")
			.withPassword("root").withDatabaseName("user_service");

	@DynamicPropertySource
	static void properties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", container::getJdbcUrl);
		registry.add("spring.datasource.password", container::getPassword);
		registry.add("spring.datasource.username", container::getUsername);
	}
	

}
