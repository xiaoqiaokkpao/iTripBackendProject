package cn.ekgc.itrip.transport;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <b>爱旅行-酒店房间评分模块传输层接口</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(name = "itrip-biz-provider")
@RequestMapping("/scorecomment/trans")
public interface ScoreCommentTransport {

}
