/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.message.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezida.easy2write.common.persistence.Page;
import com.gezida.easy2write.common.service.CrudService;
import com.gezida.easy2write.message.bean.MessageBoard;
import com.gezida.easy2write.message.dao.MessageBoardDao;

/**
 * 关于MessageBoard留言板的Service
 * @author Tangbinqi
 * @version 2017-08-15
 */
@Service
@Transactional(readOnly = true)
public class MessageBoardService extends CrudService<MessageBoardDao, MessageBoard> {

	public MessageBoard get(String id) {
		return super.get(id);
	}
	
	public List<MessageBoard> findList(MessageBoard messageBoard) {
		return super.findList(messageBoard);
	}
	
	public Page<MessageBoard> findPage(Page<MessageBoard> page, MessageBoard messageBoard) {
		return super.findPage(page, messageBoard);
	}
	
	@Transactional(readOnly = false)
	public void save(MessageBoard messageBoard) {
		super.save(messageBoard);
	}
	
	@Transactional(readOnly = false)
	public void delete(MessageBoard messageBoard) {
		super.delete(messageBoard);
	}
	
}