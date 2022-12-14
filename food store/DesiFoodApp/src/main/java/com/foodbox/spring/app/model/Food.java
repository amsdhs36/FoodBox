package com.foodbox.spring.app.model;
import java.util.Arrays;

import javax.persistence.*;
@Entity
@Table(name = "food")
public class Food {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private String price;

	@Column(name = "picByte", length = 1000)
	private byte[] picByte;
	public Food() {
		//TODO Auto-generated constructor stub
	}
	public Food(Long id, String name, String description, String price, byte[] picByte) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.picByte = picByte;
	}
	public Food(String name, String description, String price, byte[] picByte) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.picByte = picByte;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public byte[] getPicByte() {
		return picByte;
	}
	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}
	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", picByte="
				+ Arrays.toString(picByte) + "]";
	}
	
}