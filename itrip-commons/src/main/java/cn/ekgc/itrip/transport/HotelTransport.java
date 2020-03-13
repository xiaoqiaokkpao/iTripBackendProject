package cn.ekgc.itrip.transport;

import cn.ekgc.itrip.pojo.vo.HotelVO;
import cn.ekgc.itrip.pojo.vo.SearchHotCityVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <b>爱旅行-酒店信息传输层接口</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(name = "itrip-biz-provider")
@RequestMapping("/hotel/trans")
public interface HotelTransport {
	/**
	 * <b>根据热门城市查询酒店</b>
	 * @param queryVo
	 * @return
	 */
	@PostMapping(value = "/searchItripHotelListByHotCity")
	List<HotelVO> searchItripHotelListByHotCity(@RequestBody SearchHotCityVO queryVo) throws Exception;
}
