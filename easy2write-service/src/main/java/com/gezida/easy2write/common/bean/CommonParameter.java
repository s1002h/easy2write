/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.common.bean;

import org.hibernate.validator.constraints.Length;

import com.gezida.easy2write.common.entity.DataEntity;

/**
 * 关于CommonParameter系统参数表的Entity
 * @author Tangbinqi
 * @version 2017-08-15
 */
public class CommonParameter extends DataEntity<CommonParameter> {
	
	private static final long serialVersionUID = 1L;
	private String type;		// 分类
	private String parameter;		// 参数
	private String comment;		// 参数注释
	private String value;		// 值
	private Short onoff;		// 可用开关(1:可用)
	
	public CommonParameter() {
		super();
	}

	public CommonParameter(String id){
		super(id);
	}

	@Length(min=1, max=20, message="分类长度必须介于 1 和 20 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=1, max=20, message="参数长度必须介于 1 和 20 之间")
	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	
	@Length(min=0, max=100, message="参数注释长度必须介于 0 和 100 之间")
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Length(min=1, max=10, message="值长度必须介于 1 和 10 之间")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public Short getOnoff() {
		return onoff;
	}

	public void setOnoff(Short onoff) {
		this.onoff = onoff;
	}
	
}