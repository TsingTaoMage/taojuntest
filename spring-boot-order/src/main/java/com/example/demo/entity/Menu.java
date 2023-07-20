package com.example.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "menu")
public class Menu  implements Serializable{
	/**
	* ID
	*/
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	  
	/**
	* 食べ物の名前
	*/
	@Column(name = "foodname")
	private String foodname;
	  
	/**
	* 価格
	*/
	@Column(name = "price")
	private int price;
	  
	  
	@Lob
	@Column(name = "photo")
	private byte[] photo;
	
	
	public byte[] getPhoto() {
		return photo;
	}
}
