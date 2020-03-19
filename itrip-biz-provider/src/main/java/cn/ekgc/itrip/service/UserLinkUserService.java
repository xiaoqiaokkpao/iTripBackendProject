package cn.ekgc.itrip.service;

import cn.ekgc.itrip.pojo.entity.UserLinkUser;

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
}
