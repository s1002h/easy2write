/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.order.bean;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.gezida.easy2write.common.entity.DataEntity;

/**
 * 关于OrderComplaints服务申述的Entity
 * @author Tangbinqi
 * @version 2017-08-15
 */
public class OrderComplaints extends DataEntity<OrderComplaints> {
	
	private static final long serialVersionUID = 1L;
	private Long complaintsId;		// 投诉ID
	private Long orderId;		// 订单ID
	private Short complaintsType;		// 投诉类型
	private String complaintsContent;		// 投诉内容
	private Integer processStatus;		// 处理状态
	private String processResult;		// 处理结果
	
	public OrderComplaints() {
		super();
	}

	public OrderComplaints(String id){
		super(id);
	}

	@NotNull(message="投诉ID不能为空")
	public Long getComplaintsId() {
		return complaintsId;
	}

	public void setComplaintsId(Long complaintsId) {
		this.complaintsId = complaintsId;
	}
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	public Short getComplaintsType() {
		return complaintsType;
	}

	public void setComplaintsType(Short complaintsType) {
		this.complaintsType = complaintsType;
	}
	
	public String getComplaintsContent() {
		return complaintsContent;
	}

	public void setComplaintsContent(String complaintsContent) {
		this.complaintsContent = complaintsContent;
	}
	
	public Integer getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(Integer processStatus) {
		this.processStatus = processStatus;
	}
	
	@Length(min=0, max=200, message="处理结果长度必须介于 0 和 200 之间")
	public String getProcessResult() {
		return processResult;
	}

	public void setProcessResult(String processResult) {
		this.processResult = processResult;
	}
	
}