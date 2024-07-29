package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CartValue1")
public class Model101 {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id")
 private long id3;
	@Column(name="Quantity")
	private String quantity;
	@Column(name="Receiver's Name")
	private String name;
	@Column(name="Receiver's Mobile No")
	private String mno;
	@Column(name="Receiver's Address")
	private String address;
	@Column(name="Dish_Name")
	private String dishName;
	public Model101() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Model101(long id3, String quantity, String name, String mno, String address, String dishName) {
		super();
		this.id3 = id3;
		this.quantity = quantity;
		this.name = name;
		this.mno = mno;
		this.address = address;
		this.dishName = dishName;
	}
	@Override
	public String toString() {
		return "Model101 [id3=" + id3 + ", quantity=" + quantity + ", name=" + name + ", mno=" + mno + ", address="
				+ address + ", dishName=" + dishName + "]";
	}
	public long getId3() {
		return id3;
	}
	public void setId3(long id3) {
		this.id3 = id3;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMno() {
		return mno;
	}
	public void setMno(String mno) {
		this.mno = mno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
}
