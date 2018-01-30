/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.account.bean;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.gezida.easy2write.common.entity.DataEntity;

/**
 * 关于AccountFree免费额度获取记录表的Entity
 * @author Tangbinqi
 * @version 2017-08-15
 */
public class AccountFree extends DataEntity<AccountFree> {
	
	private static final long serialVersionUID = 1L;
	private Long recordId;		// 免费额度记录ID
	private Long accountId;		// 账户ID
	private Float point;		// 积分
	private String pointEvent;		// 积分事项
	
	public AccountFree() {
		super();
	}

	public AccountFree(String id){
		super(id);
	}

	@NotNull(message="免费额度记录ID不能为空")
	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}
	
	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	
	public Float getPoint() {
		return point;
	}

	public void setPoint(Float point) {
		this.point = point;
	}
	
	@Length(min=0, max=200, message="积分事项长度必须介于 0 和 200 之间")
	public String getPointEvent() {
		return pointEvent;
	}

	public void setPointEvent(String pointEvent) {
		this.pointEvent = pointEvent;
	}
	
}