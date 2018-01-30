/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.account.bean;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.gezida.easy2write.common.entity.DataEntity;

/**
 * 关于AccountWithdraw账户提现记录表的Entity
 * @author Tangbinqi
 * @version 2017-08-15
 */
public class AccountWithdraw extends DataEntity<AccountWithdraw> {
	
	private static final long serialVersionUID = 1L;
	private String 提现记录id;		// 提现记录ID
	private Long accountId;		// 账户ID
	private Long alipayId;		// 绑定ID
	private Float numWithdraw;		// 提现数额
	private Date withdrawDate;		// 提现时间
	private Integer status;		// 提现状态(0:申请 1:成功 -1:失败)
	private String auditReason;		// 审批原因
	
	public AccountWithdraw() {
		super();
	}

	public AccountWithdraw(String id){
		super(id);
	}

	@Length(min=1, max=64, message="提现记录ID长度必须介于 1 和 64 之间")
	public String get提现记录id() {
		return 提现记录id;
	}

	public void set提现记录id(String 提现记录id) {
		this.提现记录id = 提现记录id;
	}
	
	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	
	public Long getAlipayId() {
		return alipayId;
	}

	public void setAlipayId(Long alipayId) {
		this.alipayId = alipayId;
	}
	
	public Float getNumWithdraw() {
		return numWithdraw;
	}

	public void setNumWithdraw(Float numWithdraw) {
		this.numWithdraw = numWithdraw;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getWithdrawDate() {
		return withdrawDate;
	}

	public void setWithdrawDate(Date withdrawDate) {
		this.withdrawDate = withdrawDate;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@Length(min=0, max=200, message="审批原因长度必须介于 0 和 200 之间")
	public String getAuditReason() {
		return auditReason;
	}

	public void setAuditReason(String auditReason) {
		this.auditReason = auditReason;
	}
	
}