package cn.ekgc.itrip.transport;

import cn.ekgc.itrip.pojo.entity.Comment;
import cn.ekgc.itrip.pojo.entity.Page;
import cn.ekgc.itrip.pojo.vo.ListCommentVO;
import cn.ekgc.itrip.pojo.vo.SearchCommentVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


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
	List<Comment> getScoreCommentByHotelId(@RequestParam Long hotelId)throws Exception;

	@PostMapping(value = "/page")
	Page<ListCommentVO> getPage(@RequestBody SearchCommentVO searchCommentVO)throws Exception;

	@PostMapping(value = "/add")
	boolean addComment(@RequestBody Comment comment) throws Exception;
}
