package com.cg.ohms.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="roomdetails")
public class RoomDetailsDTO {
    @Id
    @Column(name="roomid")
	private int roomId;
    @Column(name="price")
    private int price;
    @Column(name="numberofpersons")
    private int numberOfPersons;
    @Column(name="roomtype")
    private String roomType;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="hotelid", referencedColumnName = "hotelid")
    private HotelDetailsDTO hotelDetailsDTO;
    
    
    public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNumberOfPersons() {
		return numberOfPersons;
	}
	public void setNumberOfPersons(int numberOfPersons) {
		this.numberOfPersons = numberOfPersons;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	@Override
	public String toString() {
		return "RoomDetailsDTO [roomId=" + roomId + ", price=" + price + ", numberOfPersons=" + numberOfPersons
				+ ", roomType=" + roomType + "]";
	}
	
	
}