/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.order.bean;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.gezida.easy2write.common.entity.DataEntity;

/**
 * 关于OrderScore服务订单评分表的Entity
 * @author Tangbinqi
 * @version 2017-08-15
 */
public class OrderScore extends DataEntity<OrderScore> {
	
	private static final long serialVersionUID = 1L;
	private Long scoreId;		// 评分ID
	private Long orderId;		// 订单ID
	private Long ordOrderId;		// 订单表_订单ID
	private Float scoreValue;		// 评分值
	private String scoreInfo;		// 评分详情
	private String scoreTag;		// 评分标签
	private String replyInfo;		// 导师回复
	private Date replyDate;		// 回复时间
	private Integer deleteFlag;		// 删除标记
	private String deleteCause;		// 删除原因
	
	public OrderScore() {
		super();
	}

	public OrderScore(String id){
		super(id);
	}

	@NotNull(message="评分ID不能为空")
	public Long getScoreId() {
		return scoreId;
	}

	public void setScoreId(Long scoreId) {
		this.scoreId = scoreId;
	}
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	public Long getOrdOrderId() {
		return ordOrderId;
	}

	public void setOrdOrderId(Long ordOrderId) {
		this.ordOrderId = ordOrderId;
	}
	
	public Float getScoreValue() {
		return scoreValue;
	}

	public void setScoreValue(Float scoreValue) {
		this.scoreValue = scoreValue;
	}
	
	@Length(min=0, max=200, message="评分详情长度必须介于 0 和 200 之间")
	public String getScoreInfo() {
		return scoreInfo;
	}

	public void setScoreInfo(String scoreInfo) {
		this.scoreInfo = scoreInfo;
	}
	
	@Length(min=0, max=100, message="评分标签长度必须介于 0 和 100 之间")
	public String getScoreTag() {
		return scoreTag;
	}

	public void setScoreTag(String scoreTag) {
		this.scoreTag = scoreTag;
	}
	
	@Length(min=0, max=200, message="导师回复长度必须介于 0 和 200 之间")
	public String getReplyInfo() {
		return replyInfo;
	}

	public void setReplyInfo(String replyInfo) {
		this.replyInfo = replyInfo;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	
	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	@Length(min=0, max=100, message="删除原因长度必须介于 0 和 100 之间")
	public String getDeleteCause() {
		return deleteCause;
	}

	public void setDeleteCause(String deleteCause) {
		this.deleteCause = deleteCause;
	}
	
}