/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.good.bean;

import javax.validation.constraints.NotNull;
import com.gezida.easy2write.common.sys.entity.User;

import com.gezida.easy2write.common.entity.DataEntity;

/**
 * 关于GoodBase商品信息表的Entity
 * @author Tangbinqi
 * @version 2017-08-15
 */
public class GoodBase extends DataEntity<GoodBase> {
	
	private static final long serialVersionUID = 1L;
	private Long goodId;		// 商品ID
	private Long serviceId;		// 服务ID
	private Long majorId;		// 专业ID
	private User user;		// 用户ID
	private Short onoff;		// 可用开关(1:可用)
	
	public GoodBase() {
		super();
	}

	public GoodBase(String id){
		super(id);
	}

	@NotNull(message="商品ID不能为空")
	public Long getGoodId() {
		return goodId;
	}

	public void setGoodId(Long goodId) {
		this.goodId = goodId;
	}
	
	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}
	
	public Long getMajorId() {
		return majorId;
	}

	public void setMajorId(Long majorId) {
		this.majorId = majorId;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Short getOnoff() {
		return onoff;
	}

	public void setOnoff(Short onoff) {
		this.onoff = onoff;
	}
	
}