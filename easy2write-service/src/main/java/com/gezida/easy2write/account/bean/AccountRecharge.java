/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.account.bean;

import javax.validation.constraints.NotNull;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.gezida.easy2write.common.entity.DataEntity;

/**
 * 关于AccountRecharge充值记录表的Entity
 * @author Tangbinqi
 * @version 2017-08-15
 */
public class AccountRecharge extends DataEntity<AccountRecharge> {
	
	private static final long serialVersionUID = 1L;
	private Long recordId;		// 充值记录ID
	private Long accountId;		// 账户ID
	private Float moneyNum;		// 充值消费金额
	private Float pointNum;		// 积分额
	private Date createAt;		// 充值时间
	private Integer type;		// 充值类型
	
	public AccountRecharge() {
		super();
	}

	public AccountRecharge(String id){
		super(id);
	}

	@NotNull(message="充值记录ID不能为空")
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
	
	public Float getMoneyNum() {
		return moneyNum;
	}

	public void setMoneyNum(Float moneyNum) {
		this.moneyNum = moneyNum;
	}
	
	public Float getPointNum() {
		return pointNum;
	}

	public void setPointNum(Float pointNum) {
		this.pointNum = pointNum;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
}