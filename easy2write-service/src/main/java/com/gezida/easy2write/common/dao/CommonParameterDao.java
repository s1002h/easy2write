/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.common.dao;

import com.gezida.easy2write.common.annotation.MyBatisDao;
import com.gezida.easy2write.common.persistence.CrudDao;
import com.gezida.easy2write.common.bean.CommonParameter;

/**
 * 关于CommonParameter系统参数表的DAO接口
 * @author Tangbinqi
 * @version 2017-08-15
 */
@MyBatisDao
public interface CommonParameterDao extends CrudDao<CommonParameter> {
	
}