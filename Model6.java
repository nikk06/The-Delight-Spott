package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="Delightspotbasicdetails")
public class Model6 {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
	@Column(name="Restro Name")
	private String resname;
	@Column(name="Restro City")
	private String rescity;
	@Column(name="Restro Phone_no")
	private String resphno;
	@Column(name = "Restro Pin")
	private String respin;
	public Model6() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Model6(Long id, String resname, String rescity, String resphno, String respin) {
		super();
		this.id = id;
		this.resname = resname;
		this.rescity = rescity;
		this.resphno = resphno;
		this.respin = respin;
	}
	@Override
	public String toString() {
		return "Model6 [id=" + id + ", resname=" + resname + ", rescity=" + rescity + ", resphno=" + resphno
				+ ", respin=" + respin + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getResname() {
		return resname;
	}
	public void setResname(String resname) {
		this.resname = resname;
	}
	public String getRescity() {
		return rescity;
	}
	public void setRescity(String rescity) {
		this.rescity = rescity;
	}
	public String getResphno() {
		return resphno;
	}
	public void setResphno(String resphno) {
		this.resphno = resphno;
	}
	public String getRespin() {
		return respin;
	}
	public void setRespin(String respin) {
		this.respin = respin;
	}
}
