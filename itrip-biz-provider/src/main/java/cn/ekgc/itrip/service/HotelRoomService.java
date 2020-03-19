package cn.ekgc.itrip.service;

import cn.ekgc.itrip.pojo.entity.HotelRoom;
import cn.ekgc.itrip.pojo.vo.SearchHotelRoomVO;
import cn.ekgc.itrip.pojo.vo.ValidateRoomStoreVO;

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

	/**
	 * <b>根据房间主键查询房间信息</b>
	 * @param roomId
	 * @return
	 * @throws Exception
	 */
	HotelRoom getHotelRoomById(Long roomId) throws Exception;

	/**
	 * <b>根据查询条件获得可用房间数量</b>
	 * @param validateRoomStoreVO
	 * @return
	 * @throws Exception
	 */
	int getHotelRoomStoreByDate(ValidateRoomStoreVO validateRoomStoreVO)throws Exception;
}
