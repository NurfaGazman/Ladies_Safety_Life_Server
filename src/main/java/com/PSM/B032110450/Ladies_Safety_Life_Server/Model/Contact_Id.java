package com.PSM.B032110450.Ladies_Safety_Life_Server.Model;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.core.serializer.Serializer;

import jakarta.persistence.Embeddable;


public class Contact_Id implements Serializer{

	private int user_Id;
	private int contact_Id;
	
	@Override
	public void serialize(Object object, OutputStream outputStream) throws IOException {
		// TODO Auto-generated method stub
		
		
	}

	
}
