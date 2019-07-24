package com.cg.ohms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ohms.OhmsApplication;
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
	
	Logger logger=org.slf4j.LoggerFactory.getLogger(OhmsApplication.class);

	boolean flag;
	
	
	
	@RequestMapping(value="/acroomdetails",produces="application/json")
	public List<Object[]> acRoomDetails() throws HotelException{
		List<Object[]> details=hotel.acRooms();
		return details ;
		
	}

	/**
	 * 
	 * @param hotelDetailsDTO
	 * @return hoteldetails based upon the hotelid provided
	 */
	@PostMapping(value = "/view", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public HotelDetailsDTO getHotelDetails( @RequestBody HotelDetailsDTO hotelDetailsDTO) throws HotelException {
		logger.info("viewing operation started");
		hotelDetailsDTO = hotel.viewHotelDetails(hotelDetailsDTO);
		if (hotelDetailsDTO == null) {
			throw new HotelException(HotelErrorMessages.NO_HOTEL_DETAILS);
		}
		logger.info("viewing operation completed");
		return hotelDetailsDTO;

	}

	/**
	 * 
	 * @param hotelDetailsDTO
	 * @return boolean value to notify either adding details is done correctly or
	 *         not
	 */

	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")

	public boolean addHotelDetails( @RequestBody HotelDetailsDTO hotelDetailsDTO) throws HotelException {
		logger.info("adding operation started");

		flag = hotel.addHotelDetails(hotelDetailsDTO);
		if (flag == false) {
			throw new HotelException(HotelErrorMessages.ADDITION_ERROR);
		}
		logger.info("adding operation ended");
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
	public boolean modifyName( @RequestBody HotelDetailsDTO hotelDetailsDTO) throws HotelException {
		logger.info("Modification for name started");

		flag = hotel.modifyByHotelName(hotelDetailsDTO);
		if (flag == false) {
			throw new HotelException(HotelErrorMessages.NAME_MESSAGE);
		}
		logger.info("Modification for name ended");
		return flag;

	}

	/**
	 * 
	 * @param hotelDetailsDTO
	 * @return boolean value after modification of the address to updated entry
	 */
	@PutMapping(value = "/modify/address", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public boolean modifyAddress( @RequestBody HotelDetailsDTO hotelDetailsDTO) throws HotelException {
		logger.info("Modification for address started");

		flag = hotel.modifyByHotelAddress(hotelDetailsDTO);
		if (flag == false) {
			throw new HotelException(HotelErrorMessages.MODIFY_MESSAGE);
		}
		logger.info("Modification for address ended");
		return flag;

	}

	/**
	 * 
	 * @param hotelDetailsDTO
	 * @return boolean value after modification of the rooms to updated entry
	 */

	@PutMapping(value = "/modify/rooms", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public boolean modifyRooms( @RequestBody HotelDetailsDTO hotelDetailsDTO) throws HotelException {
		logger.info("Modification for rooms started");

		flag = hotel.modifyByNumOfRooms(hotelDetailsDTO);
		if (flag == false) {
			throw new HotelException(HotelErrorMessages.MODIFY_MESSAGE);
		}
		logger.info("Modification for rooms ended");

		return flag;

	}

	/**
	 * 
	 * @param hotelDetailsDTO
	 * @return boolean value after deletion of details by particular id provided
	 */

	@DeleteMapping(value = "/delete", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public boolean deleteHotel( @RequestBody HotelDetailsDTO hotelDetailsDTO) throws HotelException {
		logger.info("deletion operation started");

		flag = hotel.deleteHotelDetails(hotelDetailsDTO);
		if (flag == false) {
			throw new HotelException(HotelErrorMessages.DELETION_ERROR);
		}
		logger.info("deletion operation ended");

		return flag;

	}

}
