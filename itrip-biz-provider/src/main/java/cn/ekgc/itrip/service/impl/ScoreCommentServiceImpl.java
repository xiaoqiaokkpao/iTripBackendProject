package cn.ekgc.itrip.service.impl;

import cn.ekgc.itrip.dao.*;
import cn.ekgc.itrip.pojo.entity.*;
import cn.ekgc.itrip.pojo.vo.ListCommentVO;
import cn.ekgc.itrip.pojo.vo.SearchCommentVO;
import cn.ekgc.itrip.service.ScoreCommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
	@Autowired
	private LabelDicDao labelDicDao;
	@Autowired
	private HotelOrderDao hotelOrderDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private HotelRoomDao hotelRoomDao;
	@Autowired
	private HotelDao hotelDao;

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
	public Page<Comment> getPage(SearchCommentVO searchCommentVO) throws Exception{
		/*Map<String, Object> map = new HashMap<String, Object>();
		map.put("hotelId", searchCommentVO.getHotelId());
		map.put("isHavingImg", searchCommentVO.getIsHavingImg());
		map.put("isOk", searchCommentVO.getIsOk());*/

		Comment query = new Comment();
		query.setHotelId(searchCommentVO.getHotelId());
		query.setIsHavingImg(searchCommentVO.getIsHavingImg());
		query.setIsOk(searchCommentVO.getIsOk());
		// 设置分页信息
		PageHelper.startPage(searchCommentVO.getPageNo(), searchCommentVO.getPageSize());
		List<Comment> commentList = scoreCommentDao.findListByQuery(query);

		// ListCommentVO listCommentVO = new ListCommentVO();
		for (Comment comment : commentList) {
			/*listCommentVO.setId(comment.getId());
			listCommentVO.setIsHavingImg(comment.getIsHavingImg());
			listCommentVO.setScore(comment.getScore());
			listCommentVO.setContent(comment.getContent());
			listCommentVO.setCreationDate(comment.getCreationDate());*/
			// 出游类型
			LabelDic labelDicQuery = new LabelDic();
			labelDicQuery.setId(comment.getTripMode());
			List<LabelDic> labelDicList = labelDicDao.queryTravelType(labelDicQuery);
			if (labelDicList != null && labelDicList.size() > 0){
				comment.setTripModeName(labelDicList.get(0).getName());
			}
			// 入住时间
			HotelOrder hotelOrderQuery = new HotelOrder();
			hotelOrderQuery.setId(comment.getOrderId());
			List<HotelOrder> hotelOrderList = hotelOrderDao.findHotelOrderListByQuery(hotelOrderQuery);
			if (hotelOrderList != null && hotelOrderList.size() > 0){
				comment.setCheckInDate(hotelOrderList.get(0).getCheckInDate());
				// 房间名称
				HotelRoom hotelRoomQuery = new HotelRoom();
				hotelRoomQuery.setId(hotelOrderList.get(0).getRoomId());
				List<HotelRoom> hotelRoomList =  hotelRoomDao.findListByQuery(hotelRoomQuery);
				if (hotelRoomList != null && hotelOrderList.size() > 0){
					comment.setRoomTitle(hotelRoomList.get(0).getRoomTitle());
				}
			}
			// 评论用户
			User userQuery = new User();
			userQuery.setId(comment.getUserId());
			List<User> userList = userDao.findUserListByQuery(userQuery);
			if (userList != null && userList.size() > 0){
				comment.setUserCode(userList.get(0).getUserCode());
			}
			// 酒店的星级
			Hotel hotelQuery = new Hotel();
			hotelQuery.setId(comment.getHotelId());
			List<Hotel> hotelList = hotelDao.findListByQuery(hotelQuery);
			if (hotelList != null && hotelList.size() > 0){
				comment.setHotelLevel(hotelList.get(0).getHotelLevel());
			}
		}

		// List<ListCommentVO> list = new ArrayList<ListCommentVO>();
		// list.add(listCommentVO);
		// System.out.println(list.size());
		// 使用PageInfo对结果进行封装
		PageInfo<Comment> pageInfo = new PageInfo<Comment>(commentList);
		Page<Comment> page = new Page<Comment>();

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
