package com.PSM.B032110450.Ladies_Safety_Life_Server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PSM.B032110450.Ladies_Safety_Life_Server.Model.Contact;

@Repository
public interface Contact_repository extends JpaRepository<Contact, Long> {

}
