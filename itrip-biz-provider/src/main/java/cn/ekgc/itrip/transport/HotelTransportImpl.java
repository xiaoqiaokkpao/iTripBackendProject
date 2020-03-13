package cn.ekgc.itrip.transport;

import cn.ekgc.itrip.pojo.vo.HotelVO;
import cn.ekgc.itrip.pojo.vo.SearchHotCityVO;
import cn.ekgc.itrip.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>爱旅行-酒店信息传输层接口实现类</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("hotelTransport")
@RequestMapping("/hotel/trans")
public class HotelTransportImpl implements HotelTransport {
	@Autowired
	private HotelService hotelService;
	/**
	 * <b>根据热门城市查询酒店</b>
	 * @param queryVo
	 * @return
	 */
	@PostMapping(value = "/searchItripHotelListByHotCity")
	public List<HotelVO> searchItripHotelListByHotCity(@RequestBody SearchHotCityVO queryVo) throws Exception {
		return hotelService.searchItripHotelListByHotCity(queryVo);
	}
}
