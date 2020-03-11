package cn.ekgc.itrip.transport;

import cn.ekgc.itrip.pojo.entity.User;
import cn.ekgc.itrip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>爱旅行-用户信息传输层接口实现类</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("userTransport")
@RequestMapping("/user/trans")
public class UserTransportImpl implements UserTransport {
	@Autowired
	private UserService userService;

	/**
	 * <b>根据查询信息查询用户信息列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/list")
	public List<User> getListByQuery(@RequestBody User query) throws Exception {
		return userService.getListByQuery(query);
	}


	/**
	 * <b>保存用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/save")
	public boolean saveUser(@RequestBody User user) throws Exception {
		return userService.saveUser(user);
	}

	/**
	 * <b>通过userCode在Redis中查询对应的激活码</b>
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/activeCode")
	public String getActiveCodeByUserCode(@RequestBody String userCode) throws Exception {
		return userService.getActiveCodeByUserCode(userCode);
	}

	/**
	 * <b>修改用户信息</b>
	 * @param user
	 * @return
	 */
	@PostMapping(value = "/updateUser")
	public boolean updateUser(@RequestBody User user) throws Exception {
		return userService.updateUser(user);
	}
}
