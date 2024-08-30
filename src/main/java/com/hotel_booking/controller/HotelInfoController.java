package com.hotel_booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel_booking.Entity.HotelInfo;
import com.hotel_booking.exception.CustomException;
import com.hotel_booking.service.HotelInfoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1")
public class HotelInfoController {
	
	@Autowired
	private HotelInfoService hotelInfoService;
	
	@GetMapping("/person")
	public ResponseEntity<List<HotelInfo>> getAllPerson(){
		return new ResponseEntity<List<HotelInfo>> ( 
				hotelInfoService.getAllPersonInfos(), 
				HttpStatus.OK);
	}
	
	@GetMapping("/person/{id}")
	public ResponseEntity<Object> getBookInfoById(@PathVariable("id") int id){
		
		HotelInfo hotelInfo = hotelInfoService.getAllPersonById(id);
		if(hotelInfo != null) {
			System.out.println("bookInfo : "+hotelInfo.getPersonName());
			return new ResponseEntity<Object> ( 
					hotelInfoService.getAllPersonById(id), 
					HttpStatus.OK);
		}else {
			System.out.println("bookInfo : Else");
			CustomException err = new CustomException("Book-Info with the ID: "+id+" is not available");
			return new ResponseEntity<Object> ( 
					err, 
					HttpStatus.OK);
		}
		
		
	}
	
	@PostMapping("/person")
	public ResponseEntity<HotelInfo> addPersonInfo(@RequestBody HotelInfo hotelInfo){
		
		return new ResponseEntity<HotelInfo>(
				hotelInfoService.addPerson(hotelInfo), 
				HttpStatus.CREATED);
	}
	
	@PutMapping("/person/{id}")
	public ResponseEntity<HotelInfo> modifyPerson(@RequestBody HotelInfo hotelInfo,
										@PathVariable("id") int id){
		
		return new ResponseEntity<HotelInfo>(
				hotelInfoService.modifyPerson(id, hotelInfo), 
				HttpStatus.OK);
	}
	
	@DeleteMapping("/person/{id}")
	public ResponseEntity<HotelInfo> cancelPerson(@PathVariable("id") int id){
		hotelInfoService.cancelPersonInfoById(id);
		return new ResponseEntity<HotelInfo> (  
				HttpStatus.NO_CONTENT);
	}


}
