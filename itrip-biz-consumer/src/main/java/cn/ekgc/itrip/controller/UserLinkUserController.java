package cn.ekgc.itrip.controller;

import cn.ekgc.itrip.base.controller.BaseController;
import cn.ekgc.itrip.base.pojo.vo.ResponseDto;
import cn.ekgc.itrip.pojo.entity.User;
import cn.ekgc.itrip.pojo.entity.UserLinkUser;
import cn.ekgc.itrip.pojo.vo.AddUserLinkUserVO;
import cn.ekgc.itrip.transport.UserLinkUserTransport;
import cn.ekgc.itrip.transport.UserTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import java.util.Date;

/**
 * <b>爱旅行-常用联系人模块控制器</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("userLinkUserController")
@RequestMapping("/biz/api/userinfo")
public class UserLinkUserController extends BaseController {
	@Autowired
	private UserLinkUserTransport userLinkUserTransport;
	@Autowired
	private UserTransport userTransport;

	/**
	 * <b>根据当前登录用户，获得联系人</b>
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/queryuserlinkuser")
	public ResponseDto<Object> queryUserLinkUser()throws Exception{
		// 通过Cookie获得当前登录对象
		String userCode = "";
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if ("user".equals(cookie.getName())){
				userCode = cookie.getValue();
			}
		}

		// 封装查询对象
		UserLinkUser query = new UserLinkUser();
		query.setUserCode(userCode);

		return ResponseDto.success(userLinkUserTransport.queryUserLinkUser(query));
	}

	/**
	 * <b>新增常用联系人</b>
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/adduserlinkuser")
	public ResponseDto<Object> addUserLinkUser(@RequestBody AddUserLinkUserVO addUserLinkUserVO)throws Exception{
		// 获得当前登录用户
		String userCode = "";
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if ("user".equals(cookie.getName())){
				userCode = cookie.getValue();
			}
		}
		User userQuery = new User();
		userQuery.setUserCode(userCode);
		// 查询当前登录用户
		User user = userTransport.getListByQuery(userQuery).get(0);

		UserLinkUser query = new UserLinkUser();
		query.setUserId(user.getId().intValue());
		query.setCreatedBy(user.getId());
		query.setLinkUserName(addUserLinkUserVO.getLinkUserName());
		query.setLinkPhone(addUserLinkUserVO.getLinkPhone());
		query.setLinkIdCardType(addUserLinkUserVO.getLinkIdCardType());
		query.setLinkIdCard(addUserLinkUserVO.getLinkIdCard());
		query.setCreationDate(new Date(System.currentTimeMillis()));

		return ResponseDto.success(userLinkUserTransport.addUserLinkUser(query));
	}
}
