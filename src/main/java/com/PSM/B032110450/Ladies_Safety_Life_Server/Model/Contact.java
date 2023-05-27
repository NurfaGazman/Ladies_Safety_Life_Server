package com.PSM.B032110450.Ladies_Safety_Life_Server.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "contact")
@IdClass(Contact_Id.class)


public class Contact {

	@Id
	@Column (name = "user_Id")
	private int user_Id;
	
	@Id
	@Column (name = "contact_Id")
	private int contact_Id;
	
	@Column (name = "message")
	private String message;

	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public int getContact_Id() {
		return contact_Id;
	}

	public void setContact_Id(int contact_Id) {
		this.contact_Id = contact_Id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
