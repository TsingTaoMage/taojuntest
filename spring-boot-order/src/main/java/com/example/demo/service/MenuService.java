package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Menu;
import com.example.demo.repository.MenuRepository;

@Service
public class MenuService {

    /**
     * 都道府県マスタ Repository
     */
    @Autowired
    private MenuRepository menuRepository;

	public List<Menu> getMenuAll() {
		// TODO 自動生成されたメソッド・スタブ
		return menuRepository.findAll();
	}

	public Optional<Menu> getPhotoById(Long id) {
		// TODO 自動生成されたメソッド・スタブ
		return menuRepository.findById(id);
	}

	public Menu findById(Long id) {
		// TODO 自動生成されたメソッド・スタブ
		return menuRepository.findById(id).get();
	}
	
	
}
