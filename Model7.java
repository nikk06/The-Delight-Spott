package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="CustomerTableReservation")
public class Model7 {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
	public Model7() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Model7 [id=" + id + ", Reqname=" + Reqname + ", ReqidProof=" + ReqidProof + ", Reqphone=" + Reqphone
				+ ", ReqtableFor=" + ReqtableFor + ", Reqdate=" + Reqdate + ", ReqtimeFrom=" + ReqtimeFrom
				+ ", ReqtimeTo=" + ReqtimeTo + ", Status=" + Status + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReqname() {
		return Reqname;
	}
	public void setReqname(String reqname) {
		Reqname = reqname;
	}
	public String getReqidProof() {
		return ReqidProof;
	}
	public void setReqidProof(String reqidProof) {
		ReqidProof = reqidProof;
	}
	public String getReqphone() {
		return Reqphone;
	}
	public void setReqphone(String reqphone) {
		Reqphone = reqphone;
	}
	public String getReqtableFor() {
		return ReqtableFor;
	}
	public void setReqtableFor(String reqtableFor) {
		ReqtableFor = reqtableFor;
	}
	public String getReqdate() {
		return Reqdate;
	}
	public void setReqdate(String reqdate) {
		Reqdate = reqdate;
	}
	public String getReqtimeFrom() {
		return ReqtimeFrom;
	}
	public void setReqtimeFrom(String reqtimeFrom) {
		ReqtimeFrom = reqtimeFrom;
	}
	public String getReqtimeTo() {
		return ReqtimeTo;
	}
	public void setReqtimeTo(String reqtimeTo) {
		ReqtimeTo = reqtimeTo;
	}
	@Column(name="Customer Name")
	private String Reqname;
	@Column(name="Id Proof")
	private String ReqidProof;
	@Column(name="Customer Phone_no")
	private String Reqphone;
	@Column(name="Table For")
	private String ReqtableFor;
	@Column(name="Date")
	private String Reqdate;
	@Column(name="Visiting Time")
	private String ReqtimeFrom;
	@Column(name="Ending Time")
	private String ReqtimeTo;
	@Column(name="Your Current Status")
	private String Status;
	public Model7(Long id, String reqname, String reqidProof, String reqphone, String reqtableFor, String reqdate,
			String reqtimeFrom, String reqtimeTo, String status) {
		super();
		this.id = id;
		Reqname = reqname;
		ReqidProof = reqidProof;
		Reqphone = reqphone;
		ReqtableFor = reqtableFor;
		Reqdate = reqdate;
		ReqtimeFrom = reqtimeFrom;
		ReqtimeTo = reqtimeTo;
		Status = status;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
}
