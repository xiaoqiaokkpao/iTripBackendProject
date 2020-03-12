package cn.ekgc.itrip.controller;

import cn.ekgc.itrip.base.controller.BaseController;
import cn.ekgc.itrip.base.pojo.vo.ResponseDto;
import cn.ekgc.itrip.pojo.entity.Hotel;
import cn.ekgc.itrip.pojo.vo.SearchHotCityVO;
import cn.ekgc.itrip.transport.HotelTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>爱旅行-搜索模块控制器</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("searchController")
@RequestMapping("/search/api")
public class SearchController extends BaseController {
	@Autowired
	private HotelTransport hotelTransport;

	/**
	 * <b>根据热门城市查询酒店</b>
	 * @param queryVo
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/hotellist/searchItripHotelListByHotCity")
	public ResponseDto<Object> searchItripHotelListByHotCity(@RequestBody SearchHotCityVO queryVo) throws Exception{
		List<Hotel> hotelList = hotelTransport.searchItripHotelListByHotCity(queryVo);
		return ResponseDto.success(hotelList);
	}
}
