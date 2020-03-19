package cn.ekgc.itrip.transport;

import cn.ekgc.itrip.pojo.entity.UserLinkUser;
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
}
