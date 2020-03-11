package cn.ekgc.itrip.transport;

import cn.ekgc.itrip.pojo.entity.LabelDic;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <b>爱旅行-系统字典信息传输层接口</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(name = "itrip-biz-provider")
@RequestMapping("/label/trans")
public interface LabelDicTransport {
	/**
	 * <b>根据查询获得请求列表</b>
	 * @param query
	 * @return
	 */
	@PostMapping(value = "/query")
	List<LabelDic> getListByQuery(@RequestBody LabelDic query) throws Exception;
}
