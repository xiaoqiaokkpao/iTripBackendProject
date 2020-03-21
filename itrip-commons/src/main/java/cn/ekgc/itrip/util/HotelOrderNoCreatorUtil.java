package cn.ekgc.itrip.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * <b>生成订单编号工具类</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
public class HotelOrderNoCreatorUtil {
	public static String createHotelOrderNo(Long hotelId, Long roomId) throws Exception{
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		// 增加hotelId
		sb.append(hotelId);
		// 增加roomId
		sb.append(roomId);
		// 获得当前时间进行格式化
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmSSSS");
		sb.append(simpleDateFormat.format(new Date()));
		// 新增随机数
		sb.append(random.nextInt(10));
		// 对于该结果进行MD5加密
		String result = MD5Util.encrypt(sb.toString());
		return result.toUpperCase();
	}

	public static void main(String[] args) throws Exception{
		System.out.println(createHotelOrderNo(1L, 1L));
	}
}
