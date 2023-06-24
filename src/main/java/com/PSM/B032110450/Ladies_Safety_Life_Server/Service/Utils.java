package com.PSM.B032110450.Ladies_Safety_Life_Server.Service;

import java.util.Random;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.beans.factory.annotation.Value;

//import jakarta.validation.metadata.ValidateUnwrappedValue;

public class Utils {

	
	
//declared 1 function public return type string nama function generateRandomString
	
	public static String generateRandomString(Integer lenght) {
		
	//String  value (simpan data character utk allow dalam password a to z
		
	String value = "abcdefghijklmnopqrstuvwxyz";
	
	
	int number = 0;
	
	//pegang value utk random nanti
	String randomString = ""; 
	
	Random random = new Random();
	
	//loop	
		for (int i=0; i <lenght; i++) {
			
			number = random.nextInt(value.length()-1);
			randomString += value.charAt(number);
			
		}
		return randomString; 
		
		
	}
}



