/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.good.bean;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.gezida.easy2write.common.entity.DataEntity;

/**
 * 关于GoodServiceFlow服务流程配置表的Entity
 * @author Tangbinqi
 * @version 2017-08-15
 */
public class GoodServiceFlow extends DataEntity<GoodServiceFlow> {
	
	private static final long serialVersionUID = 1L;
	private Long flowId;		// 流程ID
	private Long serviceId;		// 服务ID
	private String flowInfo;		// 流程配置信息
	private Integer level;		// 流程层级
	private Long parentFlowId;		// 父流程ID
	
	public GoodServiceFlow() {
		super();
	}

	public GoodServiceFlow(String id){
		super(id);
	}

	@NotNull(message="流程ID不能为空")
	public Long getFlowId() {
		return flowId;
	}

	public void setFlowId(Long flowId) {
		this.flowId = flowId;
	}
	
	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}
	
	@Length(min=0, max=200, message="流程配置信息长度必须介于 0 和 200 之间")
	public String getFlowInfo() {
		return flowInfo;
	}

	public void setFlowInfo(String flowInfo) {
		this.flowInfo = flowInfo;
	}
	
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
	
	public Long getParentFlowId() {
		return parentFlowId;
	}

	public void setParentFlowId(Long parentFlowId) {
		this.parentFlowId = parentFlowId;
	}
	
}