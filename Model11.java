package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="FinalBilling")
public class Model11 {
  
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id")
 private long id3;
	@Column(name="Customer_Name")
	 private String cutomername;
	@Column(name="Customer_Phono")
	 private String phoneno;
	@Column(name="Order_Id")
	 private String orderId;
	@Column(name="Delivery_Address")
	 private String address;
	public Model11() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Model11(long id3, String cutomername, String phoneno, String orderId, String address, String time,
			String totalbill, String paymentmethod) {
		super();
		this.id3 = id3;
		this.cutomername = cutomername;
		this.phoneno = phoneno;
		this.orderId = orderId;
		this.address = address;
		this.time = time;
		this.totalbill = totalbill;
		this.paymentmethod = paymentmethod;
	}
	@Override
	public String toString() {
		return "Model11 [id3=" + id3 + ", cutomername=" + cutomername + ", phoneno=" + phoneno + ", orderId=" + orderId
				+ ", address=" + address + ", time=" + time + ", totalbill=" + totalbill + ", paymentmethod="
				+ paymentmethod + "]";
	}
	public long getId3() {
		return id3;
	}
	public void setId3(long id3) {
		this.id3 = id3;
	}
	public String getCutomername() {
		return cutomername;
	}
	public void setCutomername(String cutomername) {
		this.cutomername = cutomername;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTotalbill() {
		return totalbill;
	}
	public void setTotalbill(String totalbill) {
		this.totalbill = totalbill;
	}
	public String getPaymentmethod() {
		return paymentmethod;
	}
	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}
	@Column(name="Food_PrepareTime")
	 private String time;
	@Column(name="Total_Bill")
	 private String totalbill;
	@Column(name="Payment_Method")
	 private String paymentmethod;
}
