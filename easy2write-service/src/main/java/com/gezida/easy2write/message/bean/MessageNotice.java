/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.message.bean;

import javax.validation.constraints.NotNull;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import com.gezida.easy2write.common.entity.DataEntity;

/**
 * 关于MessageNotice通知的Entity
 * @author Tangbinqi
 * @version 2017-08-15
 */
public class MessageNotice extends DataEntity<MessageNotice> {
	
	private static final long serialVersionUID = 1L;
	private Long noticeId;		// 通知ID
	private Long noticeType;		// 通知类型
	private Long sendUserId;		// 发送者
	private Long receiveUserId;		// 接收者
	private Date createAt;		// 时间
	private String message;		// 通知内容
	
	public MessageNotice() {
		super();
	}

	public MessageNotice(String id){
		super(id);
	}

	@NotNull(message="通知ID不能为空")
	public Long getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(Long noticeId) {
		this.noticeId = noticeId;
	}
	
	public Long getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(Long noticeType) {
		this.noticeType = noticeType;
	}
	
	public Long getSendUserId() {
		return sendUserId;
	}

	public void setSendUserId(Long sendUserId) {
		this.sendUserId = sendUserId;
	}
	
	public Long getReceiveUserId() {
		return receiveUserId;
	}

	public void setReceiveUserId(Long receiveUserId) {
		this.receiveUserId = receiveUserId;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	@Length(min=0, max=200, message="通知内容长度必须介于 0 和 200 之间")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}