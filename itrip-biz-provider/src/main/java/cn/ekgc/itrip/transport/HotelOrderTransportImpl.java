package cn.ekgc.itrip.transport;

import cn.ekgc.itrip.pojo.entity.HotelOrder;
import cn.ekgc.itrip.pojo.entity.Page;
import cn.ekgc.itrip.pojo.vo.ItripPersonalOrderRoomVO;
import cn.ekgc.itrip.pojo.vo.SearchOrderVO;
import cn.ekgc.itrip.service.HotelOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>爱旅行-订单传输层接口实现类</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("hotelOrderTransport")
@RequestMapping("/hotelorder/trans")
public class HotelOrderTransportImpl implements HotelOrderTransport {
	@Autowired
	private HotelOrderService hotelOrderService;

	@PostMapping(value = "/list")
	public List<HotelOrder> getListByQuery(@RequestBody HotelOrder query) throws Exception{
		return hotelOrderService.getListByQuery(query);
	}

	@PostMapping(value = "/save")
	public boolean save(@RequestBody HotelOrder hotelOrder) throws Exception{
		return hotelOrderService.save(hotelOrder);
	}

	@PostMapping(value = "/update")
	public boolean update(@RequestBody HotelOrder hotelOrder) throws Exception{
		return hotelOrderService.update(hotelOrder);
	}

	@PostMapping(value = "/id")
	public HotelOrder getHotelOrderById(@RequestParam Long orderId) throws Exception{
		return hotelOrderService.getHotelOrderById(orderId);
	}

	/*@PostMapping(value = "/orderId")
	public ItripPersonalOrderRoomVO getItripHotelOrderRoomInfoById(Long orderId) throws Exception{
		return hotelOrderService.getItripHotelOrderRoomInfoById(orderId);
	}*/

	@PostMapping(value = "/no")
	public HotelOrder getHotelOrderByNo(@RequestParam String orderNo) throws Exception{
		return hotelOrderService.getHotelOrderByNo(orderNo);
	}

	@PostMapping(value = "/page")
	public Page<HotelOrder> getPage(@RequestBody HotelOrder hotelOrder) throws Exception{
		return hotelOrderService.getPage(hotelOrder);
	}
}
