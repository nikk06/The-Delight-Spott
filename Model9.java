package com.example.demo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Managedreservation")
public class Model9 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id")
	 private Long id1;
    @Column(name = "Customer_Name")
    private String tname;
    @Column(name="Customer_PHno")
    private String tphone;
    @Column(name="Visiting")
    private String ttime;
    @Column(name="Assigned_Tableno")
    private String tableNo;
	public Model9() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Model9(Long id1, String tname, String tphone, String ttime, String tableNo) {
		super();
		this.id1 = id1;
		this.tname = tname;
		this.tphone = tphone;
		this.ttime = ttime;
		this.tableNo = tableNo;
	}
	@Override
	public String toString() {
		return "Model9 [id1=" + id1 + ", tname=" + tname + ", tphone=" + tphone + ", ttime=" + ttime + ", tableNo="
				+ tableNo + "]";
	}
	public Long getId1() {
		return id1;
	}
	public void setId1(Long id1) {
		this.id1 = id1;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTphone() {
		return tphone;
	}
	public void setTphone(String tphone) {
		this.tphone = tphone;
	}
	public String getTtime() {
		return ttime;
	}
	public void setTtime(String ttime) {
		this.ttime = ttime;
	}
	public String getTableNo() {
		return tableNo;
	}
	public void setTableNo(String tableNo) {
		this.tableNo = tableNo;
	}
}
