/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.account.dao;

import com.gezida.easy2write.common.annotation.MyBatisDao;
import com.gezida.easy2write.common.persistence.CrudDao;
import com.gezida.easy2write.account.bean.AccountBase;

/**
 * 关于AccountBase账户额度表的DAO接口
 * @author Tangbinqi
 * @version 2017-08-15
 */
@MyBatisDao
public interface AccountBaseDao extends CrudDao<AccountBase> {
	
}