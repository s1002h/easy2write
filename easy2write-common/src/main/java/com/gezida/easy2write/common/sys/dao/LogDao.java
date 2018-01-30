/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.gezida.easy2write.common.sys.dao;

import com.gezida.easy2write.common.annotation.MyBatisDao;
import com.gezida.easy2write.common.persistence.CrudDao;
import com.gezida.easy2write.common.sys.entity.Log;

/**
 * 日志DAO接口
 * @author ThinkGem
 * @version 2014-05-16
 */
@MyBatisDao
public interface LogDao extends CrudDao<Log> {

}
