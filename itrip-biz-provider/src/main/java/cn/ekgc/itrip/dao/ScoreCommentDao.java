package cn.ekgc.itrip.dao;

import cn.ekgc.itrip.pojo.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>爱旅行-酒店房间评分数据持久层接口</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public interface ScoreCommentDao {
	/**
	 * <b>通过查询条件查询相关信息</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<Comment> findListByQuery(Comment query)throws Exception;

}
