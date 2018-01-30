/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.common.bean;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonBackReference;

import com.gezida.easy2write.common.entity.DataEntity;

/**
 * 关于CommonCollege高校表的Entity
 * @author Tangbinqi
 * @version 2017-08-15
 */
public class CommonCollege extends DataEntity<CommonCollege> {
	
	private static final long serialVersionUID = 1L;
	private Long collegeId;		// 高校ID
	private String code;		// 院校代码
	private String name;		// 院校名称
	private String simpleName;		// 院系简称
	private String provinceId;		// 所在省份
	private String province;		// 省份
	private String cityId;		// 所在城市
	private String city;		// 城市
	private String nature;		// 高校性质
	private String introduction;		// 学校简介
	private CommonCollege parent;		// 父院校
	private Short onoff;		// 可用开关(1:可用)
	
	public CommonCollege() {
		super();
	}

	public CommonCollege(String id){
		super(id);
	}

	@NotNull(message="高校ID不能为空")
	public Long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(Long collegeId) {
		this.collegeId = collegeId;
	}
	
	@Length(min=1, max=5, message="院校代码长度必须介于 1 和 5 之间")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Length(min=1, max=50, message="院校名称长度必须介于 1 和 50 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=1, max=20, message="院系简称长度必须介于 1 和 20 之间")
	public String getSimpleName() {
		return simpleName;
	}

	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}
	
	@Length(min=1, max=6, message="所在省份长度必须介于 1 和 6 之间")
	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	
	@Length(min=1, max=20, message="省份长度必须介于 1 和 20 之间")
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	@Length(min=0, max=6, message="所在城市长度必须介于 0 和 6 之间")
	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	
	@Length(min=0, max=20, message="城市长度必须介于 0 和 20 之间")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Length(min=1, max=1, message="高校性质长度必须介于 1 和 1 之间")
	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}
	
	@Length(min=0, max=100, message="学校简介长度必须介于 0 和 100 之间")
	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	@JsonBackReference
	public CommonCollege getParent() {
		return parent;
	}

	public void setParent(CommonCollege parent) {
		this.parent = parent;
	}
	
	public Short getOnoff() {
		return onoff;
	}

	public void setOnoff(Short onoff) {
		this.onoff = onoff;
	}
	
}