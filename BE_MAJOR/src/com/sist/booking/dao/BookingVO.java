package com.sist.booking.dao;

import com.sist.dto.workdiv.DTO;

public class BookingVO extends DTO {
	private String facilityCode;// 경기장코드
	private String facilityArea;// 지역
	private String facilityName;// 경기장명
	private String facilityAddress;// 경기장주소
	private String BookingDate;// 날짜
	private boolean bookingPossible;// 예약가능
	private String imagePath;// 이미지패스
	private String userId;// 아이디
	private String userName;// 이름
	private String userPhoneNumber;// 전화번호
	private String bookingCode;// 예약코드

	public BookingVO() {

	}

	public BookingVO(String facilityCode, String facilityArea, String facilityName, String facilityAddress,
			String bookingDate, boolean bookingPossible, String imagePath, String userId, String userName,
			String userPhoneNumber, String bookingCode) {
		super();
		this.facilityCode = facilityCode;
		this.facilityArea = facilityArea;
		this.facilityName = facilityName;
		this.facilityAddress = facilityAddress;
		BookingDate = bookingDate;
		this.bookingPossible = bookingPossible;
		this.imagePath = imagePath;
		this.userId = userId;
		this.userName = userName;
		this.userPhoneNumber = userPhoneNumber;
		this.bookingCode = bookingCode;
	}
	
	
	

	@Override
	public String toString() {
		return "BookingVO [facilityCode=" + facilityCode + ", facilityArea=" + facilityArea + ", facilityName="
				+ facilityName + ", facilityAddress=" + facilityAddress + ", BookingDate=" + BookingDate
				+ ", bookingPossible=" + bookingPossible + ", imagePath=" + imagePath + ", userId=" + userId
				+ ", userName=" + userName + ", userPhoneNumber=" + userPhoneNumber + ", bookingCode=" + bookingCode
				+ ", toString()=" + super.toString() + "]";
	}

	/**
	 * @return the facilityCode
	 */
	public String getFacilityCode() {
		return facilityCode;
	}

	/**
	 * @param facilityCode the facilityCode to set
	 */
	public void setFacilityCode(String facilityCode) {
		this.facilityCode = facilityCode;
	}

	/**
	 * @return the facilityArea
	 */
	public String getFacilityArea() {
		return facilityArea;
	}

	/**
	 * @param facilityArea the facilityArea to set
	 */
	public void setFacilityArea(String facilityArea) {
		this.facilityArea = facilityArea;
	}

	/**
	 * @return the facilityName
	 */
	public String getFacilityName() {
		return facilityName;
	}

	/**
	 * @param facilityName the facilityName to set
	 */
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	/**
	 * @return the facilityAddress
	 */
	public String getFacilityAddress() {
		return facilityAddress;
	}

	/**
	 * @param facilityAddress the facilityAddress to set
	 */
	public void setFacilityAddress(String facilityAddress) {
		this.facilityAddress = facilityAddress;
	}

	/**
	 * @return the bookingDate
	 */
	public String getBookingDate() {
		return BookingDate;
	}

	/**
	 * @param bookingDate the bookingDate to set
	 */
	public void setBookingDate(String bookingDate) {
		BookingDate = bookingDate;
	}

	/**
	 * @return the bookingPossible
	 */
	public boolean isBookingPossible() {
		return bookingPossible;
	}

	/**
	 * @param bookingPossible the bookingPossible to set
	 */
	public void setBookingPossible(boolean bookingPossible) {
		this.bookingPossible = bookingPossible;
	}

	/**
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * @param imagePath the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userPhoneNumber
	 */
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	/**
	 * @param userPhoneNumber the userPhoneNumber to set
	 */
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	/**
	 * @return the bookingCode
	 */
	public String getBookingCode() {
		return bookingCode;
	}

	/**
	 * @param bookingCode the bookingCode to set
	 */
	public void setBookingCode(String bookingCode) {
		this.bookingCode = bookingCode;
	}

}
