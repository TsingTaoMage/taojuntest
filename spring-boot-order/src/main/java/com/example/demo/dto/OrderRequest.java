package com.example.demo.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * ユーザー情報登録 リクエストデータ
 */
@Data
public class OrderRequest implements Serializable {

    
    private String tableNumber;

    private String foodName;

    private int price;
    
}
