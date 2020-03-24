package cn.ekgc.itrip.controller;

import cn.ekgc.itrip.base.controller.BaseController;
import cn.ekgc.itrip.pojo.entity.HotelOrder;
import cn.ekgc.itrip.transport.HotelOrderTransport;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.alipay.api.AlipayConstants.APP_ID;

@RestController("tradeController")
@RequestMapping(value = "/trade/api")
public class TradeController extends BaseController {
	@Autowired
	private HotelOrderTransport hotelOrderTransport;

	@GetMapping(value = "/prepay/{tradeNo}")
	public void testTrade(@PathVariable("tradeNo") String tradeNo) throws Exception{
		HotelOrder hotelOrder = hotelOrderTransport.getHotelOrderByNo(tradeNo);
		AlipayClient alipayClient =  new DefaultAlipayClient(
				"https://openapi.alipaydev.com/gateway.do" ,
				"2016101800719619",
				"MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCkIou4XI0Wab/p4YeuOQBMK8WncBkNX4scBfFLMc8FGplELJE9txax7seggLm2gJwZp6NTwmvdo36TSyby24ZIy2f2vf8+KeBY8Ar78iI7SZ+Vxz7Wtm9fuREPpf3ByvJxC9v2gBEIy4sidR/WLwNEnORuA2DHuKU8gNwIRAHu5hNal5tR3cAaWTBocXZDMUbJ5mK+waQWVxep6FlhkRYkJEeMolUSowQ4ZIf6R07hDraT8UpkUd8nTRtZD7D/uokoxumbQJhrMh7PyEIWsnpW11KtFEDGmAX6595LUjKDJ7j8F2fDS2CubNNYuGO3IM0YxIST0v/POpC3EIaNMrQdAgMBAAECggEAE0MGmJUr7YRthDn2XUjNMyMz5+ls1zfuMFS2M3fd7qBneiusw8xXunvmK3zPzo4bQ5t7vFmlpPYJ5ak9IeUHRkWwprE3YgkyDd3lvBl3UPPb6YzfX/065sXmLaryM6rodsHIh44R8bFJW7rZCJ6tyICNAigdVHLj2UzaBZJNk8Z12J9SprVCQhgCP1f/0eHNqConTTV7Zg5O/wg3Cqgeg72nzbEXAT+6gFXPVjwk/XXC+0l8r9gi99JWmor3YLoC4uVarKhiCq4o+17w+DV7fjfnPzPn3snWb+NxP5UDJc1Bc4pxqqERGxTzzPNBmdxkhsVmjmEnrOSTP9HDqY4M1QKBgQDp8WYSN13/Bs1u3zpA/38G7AQSUFST8hnUVZgBq2Z7Qn+aHoes6auHdmV37zOyKOuJwKpNgY0iii/bIkWEKMxsIOzdhFPr7xygaoTHR3S64lQ1AmAzUZnjp78B4QjPLDFEywVkJvLxbjPfm9tcM4RvsovtqRQZ7fahxqKPRUXrEwKBgQCznDb8PNHN8jfU3PzJSiqPJ3wlHVlwBQbwZ0eWBs/t3gJsz6J48x6SsOCM9n1z/aVoPROphwoCrnIl/Sc+l07rxV9N1A08tZhIybjmc0qKG7FeEi7w122Zqb1YAQdbuTVjfTK6HRHpPORYB9ql0RmbGv913yN8Q1ELDWvAyB4aDwKBgF7gkyfiIpHyXVCQ4dxIgmj5QTF4OMUDk+wkhpBuxhJJRtznctjyr6kxoDdC4LFpnRTx+V+TofyXFI+H16+gqD9WHxo7t5lhETgR2yXC2hmM/t+8xe0qNAI7HuERNfRnlNe0iswya6b0rb8LQ6yiDB0MyWkqgEd/1d2IZJc8Xf3XAoGAZtDp+QKn54jcxRGr815tdn1X57chV6rJCh1VMWC87qHEKZ3CmBI0UizGnmsL7bYpVb6A3u7aoCZUWcLNEFt1ZioaIGdfHH2nqyMuoV0mMmEf64XlMSFhMDGmnhYYrD0dftJQk5HIiwe8f1gfpgRI8C1IR6VwntW6MuV/5V+pO6kCgYEAipMrB2WiDPKcSQcy8j7hh6gDeZwqBNUHUmt4gBErmKhBHTnzxudHGdimni8TPc3M+gThaHOT/QUv95uyP3/3t3zNq1czLCDiLL3fYzYZuHEZDMh5hoLdTwVK4su9jR5RFGdUn5zQdrlRDYvjeNfzEccDzSdHlNZhnAibtj/RDGc=",
				"json",
				"UTF-8",
				"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApCKLuFyNFmm/6eGHrjkATCvFp3AZDV+LHAXxSzHPBRqZRCyRPbcWse7HoIC5toCcGaejU8Jr3aN+k0sm8tuGSMtn9r3/PingWPAK+/IiO0mflcc+1rZvX7kRD6X9wcrycQvb9oARCMuLInUf1i8DRJzkbgNgx7ilPIDcCEQB7uYTWpebUd3AGlkwaHF2QzFGyeZivsGkFlcXqehZYZEWJCRHjKJVEqMEOGSH+kdO4Q62k/FKZFHfJ00bWQ+w/7qJKMbpm0CYazIez8hCFrJ6VtdSrRRAxpgF+ufeS1Iygye4/Bdnw0tgrmzTWLhjtyDNGMSEk9L/zzqQtxCGjTK0HQIDAQAB",
				"RSA2");  //获得初始化的AlipayClient
		AlipayTradePagePayRequest alipayRequest =  new  AlipayTradePagePayRequest(); //创建API对应的request
		alipayRequest.setReturnUrl( "http://localhost/itrip" );
		alipayRequest.setNotifyUrl( "http://domain.com/CallBack/notify_url.jsp" ); //在公共参数中设置回跳和通知地址
		alipayRequest.setBizContent( "{"  +
				"    \"out_trade_no\":\" " + tradeNo + "\","  +
				"    \"product_code\":\"FAST_INSTANT_TRADE_PAY\","  +
				"    \"total_amount\":" + hotelOrder.getPayAmount() + ","  +
				"    \"subject\":\"" + hotelOrder.getHotelName() + "\","  +
				"    \"body\":\"Iphone6 16G\","  +
				"    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\","  +
				"    \"extend_params\":{"  +
				"    \"sys_service_provider_id\":\"2088511833207846\""  +
				"    }" +
				"  }" ); //填充业务参数
		String form= "" ;
		try  {
			form = alipayClient.pageExecute(alipayRequest).getBody();  //调用SDK生成表单
		}  catch  (AlipayApiException e) {
			e.printStackTrace();
		}
		response.setContentType( "text/html;charset= UTF-8");
		response.getWriter().write(form); //直接将完整的表单html输出到页面
		response.getWriter().flush();
		response.getWriter().close();
	}
}
