/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.crm.bean;

import com.gezida.easy2write.common.sys.entity.User;
import org.hibernate.validator.constraints.Length;

import com.gezida.easy2write.common.entity.DataEntity;

/**
 * 关于CrmTutor导师的Entity
 * @author Tangbinqi
 * @version 2017-08-15
 */
public class CrmTutor extends DataEntity<CrmTutor> {
	
	private static final long serialVersionUID = 1L;
	private User user;		// 用户ID
	private String tutorOffice;		// 导师任职机构
	private Long verified;		// 已认证(1:已)
	private String verifiedFile;		// 证明文件路径
	private String majorGood;		// 擅长专业
	private String summary;		// 导师介绍
	
	public CrmTutor() {
		super();
	}

	public CrmTutor(String id){
		super(id);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Length(min=0, max=200, message="导师任职机构长度必须介于 0 和 200 之间")
	public String getTutorOffice() {
		return tutorOffice;
	}

	public void setTutorOffice(String tutorOffice) {
		this.tutorOffice = tutorOffice;
	}
	
	public Long getVerified() {
		return verified;
	}

	public void setVerified(Long verified) {
		this.verified = verified;
	}
	
	@Length(min=0, max=500, message="证明文件路径长度必须介于 0 和 500 之间")
	public String getVerifiedFile() {
		return verifiedFile;
	}

	public void setVerifiedFile(String verifiedFile) {
		this.verifiedFile = verifiedFile;
	}
	
	@Length(min=0, max=200, message="擅长专业长度必须介于 0 和 200 之间")
	public String getMajorGood() {
		return majorGood;
	}

	public void setMajorGood(String majorGood) {
		this.majorGood = majorGood;
	}
	
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
}