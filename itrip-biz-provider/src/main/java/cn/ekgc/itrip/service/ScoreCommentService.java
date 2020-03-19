package cn.ekgc.itrip.service;

import cn.ekgc.itrip.pojo.entity.Comment;
import cn.ekgc.itrip.pojo.vo.ScoreCommentVO;


/**
 * <b>爱旅行-酒店房间评分业务类接口</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ScoreCommentService {
	/**
	 * <b>通过查询条件查询相关信息</b>
	 * @param hotelId
	 * @return
	 * @throws Exception
	 */
	ScoreCommentVO getListByQuery(Long hotelId) throws Exception;
}
