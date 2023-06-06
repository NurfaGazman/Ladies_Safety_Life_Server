package com.PSM.B032110450.Ladies_Safety_Life_Server.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PSM.B032110450.Ladies_Safety_Life_Server.Model.Contact;
import com.PSM.B032110450.Ladies_Safety_Life_Server.Model.Contact_Id;

@Repository
public interface Contact_repository extends JpaRepository<Contact, Contact_Id> {
	List<Contact> findAllByuserId(int userId);
}
