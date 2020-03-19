package cn.ekgc.itrip.service.impl;

import cn.ekgc.itrip.dao.ScoreCommentDao;
import cn.ekgc.itrip.pojo.entity.Comment;
import cn.ekgc.itrip.pojo.vo.ScoreCommentVO;
import cn.ekgc.itrip.service.ScoreCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;

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
		ScoreCommentVO scoreCommentVO = scoreCommentDao.findListByQuery(query);
		// 将查询到的数据保留一位小数
		DecimalFormat decimalFormat = new DecimalFormat("##0.0");
		scoreCommentVO.setAvgFacilitiesScore(Float.parseFloat(decimalFormat.format(scoreCommentVO.getAvgFacilitiesScore())));
		scoreCommentVO.setAvgPositionScore(Float.parseFloat(decimalFormat.format(scoreCommentVO.getAvgPositionScore())));
		scoreCommentVO.setAvgServiceScore(Float.parseFloat(decimalFormat.format(scoreCommentVO.getAvgServiceScore())));
		scoreCommentVO.setAvgHygieneScore(Float.parseFloat(decimalFormat.format(scoreCommentVO.getAvgHygieneScore())));
		scoreCommentVO.setAvgScore(Float.parseFloat(decimalFormat.format(scoreCommentVO.getAvgScore())));

		return scoreCommentVO;
	}

}
