/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.message.dao;

import com.gezida.easy2write.common.annotation.MyBatisDao;
import com.gezida.easy2write.common.persistence.CrudDao;
import com.gezida.easy2write.message.bean.MessageBoard;

/**
 * 关于MessageBoard留言板的DAO接口
 * @author Tangbinqi
 * @version 2017-08-15
 */
@MyBatisDao
public interface MessageBoardDao extends CrudDao<MessageBoard> {
	
}