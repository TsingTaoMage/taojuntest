package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Kitchen;
import com.example.demo.repository.KitchenRepository;

@Service
public class KitchenService {

	@Autowired
    private KitchenRepository kitchenRepository;

	public List<Kitchen> getKitchenAll() {
		// TODO 自動生成されたメソッド・スタブ
		return kitchenRepository.findAll();
	}

	
	public Kitchen findById(Long id) {
		return kitchenRepository.findById(id).get();
	}
	
	
	public void delete(Long id) {
		// TODO 自動生成されたメソッド・スタブ
		Kitchen kitchen = findById(id);
		kitchenRepository.delete(kitchen);
	}


	public void save(Kitchen kitchen) {
		kitchenRepository.save(kitchen);
	}
	
}
