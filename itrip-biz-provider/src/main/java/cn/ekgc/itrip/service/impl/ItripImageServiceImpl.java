package cn.ekgc.itrip.service.impl;

import cn.ekgc.itrip.dao.ItripImageDao;
import cn.ekgc.itrip.pojo.entity.ItripImage;
import cn.ekgc.itrip.service.ItripImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
/**
 * <b>爱旅行-图片业务类接口实现类</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("itripImageService")
@Transactional
public class ItripImageServiceImpl implements ItripImageService {
	@Autowired
	private ItripImageDao itripImageDao;

	/**
	 * <b></b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public List<ItripImage> getImageListByQuery(ItripImage query) throws Exception {
		List<ItripImage> itripImageList = itripImageDao.findListByQuery(query);
		if (itripImageList != null ){
			return itripImageList;
		}
		return new ArrayList<ItripImage>();
	}
}
