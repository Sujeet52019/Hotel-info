package com.hotel_booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel_booking.Entity.HotelInfo;
import com.hotel_booking.repository.HotelInfoRepository;

@Service
public class HotelInfoServiceImp implements HotelInfoService {
	
	@Autowired
	private HotelInfoRepository hotelInfoRepository;

	@Override
	public List<HotelInfo> getAllPersonInfos() {
		return hotelInfoRepository.findAll();
	}

	@Override
	public HotelInfo getAllPersonById(int id) {
		return hotelInfoRepository.findById(id).orElse(null);
	}

	@Override
	public HotelInfo addPerson(HotelInfo hotelInfo) {
		return hotelInfoRepository.save(hotelInfo);		 
	}

	@Override
	public HotelInfo modifyPerson(int id, HotelInfo hotelInfo) {
		HotelInfo hotelInfoOld = hotelInfoRepository.findById(id).get();
		hotelInfoOld.setPersonName(hotelInfo.getPersonName());
		hotelInfoOld.setRoomTpye(hotelInfo.getRoomTpye());
		hotelInfoOld.setCheckinTime(hotelInfo.getCheckinTime());
		hotelInfoOld.setFoodType(hotelInfo.getFoodType());
		hotelInfoOld.setPrice(hotelInfo.getPrice());
				
		return hotelInfoRepository.save(hotelInfoOld);
	}

	@Override
	public void cancelPersonInfoById(int id) {
		hotelInfoRepository.deleteById(id);
		
	}

}
