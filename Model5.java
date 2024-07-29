package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="DelightSpotMenu")
public class Model5 {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
	public Model5() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Model5(Long id, String dishname, String dishQuantity, String dishPrice, String description, String dimage1) {
		super();
		this.id = id;
		Dishname = dishname;
		DishQuantity = dishQuantity;
		DishPrice = dishPrice;
		Description = description;
		this.dimage1 = dimage1;
	}
	@Override
	public String toString() {
		return "Model5 [id=" + id + ", Dishname=" + Dishname + ", DishQuantity=" + DishQuantity + ", DishPrice="
				+ DishPrice + ", Description=" + Description + ", dimage1=" + dimage1 + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDishname() {
		return Dishname;
	}
	public void setDishname(String dishname) {
		Dishname = dishname;
	}
	public String getDishQuantity() {
		return DishQuantity;
	}
	public void setDishQuantity(String dishQuantity) {
		DishQuantity = dishQuantity;
	}
	public String getDishPrice() {
		return DishPrice;
	}
	public void setDishPrice(String dishPrice) {
		DishPrice = dishPrice;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getDimage1() {
		return dimage1;
	}
	public void setDimage1(String dimage1) {
		this.dimage1 = dimage1;
	}
	@Column(name="Dish Name")
	private String Dishname;
	@Column(name="Dish Quantity")
	private String DishQuantity;
	@Column(name="Dish Price")
	private String DishPrice;
	@Column(name="Description")
	private String Description;
	@Column(name="Dish Image")
	private String dimage1;
	
}
