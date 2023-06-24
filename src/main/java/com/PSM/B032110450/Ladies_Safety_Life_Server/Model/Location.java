package com.PSM.B032110450.Ladies_Safety_Life_Server.Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.type.TrueFalseConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table (name ="location")

public class Location {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name ="location_Id")
	private int location_Id;
	
	@Column (name = "user_Id")
	private int user_Id;
	
	@Column (name = "longitude")
	private BigDecimal longitude;
	
	@Column (name = "latitude")
	private BigDecimal latitude;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column (name = "dateTime")
	@CreationTimestamp
	private LocalDateTime dateTime;

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public int getLocation_Id() {
		return location_Id;
	}

	public void setLocation_Id(int location_Id) {
		this.location_Id = location_Id;
	}

	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}


	
}
