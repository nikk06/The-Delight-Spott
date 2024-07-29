package com.example.demo;

public class Model3 {
  private String cemail;

public Model3() {
	super();
	// TODO Auto-generated constructor stub
}

public Model3(String cemail) {
	super();
	this.cemail = cemail;
}

@Override
public String toString() {
	return "Model3 [cemail=" + cemail + "]";
}

public String getCemail() {
	return cemail;
}

public void setCemail(String cemail) {
	this.cemail = cemail;
}
}
