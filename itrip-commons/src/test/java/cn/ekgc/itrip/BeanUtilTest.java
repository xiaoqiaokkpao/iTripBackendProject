package cn.ekgc.itrip;

import cn.ekgc.itrip.pojo.entity.User;
import cn.ekgc.itrip.pojo.vo.UserVO;
import org.springframework.beans.BeanUtils;

public class BeanUtilTest {
	public static void main(String[] args) {
		UserVO userVO = new UserVO();
		userVO.setUserCode("xiaohua@163.com");
		userVO.setUserName("小华");
		userVO.setUserPassword("123456");

		User user = new User();
		// 在Spring中提供了bean属性之间的切换工具
		BeanUtils.copyProperties(userVO, user);
		System.out.println(user.getUserCode() + "\t" + user.getUserName() + "\t" + user.getUserPassword());

	}
}
