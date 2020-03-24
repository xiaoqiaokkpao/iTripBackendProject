package cn.ekgc.itrip.transport;

import cn.ekgc.itrip.pojo.entity.UserLinkUser;
import cn.ekgc.itrip.pojo.vo.AddUserLinkUserVO;
import cn.ekgc.itrip.service.UserLinkUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * <b>爱旅行-常用联系人传输层接口实现类</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("userLinkUserTransport")
@RequestMapping("/linkuser/trans")
public class UserLinkUserTransportImpl implements UserLinkUserTransport {
	@Autowired
	private UserLinkUserService userLinkUserService;

	/**
	 * <b>通过查询条件查询常用联系人</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/list")
	public List<UserLinkUser> queryUserLinkUser(@RequestBody UserLinkUser query) throws Exception{
		return userLinkUserService.getUserLinkUserListByQuery(query);
	}

	/**
	 * <b>新增常用联系人</b>
	 * @param userLinkUser
	 * @return
	 */
	@PostMapping(value = "/add")
	public boolean addUserLinkUser(@RequestBody UserLinkUser userLinkUser) throws Exception{
		return userLinkUserService.addUserLinkUser(userLinkUser);
	}
}
