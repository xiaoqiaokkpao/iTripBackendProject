package cn.ekgc.itrip.controller;

import cn.ekgc.itrip.base.controller.BaseController;
import cn.ekgc.itrip.base.pojo.vo.ResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>爱旅行-酒店房间评分控制器</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("scoreCommentController")
@RequestMapping("/biz/api/comment")
public class ScoreCommentController extends BaseController {

	/**
	 * <b></b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/gethotelscore/{hotelId}")
	public ResponseDto<Object> getHotelScore(@PathVariable("hotelId") Long hotelId) throws Exception {

		return ResponseDto.success();
	}
}
