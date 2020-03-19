package cn.ekgc.itrip.transport;

import cn.ekgc.itrip.pojo.vo.ScoreCommentVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * <b>爱旅行-酒店房间评分模块传输层接口</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(name = "itrip-biz-provider")
@RequestMapping("/scorecomment/trans")
public interface ScoreCommentTransport {
	/**
	 * <b>根据查询条件查询酒店评分</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/hotelId")
	ScoreCommentVO getScoreCommentByHotelId(@RequestParam Long hotelId)throws Exception;
}
