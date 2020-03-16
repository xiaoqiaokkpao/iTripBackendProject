package cn.ekgc.itrip.service;

import cn.ekgc.itrip.pojo.entity.HotelRoom;
import cn.ekgc.itrip.pojo.vo.SearchHotelRoomVO;

import java.util.List;

/**
 * <b>爱旅行-酒店房间业务类接口</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
public interface HotelRoomService {
	/**
	 * <b>查询酒店房间列表-此时可以预定的房间列表</b>
	 * @param searchHotelRoomVO
	 * @return
	 * @throws Exception
	 */
	List<HotelRoom> queryHotelRoomByHotel(SearchHotelRoomVO searchHotelRoomVO) throws Exception;
}
