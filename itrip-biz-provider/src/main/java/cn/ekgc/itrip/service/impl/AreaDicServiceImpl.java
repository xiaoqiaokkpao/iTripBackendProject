package cn.ekgc.itrip.service.impl;

import cn.ekgc.itrip.dao.AreaDicDao;
import cn.ekgc.itrip.pojo.entity.AreaDic;
import cn.ekgc.itrip.service.AreaDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>爱旅行-区域字典信息业务层接口实现类</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("areaDicService")
@Transactional
public class AreaDicServiceImpl implements AreaDicService {
	@Autowired
	private AreaDicDao areaDicDao;
	/**
	 * <b>根据查询获得相应的信息</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public List<AreaDic> getListByQuery(AreaDic query) throws Exception {
		List<AreaDic> areaDicList = areaDicDao.findListByQuery(query);
		if (areaDicList != null){
			return areaDicList;
		}
		return new ArrayList<AreaDic>();
	}
}
