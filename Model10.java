package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CartValue")
public class Model10 {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id")
  private long id2;
	@Column(name="Dish_Name")
	private String dishName;
	public Model10() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Model10(long id2, String dishName, String quantity, String name, String mno, String address) {
		super();
		this.id2 = id2;
		this.dishName = dishName;
		this.quantity = quantity;
		this.name = name;
		this.mno = mno;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Model10 [id2=" + id2 + ", dishName=" + dishName + ", quantity=" + quantity + ", name=" + name + ", mno="
				+ mno + ", address=" + address + "]";
	}
	public long getId2() {
		return id2;
	}
	public void setId2(long id2) {
		this.id2 = id2;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
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
	@Column(name="Quantity")
	private String quantity;
	@Column(name="Receiver's Name")
	private String name;
	@Column(name="Receiver's Mobile No")
	private String mno;
	@Column(name="Receiver's Address")
	private String address;
}
