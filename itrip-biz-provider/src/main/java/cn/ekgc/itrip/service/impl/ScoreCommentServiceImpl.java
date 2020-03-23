package cn.ekgc.itrip.service.impl;

import cn.ekgc.itrip.dao.ScoreCommentDao;
import cn.ekgc.itrip.pojo.entity.Comment;
import cn.ekgc.itrip.pojo.vo.ScoreCommentVO;
import cn.ekgc.itrip.service.ScoreCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.List;

/**
 * <b>爱旅行-区域字典信息业务层接口实现类</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("scoreCommentService")
@Transactional
public class ScoreCommentServiceImpl implements ScoreCommentService {
	@Autowired
	private ScoreCommentDao scoreCommentDao;

	/**
	 * <b>通过查询条件查询相关信息</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	public ScoreCommentVO getListByQuery(Long hotelId) throws Exception{
		Comment query = new Comment();
		query.setHotelId(hotelId);
		List<Comment> commentLists = scoreCommentDao.findListByQuery(query);
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

		return scoreCommentVO;
	}

}
