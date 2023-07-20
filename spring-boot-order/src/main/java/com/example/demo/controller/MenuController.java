package com.example.demo.controller;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.OrderRequest;
import com.example.demo.entity.Kitchen;
import com.example.demo.entity.Menu;
import com.example.demo.service.KitchenService;
import com.example.demo.service.MenuService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;


@Controller
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@Autowired
	private KitchenService kitchenService;
	
	@GetMapping("/menu")
	String index(Model model) {
		List<Menu> menulist = menuService.getMenuAll();
		model.addAttribute("menulist", menulist);
		return "/menu/menu";
	}
	
	@GetMapping("/photo/display/{id}")
	@ResponseBody
	void showImage(@PathVariable("id") Long id, HttpServletResponse response, Optional<Menu> menuOptional)
			throws ServletException, IOException {
		menuOptional = menuService.getPhotoById(id);
		response.setContentType("photo/jpeg, photo/jpg, photo/png, photo/gif");
		response.getOutputStream().write(menuOptional.get().getPhoto());
		response.getOutputStream().close();
	}
	
    @GetMapping("/menu/{id}/order")
	public String order(@PathVariable Long id, @ModelAttribute OrderRequest orderRequest, BindingResult result, Model model) {
		Menu menu = menuService.findById(id);
		Kitchen kitchen = new Kitchen();
		kitchen.setFoodName(menu.getFoodname());
		kitchen.setTableNumber("test");
		kitchen.setPrice(menu.getPrice());
		java.util.Date nowTime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		kitchen.setOrderDate(sdf.format(nowTime));  	
    	
    	if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
		for (ObjectError error : result.getAllErrors()) {
			errorList.add(error.getDefaultMessage());
		}
		model.addAttribute("validationError", errorList);
		return "redirect:/menu";
		}
		kitchenService.save(kitchen);
		return "redirect:/menu";
    }
	
	
}
