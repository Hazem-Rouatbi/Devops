package com.example.testApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.testApp.models.Specilization;
import com.example.testApp.models.User;
import com.example.testApp.service.SpecService;

@Controller
@RequestMapping("/spec")
public class SpecController {
	SpecService ss;
	
	public SpecController(SpecService ss) {
		super();
		this.ss = ss;
	}

	@GetMapping("/create")
	public String createSpec(Model m) {
				return "createspec";
	}
	
	@PostMapping("/save")
	public String saveSpec(@ModelAttribute Specilization s ,Model m){
		Long id =s.getIdSpec();
		ss.createSpec(s);
		if(id!=null) {
			return "redirect:/user/all";
		}else {
			return "createspec";
		}
		
	}

}
