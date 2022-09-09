package com.user.api.exception;

import java.time.OffsetDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiError {

	private OffsetDateTime timestamp;
	private int status;
	private String message;
	private List<String> errors;
}
