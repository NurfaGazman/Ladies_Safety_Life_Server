package com.PSM.B032110450.Ladies_Safety_Life_Server.Model;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.core.serializer.Serializer;

import jakarta.persistence.Embeddable;


public class Contact_Id implements Serializer{

	private int userId;
	private String contact_no;
	
	@Override
	public void serialize(Object object, OutputStream outputStream) throws IOException {
		// TODO Auto-generated method stub
		
		
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

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
 

	
}
