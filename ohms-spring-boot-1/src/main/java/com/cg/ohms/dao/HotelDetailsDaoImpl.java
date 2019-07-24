package com.cg.ohms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
	 
	public List<Object[]> checkAcRooms() throws HotelException {
		
		TypedQuery<Object[]> query= entityManager.createQuery(
				"select h.hotelName,count(r.roomId) from HotelDetailsDTO h join RoomDetailsDTO r on h.hotelId=r.hotelDetailsDTO.hotelId where r.roomType='acroom' group by h.hotelName ",Object[].class);
				List<Object[]> results=query.getResultList();
				return results;
		
    } 


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
