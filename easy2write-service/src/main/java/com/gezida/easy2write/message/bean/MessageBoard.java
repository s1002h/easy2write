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
 * 关于MessageBoard留言板的Entity
 * @author Tangbinqi
 * @version 2017-08-15
 */
public class MessageBoard extends DataEntity<MessageBoard> {
	
	private static final long serialVersionUID = 1L;
	private Long messageId;		// 留言ID
	private Long sendUserId;		// 发送者
	private Long receiveUserId;		// 接收者
	private Date createAt;		// 创建时间
	private String replyMsg;		// 导师回复
	private Date replyAt;		// 回复时间
	private Integer deleteFlag;		// 删除标记
	private String deleteCause;		// 删除原因
	
	public MessageBoard() {
		super();
	}

	public MessageBoard(String id){
		super(id);
	}

	@NotNull(message="留言ID不能为空")
	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
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
	
	@Length(min=0, max=200, message="导师回复长度必须介于 0 和 200 之间")
	public String getReplyMsg() {
		return replyMsg;
	}

	public void setReplyMsg(String replyMsg) {
		this.replyMsg = replyMsg;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getReplyAt() {
		return replyAt;
	}

	public void setReplyAt(Date replyAt) {
		this.replyAt = replyAt;
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