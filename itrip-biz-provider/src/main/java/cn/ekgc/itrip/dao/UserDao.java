package cn.ekgc.itrip.dao;

import cn.ekgc.itrip.pojo.entity.User;
import cn.ekgc.itrip.pojo.vo.UserVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>爱旅行-用户信息数据持久层接口</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public interface UserDao {

	/**
	 * <b>根据查询对象查询用户信息列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<User> findUserListByQuery(User query)throws Exception;

	/**
	 * <b>将注册信息提交到数据库</b>
	 * @param userVO
	 * @return
	 */
	List<UserVO> insertIntoUser(UserVO userVO) throws Exception;

	/**
	 * <b>保存用户信息</b>
	 * @param user
	 * @return
	 */
	int saveUser(User user) throws Exception;
}
