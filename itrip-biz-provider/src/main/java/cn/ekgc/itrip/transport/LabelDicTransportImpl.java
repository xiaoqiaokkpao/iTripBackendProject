package cn.ekgc.itrip.transport;

import cn.ekgc.itrip.pojo.entity.LabelDic;
import cn.ekgc.itrip.service.LabelDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>爱旅行-系统字典信息传输层接口实现类</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("labelDicTransport")
@RequestMapping("/label/trans")
public class LabelDicTransportImpl implements LabelDicTransport {
	@Autowired
	private LabelDicService labelDicService;
	/**
	 * <b>根据查询获得请求列表</b>
	 * @param query
	 * @return
	 */
	@PostMapping(value = "/query")
	public List<LabelDic> getListByQuery(@RequestBody LabelDic query) throws Exception{
		return labelDicService.getListByQuery(query);
	}
}
