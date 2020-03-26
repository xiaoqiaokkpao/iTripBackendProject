package cn.ekgc.itrip.service.impl;

import cn.ekgc.itrip.dao.LabelDicDao;
import cn.ekgc.itrip.pojo.entity.LabelDic;
import cn.ekgc.itrip.service.LabelDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>爱旅行-系统字典信息业务层接口实现类</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("labelDicService")
@Transactional
public class LabelDicServiceImpl implements LabelDicService {
	@Autowired
	private LabelDicDao labelDicDao;

	/**
	 * <b>根据查询获得相应的信息</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public List<LabelDic> getListByQuery(LabelDic query) throws Exception {
		List<LabelDic> labelDicList = labelDicDao.findListByQuery(query);
		if (labelDicList != null){
			return labelDicList;
		}
		return new ArrayList<LabelDic>();
	}

	/**
	 * <b>查询出游类型列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public List<LabelDic> queryTravelType(LabelDic query) throws Exception{
		List<LabelDic> labelDicList = labelDicDao.queryTravelType(query);
		String name = labelDicList.get(0).getName();
		if (name != null){
			return labelDicList;
		}
		return new ArrayList<LabelDic>();
	}
}
