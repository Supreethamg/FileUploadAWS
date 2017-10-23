package main.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import main.service.UserService;

@Controller

public class UserController {
	
		@Autowired
		private UserService userservice;
		
		@RequestMapping("/")
		public String login() {
			return "Login";
		}
		
		@RequestMapping(method=RequestMethod.POST ,value="/login")	
		public String checkUser(ModelMap model, @RequestParam String username, @RequestParam String password){
			System.out.println("inside checkUser:"+username);
		    boolean isValidUser = userservice.validateUser(username, password);

		    if (!isValidUser) {
		        model.put("errorMessage", "Invalid Credentials");
		        return "Login";
		    }

		    model.addAttribute("name", username);
		    return "Home";
		}
}

