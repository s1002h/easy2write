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
 * 关于CrmContactBind联系方式绑定的Entity
 * @author Tangbinqi
 * @version 2017-08-15
 */
public class CrmContactBind extends DataEntity<CrmContactBind> {
	
	private static final long serialVersionUID = 1L;
	private String contactId;		// 手机绑定ID
	private User user;		// 用户ID
	private Long contactType;		// 联系方式类型(1:手机 2:有限)
	private String contact;		// 联系方式
	private Date bindDate;		// 绑定时间
	
	public CrmContactBind() {
		super();
	}

	public CrmContactBind(String id){
		super(id);
	}

	@Length(min=1, max=64, message="手机绑定ID长度必须介于 1 和 64 之间")
	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Long getContactType() {
		return contactType;
	}

	public void setContactType(Long contactType) {
		this.contactType = contactType;
	}
	
	@Length(min=0, max=50, message="联系方式长度必须介于 0 和 50 之间")
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBindDate() {
		return bindDate;
	}

	public void setBindDate(Date bindDate) {
		this.bindDate = bindDate;
	}
	
}