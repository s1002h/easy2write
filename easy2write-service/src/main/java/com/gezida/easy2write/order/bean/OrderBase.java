/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.order.bean;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.gezida.easy2write.common.sys.entity.User;

import com.gezida.easy2write.common.entity.DataEntity;

/**
 * 关于OrderBase订单表的Entity
 * @author Tangbinqi
 * @version 2017-08-15
 */
public class OrderBase extends DataEntity<OrderBase> {
	
	private static final long serialVersionUID = 1L;
	private Long orderId;		// 订单ID
	private String orderNum;		// 订单编号
	private User user;		// 用户ID
	private String crmUserId;		// 用户表_用户ID
	private Float payMoney;		// 支付金额
	private Integer payStatus;		// 支付状态
	private Float settlementMoney;		// 清算金额
	private Long currentUserId;		// 当前处理用户
	private Short onoff;		// 可用开关(1:可用)
	
	public OrderBase() {
		super();
	}

	public OrderBase(String id){
		super(id);
	}

	@NotNull(message="订单ID不能为空")
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	@Length(min=0, max=20, message="订单编号长度必须介于 0 和 20 之间")
	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Length(min=0, max=64, message="用户表_用户ID长度必须介于 0 和 64 之间")
	public String getCrmUserId() {
		return crmUserId;
	}

	public void setCrmUserId(String crmUserId) {
		this.crmUserId = crmUserId;
	}
	
	public Float getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(Float payMoney) {
		this.payMoney = payMoney;
	}
	
	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}
	
	public Float getSettlementMoney() {
		return settlementMoney;
	}

	public void setSettlementMoney(Float settlementMoney) {
		this.settlementMoney = settlementMoney;
	}
	
	public Long getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserId(Long currentUserId) {
		this.currentUserId = currentUserId;
	}
	
	public Short getOnoff() {
		return onoff;
	}

	public void setOnoff(Short onoff) {
		this.onoff = onoff;
	}
	
}