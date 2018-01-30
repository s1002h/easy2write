/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.crm.bean;

import com.gezida.easy2write.common.sys.entity.User;
import org.hibernate.validator.constraints.Length;

import com.gezida.easy2write.common.entity.DataEntity;

/**
 * 关于CrmStudent学生信息的Entity
 * @author Tangbinqi
 * @version 2017-08-15
 */
public class CrmStudent extends DataEntity<CrmStudent> {
	
	private static final long serialVersionUID = 1L;
	private User user;		// 用户ID
	private String majId;		// 学习专业
	private String summary;		// 个人简介
	
	public CrmStudent() {
		super();
	}

	public CrmStudent(String id){
		super(id);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Length(min=1, max=200, message="学习专业长度必须介于 1 和 200 之间")
	public String getMajId() {
		return majId;
	}

	public void setMajId(String majId) {
		this.majId = majId;
	}
	
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
}