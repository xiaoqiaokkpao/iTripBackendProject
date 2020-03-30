package cn.ekgc.itrip.pojo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>爱旅行-用户信息实体对象</b>
 * @author xiaoqiao
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel("用户实体信息")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "用户主键")
	private Long id;
	@ApiModelProperty(value = "用户账号")
	private String userCode;
	@ApiModelProperty(value = "用户密码")
	private String userPassword;
	@ApiModelProperty(value = "用户类型")
	private Integer userType;
	@ApiModelProperty(value = "平台ID")
	private Long flatID;
	@ApiModelProperty(value = "用户姓名")
	private String userName;
	@ApiModelProperty(value = "微信")
	private String weChat;
	@ApiModelProperty(value = "QQ")
	private String QQ;
	@ApiModelProperty(value = "weibo")
	private String weibo;
	@ApiModelProperty(value = "baidu", required = false)
	private String baidu;
	@ApiModelProperty(value = "是否激活")
	private int activated;
	@ApiModelProperty(value = "创建时间")
	private Date creationDate;
	@ApiModelProperty(value = "创建者")
	private Long createdBy;
	@ApiModelProperty(value = "修改时间")
	private Date modifyDate;
	@ApiModelProperty(value = "修改者")
	private Long modifiedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Long getFlatID() {
		return flatID;
	}

	public void setFlatID(Long flatID) {
		this.flatID = flatID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getWeChat() {
		return weChat;
	}

	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String QQ) {
		this.QQ = QQ;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

	public String getBaidu() {
		return baidu;
	}

	public void setBaidu(String baidu) {
		this.baidu = baidu;
	}

	public int getActivated() {
		return activated;
	}

	public void setActivated(int activated) {
		this.activated = activated;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
}
