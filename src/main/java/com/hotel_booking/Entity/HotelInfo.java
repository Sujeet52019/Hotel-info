package com.hotel_booking.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "hotel_booking")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class HotelInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "person-name")
	private String personName;
	@Column(name = "room-tpye")
	private String roomTpye;
	@Column(name = "check-in-time")
	private String checkinTime;
	@Column(name = "food-type")
	private String foodType;
	@Column(name = "basic-price")
	private int price;


}
