package com.PSM.B032110450.Ladies_Safety_Life_Server.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.PSM.B032110450.Ladies_Safety_Life_Server.Model.Period;

@Repository
public interface Period_repository extends JpaRepository<Period, Long> {
@Query(value = "SELECT * FROM period WHERE user_Id = :userID", nativeQuery = true)
	public List <Period> userPeriods(@Param("userID") Long userID ); 
}
