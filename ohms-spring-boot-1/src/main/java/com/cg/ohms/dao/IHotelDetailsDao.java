package com.cg.ohms.dao;

import com.cg.ohms.dto.HotelDetailsDTO;
import com.cg.ohms.exceptions.HotelException;


public interface IHotelDetailsDao {

	public HotelDetailsDTO viewDetails(HotelDetailsDTO hotelDetailsDTO)throws HotelException ;

	public boolean addDetails(HotelDetailsDTO hotelDetailsDTO) throws HotelException ;

	public boolean modifyName(HotelDetailsDTO hotelDetailsDTO) throws HotelException;

	public boolean modifyAddress(HotelDetailsDTO hotelDetailsDTO)throws HotelException ;

	public boolean modifyRooms(HotelDetailsDTO hotelDetailsDTO) throws HotelException;

	public boolean deleteDetails(HotelDetailsDTO hotelId)throws HotelException ;

}
