package com.revature.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.revature.controller.UserController;
import com.revature.models.User;
import com.revature.sevices.UserServiceImpl;

import io.javalin.Javalin;
import io.javalin.http.Handler;
import io.javalin.http.HttpStatus;

public class UserController {

	Javalin app = Javalin.create().start(8080);
	
private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	private static UserServiceImpl uServ = new UserServiceImpl();

	public static Handler register = ctx -> {
		
		logger.info("User is making a registration request...");
		
		String body = ctx.body();
		
		ObjectMapper om = new ObjectMapper();
		om.registerModule(new JavaTimeModule());
		
		User target = om.readValue(body, User.class);
		
		boolean isCreated = uServ.registerUser(target);
		
		if(isCreated == true) {
			ctx.html("The new user has been created successfully.");
			ctx.status(HttpStatus.CREATED);
		}else {
			ctx.html("Error during creation. Try again.");
			ctx.status(HttpStatus.NO_CONTENT);
		}
		
	};
	
}
