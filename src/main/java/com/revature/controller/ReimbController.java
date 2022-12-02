package com.revature.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.revature.controller.UserController;
import com.revature.models.Reimbursements;
import com.revature.models.User;
import com.revature.sevices.UserServiceImpl;

import com.revature.sevices.ReimbServiceImpl;

import io.javalin.Javalin;
import io.javalin.http.Handler;
import io.javalin.http.HttpStatus;

public class ReimbController {

	Javalin app = Javalin.create().start(8080);
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
		
		private static ReimbServiceImpl rServ = new ReimbServiceImpl();
		
		public static Handler submitTicket = ctx -> {
			
			logger.info("User is making a registration request...");
			
			String body = ctx.body();
			
			
			ObjectMapper om = new ObjectMapper();
			om.registerModule(new JavaTimeModule());
			
			Reimbursements target = om.readValue(body, Reimbursements.class);
			
			boolean isCreated = rServ.submitTicket(target);
			
			if(isCreated == true) {
				ctx.html("The new ticket has been submitted successfully.");
				ctx.status(HttpStatus.CREATED);
			}else {
				ctx.html("Error during submission. Try again.");
				ctx.status(HttpStatus.NO_CONTENT);
			}
			
		};
		
		public static Handler updateTicket = ctx -> {
			
			logger.info("User is making a update Request...");
			
			String body = ctx.body();
			
			ObjectMapper om = new ObjectMapper();
			om.registerModule(new JavaTimeModule());
			
			Reimbursements target = om.readValue(body, Reimbursements.class);
			
			boolean isCreated = rServ.updateTicket(target);
			
			if(isCreated = true) {
				
			}
			
		};
	
}
