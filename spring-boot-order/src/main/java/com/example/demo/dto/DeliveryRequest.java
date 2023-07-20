package com.example.demo.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class DeliveryRequest implements Serializable{

	private Long id;
	
    private String tableNumber;

    private String foodName;

    private int price;
	
}
