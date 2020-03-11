package cn.ekgc.itrip.service;

import cn.ekgc.itrip.pojo.entity.AreaDic;

import java.util.List;

/**
 * <b>爱旅行-区域字典信息业务层接口</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
public interface AreaDicService  {

	/**
	 * <b>根据查询获得请求列表</b>
	 * @param query
	 * @return
	 */
	List<AreaDic> getListByQuery(AreaDic query) throws Exception;
}
