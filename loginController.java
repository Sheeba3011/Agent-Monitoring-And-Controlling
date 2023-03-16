package com.javainspires.demothymeleaf.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.javainspires.demothymeleaf.form.LoginForm;
import jakarta.servlet.http.HttpServletRequest;
/*
 * This class is used to develop a agent monitoring and controlling project
 * 
 * Author - Sheeba Murugesan
 * Date -14-03-2023
 * Version - 1.0.0
 * */
@Controller
public class LoginController {
	//to get login form page
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getLoginForm() {
	//return html page name	
		return "login";
	}
	@RequestMapping(value = {"/aboutus"}, method = RequestMethod.POST)
	public String Aboutus(HttpServletRequest request, HttpServletRequest response)
	{
		return "home";
	}
	//checking for login credentials
	@RequestMapping(value="/login",method=RequestMethod.POST)
	//method=RequestMethod.GET
	public String login(@ModelAttribute(name="loginForm")LoginForm loginForm, Model model) {
		String username = loginForm.getUsername();
		String password = loginForm.getPassword();
		if("Sheeba".equals(username) &&"She@2011".equals(password)) {
			//if username and password is correct, we are returning home page
			return "home";
		}
		//if username or password is wrong 
		model.addAttribute("invalidCredentials",true);
		//returning again login page
		return"login";
	}
@RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
public String logoutDo(HttpServletRequest request, HttpServletRequest response)
{
	return "login";
}
}

