/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.message.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezida.easy2write.common.persistence.Page;
import com.gezida.easy2write.common.service.CrudService;
import com.gezida.easy2write.message.bean.MessageNotice;
import com.gezida.easy2write.message.dao.MessageNoticeDao;

/**
 * 关于MessageNotice通知的Service
 * @author Tangbinqi
 * @version 2017-08-15
 */
@Service
@Transactional(readOnly = true)
public class MessageNoticeService extends CrudService<MessageNoticeDao, MessageNotice> {

	public MessageNotice get(String id) {
		return super.get(id);
	}
	
	public List<MessageNotice> findList(MessageNotice messageNotice) {
		return super.findList(messageNotice);
	}
	
	public Page<MessageNotice> findPage(Page<MessageNotice> page, MessageNotice messageNotice) {
		return super.findPage(page, messageNotice);
	}
	
	@Transactional(readOnly = false)
	public void save(MessageNotice messageNotice) {
		super.save(messageNotice);
	}
	
	@Transactional(readOnly = false)
	public void delete(MessageNotice messageNotice) {
		super.delete(messageNotice);
	}
	
}