package cn.ekgc.itrip.service.impl;

import cn.ekgc.itrip.dao.HotelOrderDao;
import cn.ekgc.itrip.pojo.entity.HotelOrder;
import cn.ekgc.itrip.pojo.entity.Page;
import cn.ekgc.itrip.pojo.vo.ItripPersonalOrderRoomVO;
import cn.ekgc.itrip.service.HotelOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

	/**
	 * <b> 根据订单ID查看个人订单详情-房型相关信息</b>
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
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

	/**
	 * <b>根据个人订单列表，并分页显示</b>
	 * @param hotelOrder
	 * @return
	 * @throws Exception
	 */
	public Page<HotelOrder> getPage(HotelOrder hotelOrder) throws Exception{
		// 封装对象
		Page<HotelOrder> page = new Page<HotelOrder>();

		// 设置分页
		PageHelper.startPage(hotelOrder.getPageNo(), hotelOrder.getPageSize());
		List<HotelOrder> hotelOrderList = hotelOrderDao.findHotelOrderListByQuery(hotelOrder);
		// 使用PageInfo对结果进行封装
		PageInfo pageInfo = new PageInfo(hotelOrderList);
		page.setCurPage(pageInfo.getPageNum());
		page.setPageSize(pageInfo.getPageSize());
		page.setPageCount(pageInfo.getPages());
		page.setBeginPos(pageInfo.getStartRow());
		page.setTotal((int)pageInfo.getTotal());
		page.setRows(hotelOrderList);

		return page;
	}
}
