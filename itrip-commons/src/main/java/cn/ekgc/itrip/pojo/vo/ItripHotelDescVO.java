package cn.ekgc.itrip.pojo.vo;

import java.io.Serializable;

public class ItripHotelDescVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long hotelId;           //酒店id
	private String hotelName;       //酒店名称
	private Integer hotelLevel;     //酒店级别(1:经济酒店  2:二星级酒店  3:三星级酒店 4:四星级酒店 5:五星级酒店)

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public Integer getHotelLevel() {
		return hotelLevel;
	}

	public void setHotelLevel(Integer hotelLevel) {
		this.hotelLevel = hotelLevel;
	}
}
