/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.good.bean;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.gezida.easy2write.common.entity.DataEntity;

/**
 * 关于GoodServiceType服务类型的Entity
 * @author Tangbinqi
 * @version 2017-08-15
 */
public class GoodServiceType extends DataEntity<GoodServiceType> {
	
	private static final long serialVersionUID = 1L;
	private Long serviceTypeId;		// 服务ID
	private String serviceName;		// 服务名称
	private String seviceDesc;		// 服务内容介绍
	private Float priceLowest;		// 最低价
	private Float priceHighest;		// 最高价
	private Date createAt;		// 创建时间
	private Long createUserId;		// 创建者
	private Integer status;		// 状态
	private Date updateAt;		// 修改时间
	private Long updateUserId;		// 修改者
	
	public GoodServiceType() {
		super();
	}

	public GoodServiceType(String id){
		super(id);
	}

	@NotNull(message="服务ID不能为空")
	public Long getServiceTypeId() {
		return serviceTypeId;
	}

	public void setServiceTypeId(Long serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}
	
	@Length(min=0, max=50, message="服务名称长度必须介于 0 和 50 之间")
	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	public String getSeviceDesc() {
		return seviceDesc;
	}

	public void setSeviceDesc(String seviceDesc) {
		this.seviceDesc = seviceDesc;
	}
	
	public Float getPriceLowest() {
		return priceLowest;
	}

	public void setPriceLowest(Float priceLowest) {
		this.priceLowest = priceLowest;
	}
	
	public Float getPriceHighest() {
		return priceHighest;
	}

	public void setPriceHighest(Float priceHighest) {
		this.priceHighest = priceHighest;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	
	public Long getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}
	
}