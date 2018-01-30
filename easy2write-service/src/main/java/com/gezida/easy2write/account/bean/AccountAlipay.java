/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.account.bean;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.gezida.easy2write.common.entity.DataEntity;

/**
 * 关于AccountAlipay绑定支付宝的Entity
 * @author Tangbinqi
 * @version 2017-08-15
 */
public class AccountAlipay extends DataEntity<AccountAlipay> {
	
	private static final long serialVersionUID = 1L;
	private Long alipayId;		// 绑定ID
	private Long accountId;		// 账户ID
	private String alipayName;		// 支付宝用户名
	private String realname;		// 真实姓名
	private String alipayAccount;		// 支付宝账户
	
	public AccountAlipay() {
		super();
	}

	public AccountAlipay(String id){
		super(id);
	}

	@NotNull(message="绑定ID不能为空")
	public Long getAlipayId() {
		return alipayId;
	}

	public void setAlipayId(Long alipayId) {
		this.alipayId = alipayId;
	}
	
	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	
	@Length(min=0, max=50, message="支付宝用户名长度必须介于 0 和 50 之间")
	public String getAlipayName() {
		return alipayName;
	}

	public void setAlipayName(String alipayName) {
		this.alipayName = alipayName;
	}
	
	@Length(min=0, max=50, message="真实姓名长度必须介于 0 和 50 之间")
	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}
	
	@Length(min=0, max=50, message="支付宝账户长度必须介于 0 和 50 之间")
	public String getAlipayAccount() {
		return alipayAccount;
	}

	public void setAlipayAccount(String alipayAccount) {
		this.alipayAccount = alipayAccount;
	}
	
}