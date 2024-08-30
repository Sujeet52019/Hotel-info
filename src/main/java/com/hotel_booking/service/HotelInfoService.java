package com.hotel_booking.service;

import java.util.List;

import com.hotel_booking.Entity.HotelInfo;

public interface HotelInfoService {

	List<HotelInfo> getAllPersonInfos();

	HotelInfo getAllPersonById(int id);

	HotelInfo addPerson(HotelInfo hotelInfo);

	HotelInfo modifyPerson(int id, HotelInfo hotelInfo);

	void cancelPersonInfoById(int id);

}
