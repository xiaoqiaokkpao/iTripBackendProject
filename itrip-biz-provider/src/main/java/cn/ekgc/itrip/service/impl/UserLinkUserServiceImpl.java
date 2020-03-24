package cn.ekgc.itrip.service.impl;

import cn.ekgc.itrip.dao.UserLinkUserDao;
import cn.ekgc.itrip.pojo.entity.UserLinkUser;
import cn.ekgc.itrip.pojo.vo.AddUserLinkUserVO;
import cn.ekgc.itrip.service.UserLinkUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>爱旅行-酒店房间业务类接口实现类</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("userLinkUserService")
@Transactional
public class UserLinkUserServiceImpl implements UserLinkUserService {
	@Autowired
	private UserLinkUserDao userLinkUserDao;

	/**
	 * <b>根据查询条件查询相关列表</b>
	 * @return
	 * @throws Exception
	 */
	public List<UserLinkUser> getUserLinkUserListByQuery(UserLinkUser query) throws Exception{
		List<UserLinkUser> userLinkUserList = userLinkUserDao.findUserLinkUserListByQuery(query);
		if (userLinkUserList != null){
			return userLinkUserList;
		}
		return new ArrayList<UserLinkUser>();
	}

	/**
	 * <b>新增常用联系人</b>
	 * @param userLinkUser
	 * @return
	 */
	public boolean addUserLinkUser(UserLinkUser userLinkUser) throws Exception{
		int count = userLinkUserDao.save(userLinkUser);
		if (count > 0){
			return true;
		}
		return false;
	}
}
