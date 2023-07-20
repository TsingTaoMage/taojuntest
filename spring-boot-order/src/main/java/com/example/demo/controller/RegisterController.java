package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Register;
import com.example.demo.service.RegisterService;


@Controller
public class RegisterController {

	@Autowired
	private RegisterService registerService;
	
	
	
	@GetMapping("/register")
	String register(Model model) {
		List<Register> registerlist = registerService.getRegisterAll();
		model.addAttribute("registerlist", registerlist);
		return "/register/register";
	}
	
    @GetMapping("/register/{id}/pay")
    public String delete(@PathVariable Long id, Model model) {
    	registerService.delete(id);
		List<Register> registerlist = registerService.getRegisterAll();
		model.addAttribute("kitchenlist", registerlist);
        return "/register/register";
    }
	
	
}
