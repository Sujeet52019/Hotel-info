package com.hotel_booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel_booking.Entity.HotelInfo;

@Repository
public interface HotelInfoRepository extends JpaRepository<HotelInfo, Integer> {

}
