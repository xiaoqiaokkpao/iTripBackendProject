package cn.ekgc.itrip.transport;

import cn.ekgc.itrip.pojo.entity.UserLinkUser;
import cn.ekgc.itrip.pojo.vo.AddUserLinkUserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <b>爱旅行-常用联系人模块传输层接口</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(name = "itrip-biz-provider")
@RequestMapping("/linkuser/trans")
public interface UserLinkUserTransport {
	/**
	 * <b>通过查询条件查询常用联系人</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/list")
	List<UserLinkUser> queryUserLinkUser(@RequestBody UserLinkUser query) throws Exception;

	/**
	 * <b>新增常用联系人</b>
	 * @param userLinkUser
	 * @return
	 */
	@PostMapping(value = "/add")
	boolean addUserLinkUser(@RequestBody UserLinkUser userLinkUser) throws Exception;

	/**
	 * <b>修改常用联系人接口</b>
	 * @param userLinkUser
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/update")
	boolean modifyUserLinkUser(@RequestBody UserLinkUser userLinkUser) throws Exception;

	/**
	 * <b>删除常用联系人接口</b>
	 * @param userLinkUser
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/del")
	boolean delUserLinkUser(@RequestBody UserLinkUser userLinkUser) throws Exception;
}
