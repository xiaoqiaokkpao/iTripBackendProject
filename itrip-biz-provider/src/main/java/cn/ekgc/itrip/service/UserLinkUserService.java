package cn.ekgc.itrip.service;

import cn.ekgc.itrip.pojo.entity.UserLinkUser;
import cn.ekgc.itrip.pojo.vo.AddUserLinkUserVO;

import java.util.List;

/**
 * <b>爱旅行-常用联系人业务类接口</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
public interface UserLinkUserService {
	/**
	 * <b>根据查询条件查询相关列表</b>
	 * @return
	 * @throws Exception
	 */
	List<UserLinkUser> getUserLinkUserListByQuery(UserLinkUser query) throws Exception;

	/**
	 * <b>新增常用联系人</b>
	 * @param userLinkUser
	 * @return
	 */
	boolean addUserLinkUser(UserLinkUser userLinkUser) throws Exception;

	/**
	 * <b>修改常用联系人接口</b>
	 * @param userLinkUser
	 * @return
	 * @throws Exception
	 */
	boolean modifyUserLinkUser(UserLinkUser userLinkUser) throws Exception;

	/**
	 * <b>删除常用联系人接口</b>
	 * @param userLinkUser
	 * @return
	 * @throws Exception
	 */
	boolean delUserLinkUser(UserLinkUser userLinkUser) throws Exception;
}
