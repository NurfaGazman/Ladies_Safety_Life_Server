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
	@Column (name = "userId")
	private int userId;
	
	@Id
	@Column (name = "contact_no")
	private String contact_no;
	
	@Column (name = "message")
	private String message;
	
	@Column (name = "name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setcontact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
