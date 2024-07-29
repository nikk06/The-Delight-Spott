package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CustomerusernameAndpasssword")
public class Model4 {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id")
	    private Long id;
	    @Column(name="Customer Email")
	    private String Cemaill;
	    public Model4() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Model4(Long id, String cemaill, String cpasssowrd) {
			super();
			this.id = id;
			Cemaill = cemaill;
			Cpasssowrd = cpasssowrd;
		}
		@Override
		public String toString() {
			return "Model4 [id=" + id + ", Cemaill=" + Cemaill + ", Cpasssowrd=" + Cpasssowrd + "]";
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getCemaill() {
			return Cemaill;
		}
		public void setCemaill(String cemaill) {
			Cemaill = cemaill;
		}
		public String getCpasssowrd() {
			return Cpasssowrd;
		}
		public void setCpasssowrd(String cpasssowrd) {
			Cpasssowrd = cpasssowrd;
		}
		@Column(name="Customer Password")
	    private String Cpasssowrd;
}
