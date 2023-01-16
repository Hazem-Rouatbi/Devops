package com.example.testApp.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.testApp.models.Address;
import com.example.testApp.models.User;
import com.example.testApp.service.AddressService;
import com.example.testApp.service.SpecService;
import com.example.testApp.service.UserService;



@Controller
@RequestMapping("/user")
public class UserController {

	AddressService as;
	SpecService ss;
	UserService us;
	
	
	public UserController(AddressService as, SpecService ss, UserService us) {
		super();
		this.as = as;
		this.ss = ss;
		this.us = us;
	}
	@GetMapping("all")
	public String getAllUser(Model m) {
		List<User> liste = us.getAllUsers();
		m.addAttribute("liste",liste);
		return "listusers";
	}
	@GetMapping("/byname")
	public String getUser(@RequestParam String mc,Model m) {
		//List<User> liste = us.;
		return "listusers";
	}

	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		us.deleteUser(id);
		return "redirect:/user/all";
	}
	
	@GetMapping("/create")
	public String createUser(Model m) {
		
		m.addAttribute("specs",ss.getAllSpec());
		return "createuser";
	}
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute User u,@ModelAttribute Address addr ,Model m){
		Long id =u.getIdUser();

		as.createAddr(addr);
		u.setAdress(addr);
		us.createUser(u);
		
		if(id!=null) {
			return "redirect:/user/all";
		}else {
			m.addAttribute("message","User Created Sucessfully");
			m.addAttribute("specs",ss.getAllSpec());
			return "createuser";
		}
		
	}
	
	@GetMapping("/edit/{id}")
	public String modifierProduit(Model m,@PathVariable("id") Long id) {
		m.addAttribute("specs",ss.getAllSpec());
		m.addAttribute("user",us.getUser(id));
		return "createuser";
	}


}
