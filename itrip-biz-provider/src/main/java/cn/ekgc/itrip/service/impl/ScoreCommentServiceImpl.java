package cn.ekgc.itrip.service.impl;

import cn.ekgc.itrip.dao.ScoreCommentDao;
import cn.ekgc.itrip.pojo.entity.Comment;
import cn.ekgc.itrip.pojo.entity.Page;
import cn.ekgc.itrip.pojo.vo.ListCommentVO;
import cn.ekgc.itrip.pojo.vo.SearchCommentVO;
import cn.ekgc.itrip.service.ScoreCommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<Comment> getListByQuery(Long hotelId) throws Exception{
		Comment query = new Comment();
		query.setHotelId(hotelId);
		List<Comment> commentLists = scoreCommentDao.findListByQuery(query);

		if (commentLists != null && commentLists.size() > 0){
			return commentLists;
		}
		return new ArrayList<Comment>();
	}


	/**
	 * <b>根据评论类型查询评论列表，并分页显示</b>
	 * @param searchCommentVO
	 * @return
	 * @throws Exception
	 */
	public Page<ListCommentVO> getPage(SearchCommentVO searchCommentVO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("hotelId", searchCommentVO.getHotelId());
		map.put("isHavingImg", searchCommentVO.getIsHavingImg());
		map.put("isOk", searchCommentVO.getIsOk());

		// 设置分页信息
		PageHelper.startPage(searchCommentVO.getPageNo(), searchCommentVO.getPageSize());
		List<ListCommentVO> commentList = scoreCommentDao.findCommentListByQuery(map);


		// 使用PageInfo对结果进行封装
		PageInfo<ListCommentVO> pageInfo = new PageInfo<ListCommentVO>(commentList);
		Page<ListCommentVO> page = new Page<ListCommentVO>();

		page.setCurPage(pageInfo.getPageNum());
		page.setPageSize(pageInfo.getPageSize());
		page.setTotal((int)pageInfo.getTotal());
		page.setRows(commentList);
		page.setPageCount(pageInfo.getPages());
		page.setBeginPos(pageInfo.getStartRow());
		return page;
	}

	/**
	 * <b>新增评论接口</b>
	 * @param comment
	 * @return
	 * @throws Exception
	 */
	public boolean addComment(Comment comment) throws Exception {
		int count = scoreCommentDao.save(comment);
		if (count > 0) {
			return true;
		}
		return false;
	}
}
