package com.cg.ohms.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ohms.dto.HotelDetailsDTO;
import com.cg.ohms.exceptions.HotelException;

@Repository
@Transactional
public class HotelDetailsDaoImpl implements IHotelDetailsDao {
	boolean check = false;
	@PersistenceContext
	private EntityManager entityManager;

	public boolean addDetails(HotelDetailsDTO hotelDetailsDTO) throws HotelException{
		entityManager.persist(hotelDetailsDTO);
		return true;
	}

	public HotelDetailsDTO viewDetails(HotelDetailsDTO hotelDetailsDTO)throws HotelException {

		return entityManager.find(HotelDetailsDTO.class, hotelDetailsDTO.getHotelId());
	}

	public boolean modifyName(HotelDetailsDTO hotelDetailsDTO)throws HotelException {
		int hotelId = hotelDetailsDTO.getHotelId();
		String hotelName = hotelDetailsDTO.getHotelName();
		HotelDetailsDTO hotelDetails = entityManager.find(HotelDetailsDTO.class, hotelId);
		if (hotelDetails != null) {
			hotelDetails.setHotelName(hotelName);
			check = true;
		} else {
			check = false;
		}
		return check;
	}

	public boolean modifyAddress(HotelDetailsDTO hotelDetailsDTO)throws HotelException {
		int hotelId = hotelDetailsDTO.getHotelId();
		String hotelAddress = hotelDetailsDTO.getHotelAddress();
		HotelDetailsDTO hotelDetails = entityManager.find(HotelDetailsDTO.class, hotelId);
		if (hotelDetails != null) {

			hotelDetails.setHotelAddress(hotelAddress);
			check = true;
		} else {
			check = false;
		}
		return check;
	}

	public boolean modifyRooms(HotelDetailsDTO hotelDetailsDTO)throws HotelException {
		int hotelId = hotelDetailsDTO.getHotelId();
		int rooms = hotelDetailsDTO.getNumOfRooms();
		HotelDetailsDTO hotelDetails = entityManager.find(HotelDetailsDTO.class, hotelId);
		if (hotelDetails != null) {
			hotelDetails.setNumOfRooms(rooms);
			check = true;
		} else {
			check = false;
		}
		return check;
	}

	public boolean deleteDetails(HotelDetailsDTO hotelDetailsDTO) throws HotelException{

		HotelDetailsDTO hotelDetails = entityManager.find(HotelDetailsDTO.class, hotelDetailsDTO.getHotelId());
		if (hotelDetails != null) {
			entityManager.remove(hotelDetails);
			check = true;
		} else {
			check = false;
		}
		return check;

	}
}
