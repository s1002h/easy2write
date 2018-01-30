/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.order.bean;

import javax.validation.constraints.NotNull;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.gezida.easy2write.common.entity.DataEntity;

/**
 * 关于OrderServiceRecord订单服务流程记录表的Entity
 * @author Tangbinqi
 * @version 2017-08-15
 */
public class OrderServiceRecord extends DataEntity<OrderServiceRecord> {
	
	private static final long serialVersionUID = 1L;
	private Long recordId;		// 记录ID
	private Long flowId;		// 流程ID
	private Long orderId;		// 订单ID
	private Date datetime;		// 发生时间
	
	public OrderServiceRecord() {
		super();
	}

	public OrderServiceRecord(String id){
		super(id);
	}

	@NotNull(message="记录ID不能为空")
	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}
	
	public Long getFlowId() {
		return flowId;
	}

	public void setFlowId(Long flowId) {
		this.flowId = flowId;
	}
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	
}