/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.crm.bean;

import com.gezida.easy2write.common.sys.entity.User;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.gezida.easy2write.common.entity.DataEntity;

/**
 * 关于CrmCustomEdu用户教育情况记录表的Entity
 * @author Tangbinqi
 * @version 2017-08-15
 */
public class CrmCustomEdu extends DataEntity<CrmCustomEdu> {
	
	private static final long serialVersionUID = 1L;
	private Long collegeId;		// 高校ID
	private Long majId;		// 专业ID
	private User user;		// 用户ID
	private Date startDate;		// 开始时间
	private Date endDate;		// 结束时间
	private Long status;		// 状态（1:毕业 0:在读）
	
	public CrmCustomEdu() {
		super();
	}

	public CrmCustomEdu(String id){
		super(id);
	}

	public Long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(Long collegeId) {
		this.collegeId = collegeId;
	}
	
	public Long getMajId() {
		return majId;
	}

	public void setMajId(Long majId) {
		this.majId = majId;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}
	
}