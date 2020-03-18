package cn.ekgc.itrip.base.enums;

/**
 * <b>爱旅行-图片枚举信息</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
public enum ImageTypeEnum {
	IMAGE_TYPE_HOTEL(0),
	IMAGE_TYPE_ROOM(1),
	IMAGE_TYPE_COMMENT(2)
	;
	private int code;

	private ImageTypeEnum(int code){
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
