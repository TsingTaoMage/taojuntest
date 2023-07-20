package com.example.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "kitchen")
public class Kitchen implements Serializable{

	/**
	* orderid
	*/
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	  
	/**
	* テーブル番号
	*/
	@Column(name = "tablenumber")
	private String tableNumber;
	  
	/**
	* 食べ物の名前
	*/
	@Column(name = "foodname")
	private String foodName;
	
	/**
	* 価格
	*/
	@Column(name = "price")
	private int price;
	
    /**
     * 注文時間
     */
	@Column(name = "orderdate")
    private String orderDate;

	
	
}
