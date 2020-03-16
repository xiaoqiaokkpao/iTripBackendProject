package cn.ekgc.itrip.dao;

import cn.ekgc.itrip.pojo.entity.HotelRoom;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <b>爱旅行-酒店房间数据持久层接口</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public interface HotelRoomDao {
	/**
	 * <b>根据查询信息查询列表信息</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public List<HotelRoom> findListByQuery(HotelRoom query) throws Exception;

	/**
	 * <b>根据查询条件获得此时临时库存数量</b>
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	public Integer queryTempStore(Map<String, Object> queryMap) throws Exception;

	/**
	 * <b>根据查询条件查询总库存</b>
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	public Integer queryTotalStore(Map<String, Object> queryMap) throws Exception;
}
