package com.PSM.B032110450.Ladies_Safety_Life_Server.Model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "user")

public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "user_Id")
	private int User_Id;
	
	@Column (name = "email")
	private String email;
	
	@Column (name = "full_name")
	private String full_name;
	
	//write only will prevent user password from being returned in request
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column (name = "password")
	private String password;
	
	@Column (name = "blood_gp"  , nullable = true)
	private String blood_gp;
	
	@Temporal(TemporalType.DATE)
	@Column (name = "birth_date" , nullable = true)
	private Date birth_date;
	
	@Column (name ="address" , nullable = true)
	private String address;
	
	@Column (name = "medical_Id" , nullable = true)
	private String medical_Id;

	public int getUser_Id() {
		return User_Id;
	}

	public void setUser_Id(int user_Id) {
		User_Id = user_Id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBlood_gp() {
		return blood_gp;
	}

	public void setBlood_gp(String blood_gp) {
		this.blood_gp = blood_gp;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMedical_Id() {
		return medical_Id;
	}

	public void setMedical_Id(String medical_Id) {
		this.medical_Id = medical_Id;
	}
	
	
}

