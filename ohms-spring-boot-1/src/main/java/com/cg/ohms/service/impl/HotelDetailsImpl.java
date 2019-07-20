package com.cg.ohms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ohms.dao.IHotelDetailsDao;
import com.cg.ohms.dto.HotelDetailsDTO;
import com.cg.ohms.exceptions.HotelException;
import com.cg.ohms.service.IHotelDetails;

@Service
public class HotelDetailsImpl implements IHotelDetails {
	/**
	 * here object of hoteldetailsdao service is autowired
	 */
	boolean result;

	@Autowired
	private IHotelDetailsDao hotelDetailsDao;

	public void setHotelDetailsDao(IHotelDetailsDao hotelDetailsDao) {
		this.hotelDetailsDao = hotelDetailsDao;
	}

	public boolean addHotelDetails(HotelDetailsDTO hotelDetailsDTO) throws HotelException {
		result = hotelDetailsDao.addDetails(hotelDetailsDTO);

		return result;

	}

	public HotelDetailsDTO viewHotelDetails(HotelDetailsDTO hotelDetailsDTO) throws HotelException {

		return hotelDetailsDao.viewDetails(hotelDetailsDTO);

	}

	public boolean modifyByHotelName(HotelDetailsDTO hotelDetailsDTO) throws HotelException {

		result = hotelDetailsDao.modifyName(hotelDetailsDTO);
		return result;
	}

	public boolean modifyByHotelAddress(HotelDetailsDTO hotelDetailsDTO) throws HotelException {
		result = hotelDetailsDao.modifyAddress(hotelDetailsDTO);
		return result;
	}

	public boolean modifyByNumOfRooms(HotelDetailsDTO hotelDetailsDTO) throws HotelException {
		result = hotelDetailsDao.modifyRooms(hotelDetailsDTO);
		return result;
	}

	public boolean deleteHotelDetails(HotelDetailsDTO hotelDetailsDTO) throws HotelException {

		result = hotelDetailsDao.deleteDetails(hotelDetailsDTO);
		return result;
	}
}
