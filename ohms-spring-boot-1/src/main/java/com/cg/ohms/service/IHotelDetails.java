package com.cg.ohms.service;

import com.cg.ohms.dto.HotelDetailsDTO;
import com.cg.ohms.exceptions.HotelException;
import com.cg.ohms.exceptions.HotelExceptionController;

public interface IHotelDetails {
	/**
	 * 
	 * @param hotelDetailsDTO
	 * @return boolean value after performing addition operation
	 * @throws HotelExceptionController
	 */

	public boolean addHotelDetails(HotelDetailsDTO hotelDetailsDTO)throws HotelException;

	/**
	 * 
	 * @param hotelDetailsDTO
	 * @return boolean value after performing deletion operation
	 * @throws HotelException 
	 * @throws HotelExceptionController
	 */

	public boolean deleteHotelDetails(HotelDetailsDTO hotelDetailsDTO) throws HotelException;

	/**
	 * 
	 * @param hotelDetailsDTO
	 * @return hoteldetails for the particular id that we entered
	 * @throws HotelException
	 * @throws HotelExceptionController
	 */
	public HotelDetailsDTO viewHotelDetails(HotelDetailsDTO hotelDetailsDTO) throws HotelException;

	/**
	 * 
	 * @param hotelDetailsDTO
	 * @return boolean value after performing updation of name in hoteldetails
	 * @throws HotelExceptionController
	 */

	public boolean modifyByHotelName(HotelDetailsDTO hotelDetailsDTO)throws HotelException;

	/**
	 * 
	 * @param hotelDetailsDTO
	 * @return boolean value after performing updation of address in hoteldetails
	 * @throws HotelExceptionController
	 */

	public boolean modifyByHotelAddress(HotelDetailsDTO hotelDetailsDTO)throws HotelException;

	/**
	 * 
	 * @param hotelDetailsDTO
	 * @return boolean value after performing updation of rooms in hoteldetails
	 * @throws HotelExceptionController
	 */

	public boolean modifyByNumOfRooms(HotelDetailsDTO hotelDetailsDTO)throws HotelException;

}
