package cn.ekgc.itrip.dao;

import org.springframework.stereotype.Repository;

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
}
