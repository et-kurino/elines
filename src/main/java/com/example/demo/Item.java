package com.example.demo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Item {
	String itemCode;
	String name;
	String price;
	String img;
}
