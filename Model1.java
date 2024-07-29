package com.example.demo;

public class Model1 {
  private String vemail;

public Model1() {
	super();
	// TODO Auto-generated constructor stub
}

public Model1(String vemail) {
	super();
	this.vemail = vemail;
}

@Override
public String toString() {
	return "Model1 [vemail=" + vemail + "]";
}

public String getVemail() {
	return vemail;
}

public void setVemail(String vemail) {
	this.vemail = vemail;
}
}
