package com.cg.ohms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ohms.dto.HotelDetailsDTO;
import com.cg.ohms.exceptions.HotelException;
import com.cg.ohms.service.IHotelDetails;
import com.cg.ohms.utility.HotelErrorMessages;

@RestController
public class HotelController {
	/**
	 * here object of hoteldetails service is autowired
	 */

	@Autowired
	private IHotelDetails hotel;

	boolean flag;

	/**
	 * 
	 * @param hotelDetailsDTO
	 * @return hoteldetails based upon the hotelid provided
	 */
	@PostMapping(value = "/view", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public HotelDetailsDTO getHotelDetails( @RequestBody HotelDetailsDTO hotelDetailsDTO) throws HotelException {
		hotelDetailsDTO = hotel.viewHotelDetails(hotelDetailsDTO);
		if (hotelDetailsDTO == null) {
			throw new HotelException(HotelErrorMessages.NO_HOTEL_DETAILS);
		}
		return hotelDetailsDTO;

	}

	/**
	 * 
	 * @param hotelDetailsDTO
	 * @return boolean value to notify either adding details is done correctly or
	 *         not
	 */

	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")

	public boolean addHotelDetails(@Valid @RequestBody HotelDetailsDTO hotelDetailsDTO) throws HotelException {

		flag = hotel.addHotelDetails(hotelDetailsDTO);
		if (flag == false) {
			throw new HotelException(HotelErrorMessages.ADDITION_ERROR);
		}
		return flag;

	}

	/**
	 * 
	 * @param hotelDetailsDTO
	 * @return boolean value after modification of the name to updated entry
	 * @throws HotelException
	 */

	@PutMapping(value = "/modify/name", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public boolean modifyName(@RequestBody HotelDetailsDTO hotelDetailsDTO) throws HotelException {

		flag = hotel.modifyByHotelName(hotelDetailsDTO);
		if (flag == false) {
			throw new HotelException(HotelErrorMessages.NAME_MESSAGE);
		}
		return flag;

	}

	/**
	 * 
	 * @param hotelDetailsDTO
	 * @return boolean value after modification of the address to updated entry
	 */
	@PutMapping(value = "/modify/address", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public boolean modifyAddress(@RequestBody HotelDetailsDTO hotelDetailsDTO) throws HotelException {

		flag = hotel.modifyByHotelAddress(hotelDetailsDTO);
		if (flag == false) {
			throw new HotelException(HotelErrorMessages.MODIFY_MESSAGE);
		}
		return flag;

	}

	/**
	 * 
	 * @param hotelDetailsDTO
	 * @return boolean value after modification of the rooms to updated entry
	 */

	@PutMapping(value = "/modify/rooms", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public boolean modifyRooms(@RequestBody HotelDetailsDTO hotelDetailsDTO) throws HotelException {

		flag = hotel.modifyByNumOfRooms(hotelDetailsDTO);
		if (flag == false) {
			throw new HotelException(HotelErrorMessages.MODIFY_MESSAGE);
		}

		return flag;

	}

	/**
	 * 
	 * @param hotelDetailsDTO
	 * @return boolean value after deletion of details by particular id provided
	 */

	@DeleteMapping(value = "/delete", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public boolean deleteHotel(@RequestBody HotelDetailsDTO hotelDetailsDTO) throws HotelException {

		flag = hotel.deleteHotelDetails(hotelDetailsDTO);
		if (flag == false) {
			throw new HotelException(HotelErrorMessages.DELETION_ERROR);
		}

		return flag;

	}

}
