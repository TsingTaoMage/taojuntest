package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.DeliveryRequest;
import com.example.demo.entity.Kitchen;
import com.example.demo.entity.Register;
import com.example.demo.service.KitchenService;
import com.example.demo.service.RegisterService;


@Controller
public class KitchenController {

	@Autowired
	private KitchenService kitchenService;
	
	@Autowired
	private RegisterService registerService;
	
	@GetMapping("/kitchen")
	String index(Model model) {
		List<Kitchen> kitchenlist = kitchenService.getKitchenAll();
		model.addAttribute("kitchenlist", kitchenlist);
		return "/kitchen/kitchen";
	}
	

//    @GetMapping("/kitchen/{id}/delivery")
//    public String delete(@PathVariable Long id, Model model) {
//        kitchenService.delete(id);
//		List<Kitchen> kitchenlist = kitchenService.getKitchenAll();
//		model.addAttribute("kitchenlist", kitchenlist);
//        return "/kitchen/kitchen";
//    }
	
    @GetMapping("/kitchen/{id}/delivery")
	public String delivery(@PathVariable Long id,@ModelAttribute DeliveryRequest deliveryRequest, BindingResult result, Model model) {
		
    	Kitchen kitchen = kitchenService.findById(id);
    	Register register = new Register();
    	register.setId(id);
    	register.setTableNumber(kitchen.getTableNumber());
    	register.setFoodName(kitchen.getFoodName());
    	register.setPrice(kitchen.getPrice());
    	register.setOrderDate(kitchen.getOrderDate());
		java.util.Date nowTime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		register.setDeliveryDate(sdf.format(nowTime));  

    	
    	if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
		for (ObjectError error : result.getAllErrors()) {
			errorList.add(error.getDefaultMessage());
		}
		model.addAttribute("validationError", errorList);
		return "redirect:/kitchen";
		}
    	
		registerService.save(register);
		kitchenService.delete(id);
		return "redirect:/kitchen";
    }
    
    
}
