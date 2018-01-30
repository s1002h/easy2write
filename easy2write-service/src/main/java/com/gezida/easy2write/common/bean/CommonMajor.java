/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.common.bean;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonBackReference;

import com.gezida.easy2write.common.entity.DataEntity;

/**
 * 关于CommonMajor专业的Entity
 * @author Tangbinqi
 * @version 2017-08-15
 */
public class CommonMajor extends DataEntity<CommonMajor> {
	
	private static final long serialVersionUID = 1L;
	private Long majorId;		// 专业ID
	private String name;		// 专业名称
	private String code;		// 专业代码
	private Integer level;		// 专业等级
	private CommonMajor parent;		// 父ID
	private Short onoff;		// 可用开关(1:可用)
	
	public CommonMajor() {
		super();
	}

	public CommonMajor(String id){
		super(id);
	}

	@NotNull(message="专业ID不能为空")
	public Long getMajorId() {
		return majorId;
	}

	public void setMajorId(Long majorId) {
		this.majorId = majorId;
	}
	
	@Length(min=1, max=50, message="专业名称长度必须介于 1 和 50 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=1, max=7, message="专业代码长度必须介于 1 和 7 之间")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@NotNull(message="专业等级不能为空")
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
	
	@JsonBackReference
	@NotNull(message="父ID不能为空")
	public CommonMajor getParent() {
		return parent;
	}

	public void setParent(CommonMajor parent) {
		this.parent = parent;
	}
	
	public Short getOnoff() {
		return onoff;
	}

	public void setOnoff(Short onoff) {
		this.onoff = onoff;
	}
	
}