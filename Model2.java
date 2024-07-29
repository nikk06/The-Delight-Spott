package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="RestrousernameAndpasssword")
public class Model2 {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id")
	    private Long id;
	     public Model2() {
		super();
		// TODO Auto-generated constructor stub
	}
		public Model2(Long id, String remaill, String rpasssowrd) {
		super();
		this.id = id;
		Remaill = remaill;
		Rpasssowrd = rpasssowrd;
	}
		@Override
	public String toString() {
		return "Model2 [id=" + id + ", Remaill=" + Remaill + ", Rpasssowrd=" + Rpasssowrd + "]";
	}
		public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRemaill() {
		return Remaill;
	}
	public void setRemaill(String remaill) {
		Remaill = remaill;
	}
	public String getRpasssowrd() {
		return Rpasssowrd;
	}
	public void setRpasssowrd(String rpasssowrd) {
		Rpasssowrd = rpasssowrd;
	}
		@Column(name="Restro Email")
	    private String Remaill;
	     @Column(name="Restro Password")
	     private String Rpasssowrd;

}
