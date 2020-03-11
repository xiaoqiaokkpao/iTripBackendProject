package cn.ekgc.itrip.transport;

import cn.ekgc.itrip.pojo.entity.AreaDic;
import cn.ekgc.itrip.service.AreaDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>爱旅行-区域字典信息传输层接口实现类</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("areaDicTransport")
@RequestMapping("/area/trans")
public class AreaDicTransportImpl implements AreaDicTransport {
	@Autowired
	private AreaDicService areaDicService;

	/**
	 * <b>根据查询获得请求列表</b>
	 * @param query
	 * @return
	 */
	@PostMapping(value = "/query")
	public List<AreaDic> getListByQuery(@RequestBody AreaDic query) throws Exception {
		return areaDicService.getListByQuery(query);
	}
}
