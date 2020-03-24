package cn.ekgc.itrip.dao;

import cn.ekgc.itrip.pojo.entity.UserLinkUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>爱旅行-用户联系人数据持久层接口</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public interface UserLinkUserDao {
	/**
	 * <b>根据查询条件查询相关信息</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<UserLinkUser> findUserLinkUserListByQuery(UserLinkUser query) throws Exception;

	/**
	 * <b>新增常用联系人</b>
	 * @param userLinkUser
	 * @return
	 */
	int save(UserLinkUser userLinkUser) throws Exception;
}
