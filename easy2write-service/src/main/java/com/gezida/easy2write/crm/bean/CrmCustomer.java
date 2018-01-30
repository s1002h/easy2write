/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.crm.bean;

import com.gezida.easy2write.common.sys.entity.User;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.gezida.easy2write.common.entity.DataEntity;

/**
 * 关于CrmCustomer用户表的Entity
 * @author Tangbinqi
 * @version 2017-08-15
 */
public class CrmCustomer extends DataEntity<CrmCustomer> {
	
	private static final long serialVersionUID = 1L;
	private User user;		// 用户ID
	private String loginName;		// 登录名
	private String password;		// 密码
	private String name;		// 昵称
	private Short isTutor;		// 是导师(1:是)
	private Short isStudent;		// 是学生(1:是)
	private Short isSys;		// 是管理员(1:是)
	private Short sex;		// 性别(1:男)
	private String province;		// 省份
	private String city;		// 城市
	private Short onoff;		// 可用开关(1:可用)
	
	public CrmCustomer() {
		super();
	}

	public CrmCustomer(String id){
		super(id);
	}

	@NotNull(message="用户ID不能为空")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Length(min=0, max=64, message="登录名长度必须介于 0 和 64 之间")
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	@Length(min=0, max=64, message="密码长度必须介于 0 和 64 之间")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Length(min=0, max=64, message="昵称长度必须介于 0 和 64 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Short getIsTutor() {
		return isTutor;
	}

	public void setIsTutor(Short isTutor) {
		this.isTutor = isTutor;
	}
	
	public Short getIsStudent() {
		return isStudent;
	}

	public void setIsStudent(Short isStudent) {
		this.isStudent = isStudent;
	}
	
	public Short getIsSys() {
		return isSys;
	}

	public void setIsSys(Short isSys) {
		this.isSys = isSys;
	}
	
	public Short getSex() {
		return sex;
	}

	public void setSex(Short sex) {
		this.sex = sex;
	}
	
	@Length(min=0, max=20, message="省份长度必须介于 0 和 20 之间")
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	@Length(min=0, max=20, message="城市长度必须介于 0 和 20 之间")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public Short getOnoff() {
		return onoff;
	}

	public void setOnoff(Short onoff) {
		this.onoff = onoff;
	}
	
}