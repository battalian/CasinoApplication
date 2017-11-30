package com.nagarro.CasinoAdmin.models;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import com.nagarro.CasinoAdmin.annotation.NameChecker;

@Entity
public class UserDetails {

	//	@NameChecker(message = "name should contan only spaces and alphabets")
	private String name;

	private String email;
	private String number;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private Double amount;
	private Double blockedAmount;
	private String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public UserDetails(String name, String email, String number, Long id, Double amount, Double blockedAmount,
			String image, String uid, Date dob) {
		super();
		this.name = name;
		this.email = email;
		this.number = number;
		this.id = id;
		this.amount = amount;
		this.blockedAmount = blockedAmount;
		this.image = image;
		this.uid = uid;
		this.dob = dob;
	}

	public Double getBlockedAmount() {
		return blockedAmount;
	}

	public void setBlockedAmount(Double blockedAmount) {
		this.blockedAmount = blockedAmount;
	}

	public UserDetails() {
		super();
	}



	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	private String uid;

	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}

	private Date dob;
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}


}
