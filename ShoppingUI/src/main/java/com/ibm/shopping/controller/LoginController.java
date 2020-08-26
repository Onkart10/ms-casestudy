package com.ibm.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ibm.shopping.model.UserDao;
import com.ibm.shopping.service.LoginService;


@Controller
public class LoginController {
	
	@Autowired
    LoginService service;
	
	@GetMapping(value= {"/", "/login"})
    public String showLoginPage(ModelMap model){
		model.addAttribute("userForm", new UserDao());
        return "login";
    }
	
	@PostMapping(value="/login")
    public String showWelcomePage(Model model, @ModelAttribute("userForm") UserDao user, RedirectAttributes redir){

		String token = service.validateUser(user.getUsername(), user.getPassword());
		System.out.println("UserName: "+user.getUsername() + ": Pwd: "+user.getPassword());
		if(token!=null) {
			redir.addFlashAttribute("username", user.getUsername());
			redir.addFlashAttribute("token", token);
			redir.addFlashAttribute("msg", "Login successful");
	        
	        return "redirect:/welcome";
	        
		}else {
			model.addAttribute("errorMessage", "Invalid credentials");
			return "login";
		}
    }
	
	@RequestMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }
}
