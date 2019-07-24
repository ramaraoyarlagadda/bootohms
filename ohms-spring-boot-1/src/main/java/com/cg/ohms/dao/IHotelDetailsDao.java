package com.cg.ohms.dao;

import java.util.List;

import com.cg.ohms.dto.HotelDetailsDTO;
import com.cg.ohms.exceptions.HotelException;


public interface IHotelDetailsDao {
	/**
	 * 
	 * @param hotelDetailsDTO
	 * @return hotelDetails
	 * @throws HotelException
	 */

	public HotelDetailsDTO viewDetails(HotelDetailsDTO hotelDetailsDTO)throws HotelException ;
	/**
	 * 
	 * @param hotelDetailsDTO
	 * @return boolean value of either true or false
	 * @throws HotelException
	 */

	public boolean addDetails(HotelDetailsDTO hotelDetailsDTO) throws HotelException ;
	/**
	 * 
	 * @param hotelDetailsDTO
	 * @return boolean value of either true or false
	 * @throws HotelException
	 */

	public boolean modifyName(HotelDetailsDTO hotelDetailsDTO) throws HotelException;
	/**
	 * 
	 * @param hotelDetailsDTO
	 * @return boolean value of either true or false
	 * @throws HotelException
	 */

	public boolean modifyAddress(HotelDetailsDTO hotelDetailsDTO)throws HotelException ;
	/**
	 * 
	 * @param hotelDetailsDTO
	 * @return boolean value of either true or false
	 * @throws HotelException
	 */

	public boolean modifyRooms(HotelDetailsDTO hotelDetailsDTO) throws HotelException;
	/**
	 * 
	 * @param hotelId
	 * @return boolean value of either true or false
	 * @throws HotelException
	 */

	public boolean deleteDetails(HotelDetailsDTO hotelId)throws HotelException ;
	public List<Object[]> checkAcRooms() throws HotelException;

}
