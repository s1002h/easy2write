/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.crm.bean;

import org.hibernate.validator.constraints.Length;
import com.gezida.easy2write.common.sys.entity.User;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.gezida.easy2write.common.entity.DataEntity;

/**
 * 关于CrmOauthBind第三方登录绑定的Entity
 * @author Tangbinqi
 * @version 2017-08-15
 */
public class CrmOauthBind extends DataEntity<CrmOauthBind> {
	
	private static final long serialVersionUID = 1L;
	private String bindId;		// 绑定ID
	private User user;		// 用户ID
	private String oauthId;		// 第三方授权ID
	private String oauthNickname;		// 第三方授权昵称
	private Integer oauthType;		// 第三方授权类型
	private Date bindDate;		// 绑定时间
	
	public CrmOauthBind() {
		super();
	}

	public CrmOauthBind(String id){
		super(id);
	}

	@Length(min=1, max=64, message="绑定ID长度必须介于 1 和 64 之间")
	public String getBindId() {
		return bindId;
	}

	public void setBindId(String bindId) {
		this.bindId = bindId;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Length(min=0, max=50, message="第三方授权ID长度必须介于 0 和 50 之间")
	public String getOauthId() {
		return oauthId;
	}

	public void setOauthId(String oauthId) {
		this.oauthId = oauthId;
	}
	
	@Length(min=0, max=50, message="第三方授权昵称长度必须介于 0 和 50 之间")
	public String getOauthNickname() {
		return oauthNickname;
	}

	public void setOauthNickname(String oauthNickname) {
		this.oauthNickname = oauthNickname;
	}
	
	public Integer getOauthType() {
		return oauthType;
	}

	public void setOauthType(Integer oauthType) {
		this.oauthType = oauthType;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBindDate() {
		return bindDate;
	}

	public void setBindDate(Date bindDate) {
		this.bindDate = bindDate;
	}
	
}