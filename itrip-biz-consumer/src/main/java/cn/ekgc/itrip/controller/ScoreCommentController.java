package cn.ekgc.itrip.controller;

import cn.ekgc.itrip.base.controller.BaseController;
import cn.ekgc.itrip.base.enums.ImageTypeEnum;
import cn.ekgc.itrip.base.pojo.vo.ResponseDto;
import cn.ekgc.itrip.pojo.entity.*;
import cn.ekgc.itrip.pojo.vo.*;
import cn.ekgc.itrip.transport.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <b>爱旅行-酒店房间评分控制器</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("scoreCommentController")
@RequestMapping("/biz/api/comment")
public class ScoreCommentController extends BaseController {
	@Autowired
	private ScoreCommentTransport scoreCommentTransport;
	@Autowired
	private ItripImageTransport itripImageTransport;
	@Autowired
	private LabelDicTransport labelDicTransport;
	@Autowired
	private UserTransport userTransport;
	@Autowired
	private HotelTransport hotelTransport;

	/**
	 * <b>根据酒店id查询各个评论分数的平均值</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/gethotelscore/{hotelId}")
	public ResponseDto<Object> getHotelScore(@PathVariable("hotelId") Long hotelId) throws Exception {
		List<Comment>commentLists = scoreCommentTransport.getScoreCommentByHotelId(hotelId);
		Integer facilitiesScore = 0;
		Integer positionScore = 0;
		Integer serviceScore = 0;
		Integer hygieneScore = 0;
		Integer score = 0;

		for (Comment commentList : commentLists) {
			facilitiesScore = facilitiesScore + commentList.getFacilitiesScore();
			positionScore = positionScore + commentList.getPositionScore();
			serviceScore = serviceScore + commentList.getServiceScore();
			hygieneScore = hygieneScore + commentList.getHygieneScore();
			score = score + commentList.getScore();
		}

		// 保留一位小数
		// DecimalFormat decimalFormat = new DecimalFormat("##0.0");
		ScoreCommentVO scoreCommentVO = new ScoreCommentVO();
		// scoreCommentVO.setAvgFacilitiesScore(Float.parseFloat(decimalFormat.format(facilitiesScore / commentLists.size())));
		scoreCommentVO.setAvgFacilitiesScore(facilitiesScore /commentLists.size());
		scoreCommentVO.setAvgPositionScore(positionScore / commentLists.size());
		scoreCommentVO.setAvgServiceScore(serviceScore / commentLists.size());
		scoreCommentVO.setAvgHygieneScore(hygieneScore / commentLists.size());
		scoreCommentVO.setAvgScore(score / commentLists.size());

		return ResponseDto.success(scoreCommentVO);
	}

	/**
	 * <b>根据酒店id查询各类评论数量</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/getcount/{hotelId}")
	public ResponseDto<Object> getCount(@PathVariable("hotelId") Long hotelId) throws Exception{
		List<Comment> commentLists = scoreCommentTransport.getScoreCommentByHotelId(hotelId);
		Map<String, Integer> map = new HashMap<String, Integer>();
		// 所有评论的数量
		Integer allcomment = 0;
		// 值得推荐
		Integer isok = 0;
		// 有待提高
		Integer improve = 0;
		// 有图片
		Integer havingimg = 0;
		for (Comment commentList : commentLists) {
			if (commentList.getIsOk() == 1){
				isok = isok + 1;
			} else {
				improve = improve + 1;
			}

			if (commentList.getIsHavingImg() == 1){
				havingimg = havingimg + 1;
			}
		}
		map.put("allcomment", commentLists.size());
		map.put("isok", isok);
		map.put("improve", improve);
		map.put("havingimg", havingimg);
		return ResponseDto.success(map);
	}

	/**
	 * <b>根据评论类型查询评论列表，并分页显示</b>
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/getcommentlist")
	public ResponseDto<Object> getCommentList(@RequestBody SearchCommentVO searchCommentVO) throws Exception{
		if (searchCommentVO.getIsOk() == -1){
			searchCommentVO.setIsOk(null);
		}
		if (searchCommentVO.getIsHavingImg() == -1){
			searchCommentVO.setIsHavingImg(null);
		}

		// 进行查询
		Page<Comment> page = scoreCommentTransport.getPage(searchCommentVO);
		// 跳转到其他地址并进行状态的修改
		/*String path = "";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);*/
		return ResponseDto.success(page);
	}

	/**
	 * <b>根据targetId查询评论照片(type=2)</b>
	 * @param targetId
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/getimg/{targetId}")
	public ResponseDto<Object> getimg(@PathVariable("targetId") Long targetId)throws Exception{
		ItripImage query = new ItripImage();
		query.setTargetId(targetId);
		query.setType(String.valueOf(ImageTypeEnum.IMAGE_TYPE_COMMENT.getCode()));

		return ResponseDto.success(itripImageTransport.getImageListByQuery(query));
	}

	/**
	 * <b> 查询出游类型列表</b>
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/gettraveltype")
	public ResponseDto<Object> getTravelType() throws Exception{
		LabelDic query = new LabelDic();
		query.setParentId(107L);
		return ResponseDto.success(labelDicTransport.getListByQuery(query));
	}

	/**
	 * <b> 获取酒店相关信息（酒店名称、酒店星级）</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/gethoteldesc/{hotelId}")
	public ResponseDto<Object> getHotelDesc(@PathVariable("hotelId") Long hotelId) throws Exception{
		Hotel hotel = hotelTransport.getHotelById(hotelId);
		ItripHotelDescVO itripHotelDescVO = new ItripHotelDescVO();
		itripHotelDescVO.setHotelId(hotel.getId());
		itripHotelDescVO.setHotelName(hotel.getHotelName());
		itripHotelDescVO.setHotelLevel(hotel.getHotelLevel());

		return ResponseDto.success(itripHotelDescVO);
	}

	@PostMapping(value = "/add")
	public ResponseDto<Object> addComment(@RequestBody AddCommentVO addCommentVO) throws Exception{
		// 获取当前用户
		String userCode = "";
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if ("user".equals(cookie.getName())){
				userCode = cookie.getValue();
			}
		}
		User userQuery = new User();
		userQuery.setUserCode(userCode);
		// 查询当前登录用户
		User user = userTransport.getListByQuery(userQuery).get(0);
		// 封装对象
		Comment comment = new Comment();
		comment.setUserId(user.getId());
		comment.setHotelId(addCommentVO.getHotelId());
		comment.setOrderId(addCommentVO.getOrderId());
		comment.setProductId(addCommentVO.getProductId());
		// 商品类型(0:旅游产品 1:酒店产品 2:机票产品)
		comment.setProductType(addCommentVO.getProductType());
		comment.setIsHavingImg(addCommentVO.getIsHavingImg());
		comment.setPositionScore(addCommentVO.getPositionScore());
		comment.setServiceScore(addCommentVO.getServiceScore());
		comment.setFacilitiesScore(addCommentVO.getFacilitiesScore());
		comment.setHygieneScore(addCommentVO.getHygieneScore());
		comment.setTripMode(Long.valueOf(addCommentVO.getTripMode()));
		comment.setIsOk(addCommentVO.getIsOk());
		comment.setContent(addCommentVO.getContent());
		comment.setCreationDate(new Date(System.currentTimeMillis()));
		comment.setCreatedBy(user.getId());
		comment.setScore((addCommentVO.getFacilitiesScore() + addCommentVO.getServiceScore() + addCommentVO.getPositionScore() + addCommentVO.getHygieneScore()) / 4);

		scoreCommentTransport.addComment(comment);
		return ResponseDto.success("评论成功！！！");
	}

}
