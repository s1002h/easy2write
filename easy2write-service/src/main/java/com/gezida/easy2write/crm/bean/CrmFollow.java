/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.crm.bean;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.gezida.easy2write.common.entity.DataEntity;

/**
 * 关于CrmFollow用户关注表的Entity
 * @author Tangbinqi
 * @version 2017-08-15
 */
public class CrmFollow extends DataEntity<CrmFollow> {
	
	private static final long serialVersionUID = 1L;
	private String followUserId;		// 关注_用户ID
	private String befollowUserId;		// 被关注_用户ID
	private Date createAt;		// 创建时间
	
	public CrmFollow() {
		super();
	}

	public CrmFollow(String id){
		super(id);
	}

	@Length(min=0, max=64, message="关注_用户ID长度必须介于 0 和 64 之间")
	public String getFollowUserId() {
		return followUserId;
	}

	public void setFollowUserId(String followUserId) {
		this.followUserId = followUserId;
	}
	
	@Length(min=0, max=64, message="被关注_用户ID长度必须介于 0 和 64 之间")
	public String getBefollowUserId() {
		return befollowUserId;
	}

	public void setBefollowUserId(String befollowUserId) {
		this.befollowUserId = befollowUserId;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
}