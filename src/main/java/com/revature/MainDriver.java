package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controller.ReimbController;
import com.revature.controller.UserController;
import com.revature.models.User;
import com.revature.sevices.UserServiceImpl;

import io.javalin.Javalin;

public class MainDriver {
	
	private static Logger logger = LoggerFactory.getLogger(MainDriver.class);
	
	private static UserServiceImpl sv = new UserServiceImpl();

	public static void main(String[] args) {
		
		Javalin app = Javalin.create().start(8080);
		
		app.before("/test", ctx -> {
			logger.info("Request at URL " + ctx.url() + "has started.");
		});
	
		app.after("/test", ctx -> {
			logger.info("Request at URL " + ctx.url() + "is complete.");
		});
		
		app.post("/register", UserController.register);
		app.get("/user/byId", UserController.getUserById);
		app.get("/user/byUser", UserController.getUserByUsername);
		app.post("/login", UserController.login);
		app.delete("/logout", UserController.logout);
		app.post("/user/submit", ReimbController.submitTicket);
		
}
}

