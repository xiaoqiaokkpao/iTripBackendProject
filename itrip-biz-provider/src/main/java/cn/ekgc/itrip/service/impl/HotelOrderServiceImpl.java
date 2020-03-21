package cn.ekgc.itrip.service.impl;

import cn.ekgc.itrip.dao.HotelOrderDao;
import cn.ekgc.itrip.pojo.entity.HotelOrder;
import cn.ekgc.itrip.service.HotelOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>爱旅行-酒店房间业务类接口实现类</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("hotelOrderService")
@Transactional
public class HotelOrderServiceImpl implements HotelOrderService {
	@Autowired
	private HotelOrderDao hotelOrderDao;

	public List<HotelOrder> getListByQuery(HotelOrder query) throws Exception{
		List<HotelOrder> hotelOrderList = hotelOrderDao.findHotelOrderListByQuery(query);
		if (hotelOrderList != null){
			return hotelOrderList;
		}
		return new ArrayList<HotelOrder>();
	}

	public boolean save(HotelOrder hotelOrder) throws Exception{
		int count = hotelOrderDao.save(hotelOrder);
		if (count > 0){
			return true;
		}
		return false;
	}

	public boolean update(HotelOrder hotelOrder) throws Exception{
		int count = hotelOrderDao.update(hotelOrder);
		if (count > 0){
			return true;
		}
		return false;
	}

	public HotelOrder getHotelOrderById(Long orderId) throws Exception{
		HotelOrder query = new HotelOrder();
		query.setId(orderId);

		List<HotelOrder> hotelOrderList = hotelOrderDao.findHotelOrderListByQuery(query);
		if (hotelOrderList != null && hotelOrderList.size() > 0){
			return hotelOrderList.get(0);
		}
		return new HotelOrder();
	}

	public HotelOrder getHotelOrderByNo(String orderNo) throws Exception{
		HotelOrder query = new HotelOrder();
		query.setOrderNo(orderNo);

		List<HotelOrder> hotelOrderList = hotelOrderDao.findHotelOrderListByQuery(query);
		if (hotelOrderList != null && hotelOrderList.size() > 0){
			return hotelOrderList.get(0);
		}
		return new HotelOrder();
	}
}
