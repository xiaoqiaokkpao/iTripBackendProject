package cn.ekgc.itrip.controller;

import cn.ekgc.itrip.base.controller.BaseController;
import cn.ekgc.itrip.base.enums.UserActivatedEnum;
import cn.ekgc.itrip.base.enums.UserTypeEnum;
import cn.ekgc.itrip.base.pojo.vo.ResponseDto;
import cn.ekgc.itrip.pojo.entity.User;
import cn.ekgc.itrip.pojo.vo.UserVO;
import cn.ekgc.itrip.transport.UserTransport;
import cn.ekgc.itrip.util.MD5Util;
import cn.ekgc.itrip.util.RegValidationUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>爱旅行-认证模块控制器</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */

@RestController("authController")
@RequestMapping("auth/api")
public class AuthController extends BaseController {
	@Autowired
	private UserTransport userTransport;

	/**
	 * <b>用户注册验证-电子邮箱</b>
	 * @param name
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/ckusr")
	public ResponseDto<Object> checkUserEmailForRegistry(String name) throws Exception{
		// 校验用户所提交的电子邮件是否有效（是否为空，以及是否符合邮箱的格式）
		if (RegValidationUtil.validateEmail(name)){
			// 校验通过之后找到对应的生产者，到数据库进行判断
			// 封装查询对象
			User query = new User();
			query.setUserCode(name);
			// 进行查询
			List<User> userList = userTransport.getListByQuery(query);
			// 运行结果判断
			if (userList == null || userList.size() == 0){
				// 此时用户所填写的邮箱地址可用
				return ResponseDto.success();
			}
		}
		return ResponseDto.falure("这个邮箱已被注册！");
	}

	/**
	 * <b>使用电子邮件注册用户信息</b>
	 * @param userVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/doregister")
	public ResponseDto<Object> registryUser(@RequestBody UserVO userVO) throws Exception{
		// 校验用户所给定的信息是否准确
		if (RegValidationUtil.validateEmail(userVO.getUserCode())
				&& userVO.getUserPassword() != null && !"".equals(userVO.getUserPassword().trim())) {
				// 对于密码进行MD5加密
			userVO.setUserPassword(MD5Util.encrypt(userVO.getUserPassword()));
			// 将用户userVo转换为user对象
			User user = new User();
			BeanUtils.copyProperties(userVO, user);
			// 当调用该方法的时候用户属于自主注册
			user.setUserType(UserTypeEnum.USER_TYPE_REG.getCode());
			// 将激活状态设置为未激活
			user.setActivated(UserActivatedEnum.USER_ACTIVATED_NO.getCode());
			// 使用传输层远程调用生产者进行用户信息的注册
			boolean flag = userTransport.saveUser(user);
			if (flag){
				// 注册成功
				return ResponseDto.success();
			}
		}
		return ResponseDto.falure("注册失败！");
	}

	/**
	 * <b>使用手机号码进行注册</b>
	 * @param userVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/registerbyphone")
	public ResponseDto<Object> registryByCellphone(@RequestBody UserVO userVO) throws Exception{
		// 校验用户所给定的信息是否准确
		if (RegValidationUtil.validateCellphone(userVO.getUserCode())
				&& userVO.getUserPassword() != null && !"".equals(userVO.getUserPassword().trim())) {
			// 进行唯一性校验
			User query = new User();
			query.setUserCode(userVO.getUserCode());
			List<User> userList = userTransport.getListByQuery(query);
			if (userList == null || userList.size() == 0) {
				// 说明该手机号码没有注册
				// 对于密码进行MD5加密
				userVO.setUserPassword(MD5Util.encrypt(userVO.getUserPassword()));
				// 将用户userVo转换为user对象
				User user = new User();
				BeanUtils.copyProperties(userVO, user);
				// 当调用该方法的时候用户属于自主注册
				user.setUserType(UserTypeEnum.USER_TYPE_REG.getCode());
				// 将激活状态设置为未激活
				user.setActivated(UserActivatedEnum.USER_ACTIVATED_NO.getCode());
				// 使用传输层远程调用生产者进行用户信息的注册
				boolean flag = userTransport.saveUser(user);
				if (flag) {
					// 注册成功
					return ResponseDto.success();
				}
			}
			return ResponseDto.falure("该手机号码已经注册！");
		}
		return ResponseDto.falure("注册失败！");
	}

	/**
	 * <b>激活注册用户</b>
	 * @param user
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PutMapping(value = "/activate")
	public ResponseDto<Object> activeUser(String user, String code) throws Exception{
		// 校验用户所给的user和code有效性
		if (user != null && !"".equals(user.trim()) && code != null && !"".equals(code.trim())){
			// 通过user在Redis中查询相应的值
			String activeCode = userTransport.getActiveCodeByUserCode(user);
			// 比较两个code是否相同
			if (code.equals(activeCode)){
				// 修改用户的激活状态
				User updateUser = new User();
				updateUser.setUserCode(user);
				updateUser.setActivated(UserActivatedEnum.USER_ACTIVATED_YES.getCode());
				// 在数据库中更新用户数据
				userTransport.updateUser(updateUser);
				return ResponseDto.success();
			}
			return ResponseDto.falure("激活码不正确！");
		}
		return ResponseDto.falure("激活失败！");
	}
}
