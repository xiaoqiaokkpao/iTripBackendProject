package cn.ekgc.itrip.transport;

import cn.ekgc.itrip.pojo.entity.Comment;
import cn.ekgc.itrip.pojo.vo.ScoreCommentVO;
import cn.ekgc.itrip.service.ScoreCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <b>爱旅行-酒店房间评分传输层接口实现类</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("scoreCommentTransport")
@RequestMapping("/scorecomment/trans")
public class ScoreCommentTransportImpl implements ScoreCommentTransport{
	@Autowired
	private ScoreCommentService scoreCommentService;

	/**
	 * <b>根据查询条件查询酒店评分</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/hotelId")
	public ScoreCommentVO getScoreCommentByHotelId(@RequestParam Long hotelId)throws Exception{
		return scoreCommentService.getListByQuery(hotelId);
	}

}
