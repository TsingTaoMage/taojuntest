package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Register;
import com.example.demo.repository.RegisterRepository;

@Service
public class RegisterService {

	@Autowired
    private RegisterRepository registerRepository;

	public List<Register> getRegisterAll() {
		// TODO 自動生成されたメソッド・スタブ
		return registerRepository.findAll();
	}

	public Register findById(Long id) {
		return registerRepository.findById(id).get();
	}
	
	public void delete(Long id) {
		// TODO 自動生成されたメソッド・スタブ
		Register register = findById(id);
		registerRepository.delete(register);
	}

	public void save(Register register) {
		registerRepository.save(register);
		
	}
}
