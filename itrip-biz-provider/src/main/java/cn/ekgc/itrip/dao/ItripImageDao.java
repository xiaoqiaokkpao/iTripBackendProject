package cn.ekgc.itrip.dao;

import cn.ekgc.itrip.pojo.entity.ItripImage;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>爱旅行-酒店房间图片数据持久层接口</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public interface ItripImageDao {
	/**
	 * <b>根据查询条件查询信息列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<ItripImage> findListByQuery(ItripImage query)throws Exception;
}
