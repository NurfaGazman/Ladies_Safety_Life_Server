package com.PSM.B032110450.Ladies_Safety_Life_Server.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table( name ="period")
public class Period {

	
	
	@Column (name = "user_Id")
	private int user_Id;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "period_Id")
	private int period_Id;
	
	@Temporal(TemporalType.DATE)
	@Column (name = "start_date")
	private Date start_date;
	
	
	@Temporal(TemporalType.DATE)
	@Column (name = "end_date" , nullable = true)
	private Date end_date;


	public int getUser_Id() {
		return user_Id;
	}


	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}


	public int getPeriod_Id() {
		return period_Id;
	}


	public void setPeriod_Id(int period_Id) {
		this.period_Id = period_Id;
	}


	public Date getStart_date() {
		return start_date;
	}


	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}


	public Date getEnd_date() {
		return end_date;
	}


	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	
	
}
