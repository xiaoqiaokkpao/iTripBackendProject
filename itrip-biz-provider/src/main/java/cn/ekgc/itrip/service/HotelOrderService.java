package cn.ekgc.itrip.service;

import cn.ekgc.itrip.pojo.entity.HotelOrder;

import java.util.List;

/**
 * <b>爱旅行-订单业务类接口</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
public interface HotelOrderService {

	List<HotelOrder> getListByQuery(HotelOrder query) throws Exception;

	boolean save(HotelOrder hotelOrder) throws Exception;

	boolean update(HotelOrder hotelOrder) throws Exception;

	HotelOrder getHotelOrderById(Long orderId) throws Exception;

	HotelOrder getHotelOrderByNo(String orderNo) throws Exception;
}
