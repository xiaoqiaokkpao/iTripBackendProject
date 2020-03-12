package cn.ekgc.itrip.service.impl;

import cn.ekgc.itrip.dao.HotelDao;
import cn.ekgc.itrip.pojo.entity.Hotel;
import cn.ekgc.itrip.pojo.vo.SearchHotCityVO;
import cn.ekgc.itrip.service.HotelService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>爱旅行-酒店业务类接口实现类</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("hotelService")
@Transactional
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelDao hotelDao;

	/**
	 * <b>根据热门城市查询酒店</b>
	 * @param queryVo
	 * @return
	 * @throws Exception
	 */
	public List<Hotel> searchItripHotelListByHotCity(SearchHotCityVO queryVo) throws Exception{
		// 封装查询对象
		Hotel query = new Hotel();
		query.setCityId((long)queryVo.getCityId());

		// 为获得前六条，使用分页进行查询
		PageHelper.startPage(1, queryVo.getCount());
		List<Hotel> hotelList = hotelDao.findListByQuery(query);
		if (hotelList != null){
			return hotelList;
		}
		return new ArrayList<Hotel>();
	}
}
