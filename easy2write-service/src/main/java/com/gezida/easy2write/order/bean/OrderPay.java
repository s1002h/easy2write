/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.order.bean;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.gezida.easy2write.common.entity.DataEntity;

/**
 * 关于OrderPay订单账户支付表的Entity
 * @author Tangbinqi
 * @version 2017-08-15
 */
public class OrderPay extends DataEntity<OrderPay> {
	
	private static final long serialVersionUID = 1L;
	private Long payId;		// 支付ID
	private String payNum;		// 支付编码
	private Long orderId;		// 订单ID
	private Long fromAccountId;		// 支付_账户ID
	private Long toAccountId;		// 收款_账户ID
	private Float payAmount;		// 支付金额
	
	public OrderPay() {
		super();
	}

	public OrderPay(String id){
		super(id);
	}

	@NotNull(message="支付ID不能为空")
	public Long getPayId() {
		return payId;
	}

	public void setPayId(Long payId) {
		this.payId = payId;
	}
	
	@Length(min=0, max=20, message="支付编码长度必须介于 0 和 20 之间")
	public String getPayNum() {
		return payNum;
	}

	public void setPayNum(String payNum) {
		this.payNum = payNum;
	}
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	public Long getFromAccountId() {
		return fromAccountId;
	}

	public void setFromAccountId(Long fromAccountId) {
		this.fromAccountId = fromAccountId;
	}
	
	public Long getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(Long toAccountId) {
		this.toAccountId = toAccountId;
	}
	
	public Float getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(Float payAmount) {
		this.payAmount = payAmount;
	}
	
}