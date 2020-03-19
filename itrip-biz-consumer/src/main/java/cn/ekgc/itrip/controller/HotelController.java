package cn.ekgc.itrip.controller;

import cn.ekgc.itrip.base.controller.BaseController;
import cn.ekgc.itrip.base.enums.AreaHotEnum;
import cn.ekgc.itrip.base.enums.ImageTypeEnum;
import cn.ekgc.itrip.base.pojo.vo.ResponseDto;
import cn.ekgc.itrip.pojo.entity.AreaDic;
import cn.ekgc.itrip.pojo.entity.Hotel;
import cn.ekgc.itrip.pojo.entity.ItripImage;
import cn.ekgc.itrip.pojo.entity.LabelDic;
import cn.ekgc.itrip.pojo.vo.SearchDetailsHotelVO;
import cn.ekgc.itrip.transport.AreaDicTransport;
import cn.ekgc.itrip.transport.HotelTransport;
import cn.ekgc.itrip.transport.ItripImageTransport;
import cn.ekgc.itrip.transport.LabelDicTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>爱旅行-主业务酒店模块控制器</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("hotelController")
@RequestMapping("/biz/api/hotel")
public class HotelController extends BaseController {
	@Autowired
	private AreaDicTransport areaDicTransport;
	@Autowired
	private LabelDicTransport labelDicTransport;
	@Autowired
	private HotelTransport hotelTransport;
	@Autowired
	private ItripImageTransport itripImageTransport;

	/**
	 * <b>查询热门城市</b>
	 * @param isChina
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/queryhotcity/{isChina}")
	public ResponseDto<Object> queryHotCityList(@PathVariable("isChina") Integer isChina) throws Exception{
		// 创查询对象
		AreaDic query = new AreaDic();
		// 设置查询条件：是否属于国内城市
		query.setIsChina(isChina);
		// 设置查询条件：热门城市
		query.setIsHot(AreaHotEnum.AREA_HOT_YES.getCode());

		// 查询列表
		List<AreaDic> areaDicList = areaDicTransport.getListByQuery(query);

		return ResponseDto.success(areaDicList);
	}

	@GetMapping(value = "/queryhotelfeature")
	public ResponseDto<Object> queryHotelFeature() throws Exception{
		// 创建查询对象
		LabelDic query = new LabelDic();
		query.setParentId(16L);

		List<LabelDic> labelDicList = labelDicTransport.getListByQuery(query);

		return ResponseDto.success(labelDicList);
	}

	/**
	 * <b>根据酒店id，查询酒店特色，商圈，酒店名称（视屏文字信息）</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/getvideodesc/{hotelId}")
	public ResponseDto<Object> getVideoDesc(@PathVariable("hotelId") Long hotelId)throws Exception{
		Hotel hotel = hotelTransport.getHotelById(hotelId);
		return ResponseDto.success(hotel);
	}

	/**
	 * <b> 根据酒店id查询酒店特色和介绍</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/queryhoteldetails/{hotelId}")
	public ResponseDto<Object> queryHotelDetails(@PathVariable("hotelId") Long hotelId)throws Exception{
		List<SearchDetailsHotelVO> resultList = new ArrayList<SearchDetailsHotelVO>();
		// 根据酒店主键查询酒店
		Hotel hotel = hotelTransport.getHotelById(hotelId);
		// 增加数据
		resultList.add(new SearchDetailsHotelVO("酒店介绍", hotel.getDetails()));
		// 查询该酒店所对应的特色列表
		LabelDic labelDicQuery = new LabelDic();
		labelDicQuery.setHotelId(hotelId);
		List<LabelDic> labelDicList = labelDicTransport.getListByQuery(labelDicQuery);
		if (labelDicList != null && labelDicList.size() > 0){
			for (LabelDic labelDic : labelDicList){
				resultList.add(new SearchDetailsHotelVO(labelDic.getName(), labelDic.getDescription()));
			}
		}
		return ResponseDto.success(resultList);
	}

	/**
	 * <b>根据酒店id查询酒店特色和介绍</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/queryhotelfacilities/{hotelId}")
	public ResponseDto<Object> queryHotelFacilities(@PathVariable("hotelId") Long hotelId)throws Exception{
		Hotel hotel = hotelTransport.getHotelById(hotelId);
		return ResponseDto.success(hotel.getFacilities());
	}

	/**
	 * <b>根据酒店id查询酒店政策</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/queryhotelpolicy/{hotelId}")
	public ResponseDto<Object> queryHotelPolicy(@PathVariable("hotelId") Long hotelId)throws Exception{
		Hotel hotel = hotelTransport.getHotelById(hotelId);
		return ResponseDto.success(hotel.getHotelPolicy());
	}

	/**
	 * <b>根据targetId查询酒店图片(type=0)</b>
	 * @param targetId
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/getimg/{targetId}")
	public ResponseDto<Object> getImgForHotel(@PathVariable("targetId") Long targetId) throws Exception{
		ItripImage query = new ItripImage();
		query.setTargetId(targetId);
		query.setType(String.valueOf(ImageTypeEnum.IMAGE_TYPE_HOTEL.getCode()));

		return ResponseDto.success(itripImageTransport.getImageListByQuery(query));
	}

}
