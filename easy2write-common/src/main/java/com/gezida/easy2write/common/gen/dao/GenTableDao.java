/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.gezida.easy2write.common.gen.dao;

import com.gezida.easy2write.common.annotation.MyBatisDao;
import com.gezida.easy2write.common.entity.GenTable;
import com.gezida.easy2write.common.persistence.CrudDao;

/**
 * 业务表DAO接口
 * @author ThinkGem
 * @version 2013-10-15
 */
@MyBatisDao
public interface GenTableDao extends CrudDao<GenTable> {
	
}
