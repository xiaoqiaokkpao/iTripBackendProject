package cn.ekgc.itrip.transport;

import cn.ekgc.itrip.pojo.entity.HotelOrder;
import cn.ekgc.itrip.pojo.entity.Page;
import cn.ekgc.itrip.pojo.vo.SearchOrderVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <b>爱旅行-订单模块传输层接口</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(name = "itrip-biz-provider")
@RequestMapping("/hotelorder/trans")
public interface HotelOrderTransport {
	@PostMapping(value = "/list")
	List<HotelOrder> getListByQuery(@RequestBody HotelOrder query) throws Exception;

	@PostMapping(value = "/save")
	boolean save(@RequestBody HotelOrder hotelOrder) throws Exception;

	@PostMapping(value = "/update")
	boolean update(@RequestBody HotelOrder hotelOrder) throws Exception;

	@PostMapping(value = "/id")
	HotelOrder getHotelOrderById(@RequestParam Long orderId) throws Exception;

	@PostMapping(value = "/no")
	HotelOrder getHotelOrderByNo(@RequestParam String orderNo) throws Exception;

	@PostMapping(value = "/page")
	Page<HotelOrder> getPage(@RequestBody HotelOrder hotelOrder) throws Exception;
}
