package cn.ekgc.itrip.dao;

import cn.ekgc.itrip.pojo.entity.Comment;
import cn.ekgc.itrip.pojo.vo.ListCommentVO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

	/**
	 * <b>获取酒店相关信息（酒店名称、酒店星级）</b>
	 * @param comment
	 * @return
	 * @throws Exception
	 */
	int save(Comment comment) throws Exception;

	/**
	 * <b>查询获得评论列表</b>
	 * @param querymap
	 * @return
	 * @throws Exception
	 */
	List<ListCommentVO> findCommentListByQuery(Map<String, Object> querymap)throws Exception;

}
