package com.user.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.api.entity.User;
import com.user.api.exception.ApiError;
import com.user.api.service.UserService;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
	
	private UserService userService;
	
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200",description = "get all users", content = @Content(array=@ArraySchema(schema=@Schema(implementation = User.class))))
	    ,   @ApiResponse(responseCode = "400",description = "Bad request", content = @Content(schema = @Schema(implementation = ApiError.class)))
	})
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUsers());
	}
	

	@ApiResponses(value= {
			@ApiResponse(responseCode = "200",description = "Fetch user", content =  @Content(schema = @Schema(implementation = User.class)))
	    ,   @ApiResponse(responseCode = "400",description = "Bad request", content = @Content(schema = @Schema(implementation = ApiError.class)))
	})
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer id){
		return ResponseEntity.ok(userService.getUserById(id));
	}
	
	@ApiResponses(value= {
			@ApiResponse(responseCode = "201",description = "Creating new user", content =  @Content(schema = @Schema(implementation = User.class)))
	    ,   @ApiResponse(responseCode = "400",description = "Bad request", content = @Content(schema = @Schema(implementation = ApiError.class)))
	})	
   @PostMapping
   public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
	   return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
   }
   
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200",description = "Updating user", content =  @Content(schema = @Schema(implementation = User.class)))
	    ,   @ApiResponse(responseCode = "400",description = "Bad request", content = @Content(schema = @Schema(implementation = ApiError.class)))
	})
   @PutMapping
   public ResponseEntity<User> updateUser(@Valid @RequestBody User user){
	   return ResponseEntity.ok(userService.updateUser(user));
   }
   
	@ApiResponses(value= {
			@ApiResponse(responseCode = "204",description = "Deleteing user")
	    ,   @ApiResponse(responseCode = "400",description = "Bad request", content = @Content(schema = @Schema(implementation = ApiError.class)))
	})
	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
	     userService.deleteUser(id);
	     return ResponseEntity.noContent().build();
	}

}
