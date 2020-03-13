package cn.ekgc.itrip.service;

import cn.ekgc.itrip.pojo.vo.HotelVO;
import cn.ekgc.itrip.pojo.vo.SearchHotCityVO;

import java.util.List;

/**
 * <b>爱旅行-酒店业务类接口</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
public interface HotelService {
	/**
	 * <b>根据热门城市查询酒店</b>
	 * @param queryVo
	 * @return
	 */
	List<HotelVO> searchItripHotelListByHotCity(SearchHotCityVO queryVo) throws Exception;
}
