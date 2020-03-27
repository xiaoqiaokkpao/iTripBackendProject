package cn.ekgc.itrip.dao;

import cn.ekgc.itrip.pojo.entity.HotelOrder;
import cn.ekgc.itrip.pojo.vo.ItripPersonalOrderRoomVO;
import feign.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <b>爱旅行-酒店订单数据持久层接口</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public interface HotelOrderDao {
	/**
	 * <b>根据查询条件查询已支付和未支付的订单中所下单的房间总数</b>
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	Integer findOrderRoomCountByQuery(Map<String, Object> queryMap) throws Exception;

	/**
	 * <b>根据查询条件查询相关列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<HotelOrder> findHotelOrderListByQuery(HotelOrder query) throws Exception;

	ItripPersonalOrderRoomVO getItripHotelOrderRoomInfoById(@Param(value = "id") Long id) throws Exception;

	/**
	 * <b>保存订单信息</b>
	 * @param hotelOrder
	 * @return
	 * @throws Exception
	 */
	int save(HotelOrder hotelOrder) throws Exception;

	/**
	 * <b>修改订单信息</b>
	 * @param hotelOrder
	 * @return
	 * @throws Exception
	 */
	int update(HotelOrder hotelOrder) throws Exception;

}
