/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.account.bean;

import javax.validation.constraints.NotNull;
import com.gezida.easy2write.common.sys.entity.User;

import com.gezida.easy2write.common.entity.DataEntity;

/**
 * 关于AccountBase账户额度表的Entity
 * @author Tangbinqi
 * @version 2017-08-15
 */
public class AccountBase extends DataEntity<AccountBase> {
	
	private static final long serialVersionUID = 1L;
	private Long accountId;		// 账户ID
	private User user;		// 用户ID
	private Float balanceFree;		// 余额免费
	private Float balanceRecharge;		// 余额充值
	private Float balance;		// 余额总额
	private Float totalRecharge;		// 充值总额
	private Long countRecharge;		// 充值总次数
	private Float totalFree;		// 免费总额
	private Long countFree;		// 免费总次数
	private Float totalWithdraw;		// 提现总额
	private Long countWithdraw;		// 提现次数
	
	public AccountBase() {
		super();
	}

	public AccountBase(String id){
		super(id);
	}

	@NotNull(message="账户ID不能为空")
	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Float getBalanceFree() {
		return balanceFree;
	}

	public void setBalanceFree(Float balanceFree) {
		this.balanceFree = balanceFree;
	}
	
	public Float getBalanceRecharge() {
		return balanceRecharge;
	}

	public void setBalanceRecharge(Float balanceRecharge) {
		this.balanceRecharge = balanceRecharge;
	}
	
	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}
	
	public Float getTotalRecharge() {
		return totalRecharge;
	}

	public void setTotalRecharge(Float totalRecharge) {
		this.totalRecharge = totalRecharge;
	}
	
	public Long getCountRecharge() {
		return countRecharge;
	}

	public void setCountRecharge(Long countRecharge) {
		this.countRecharge = countRecharge;
	}
	
	public Float getTotalFree() {
		return totalFree;
	}

	public void setTotalFree(Float totalFree) {
		this.totalFree = totalFree;
	}
	
	public Long getCountFree() {
		return countFree;
	}

	public void setCountFree(Long countFree) {
		this.countFree = countFree;
	}
	
	public Float getTotalWithdraw() {
		return totalWithdraw;
	}

	public void setTotalWithdraw(Float totalWithdraw) {
		this.totalWithdraw = totalWithdraw;
	}
	
	public Long getCountWithdraw() {
		return countWithdraw;
	}

	public void setCountWithdraw(Long countWithdraw) {
		this.countWithdraw = countWithdraw;
	}
	
}