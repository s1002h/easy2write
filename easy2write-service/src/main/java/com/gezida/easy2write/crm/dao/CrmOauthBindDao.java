/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.crm.dao;

import com.gezida.easy2write.common.annotation.MyBatisDao;
import com.gezida.easy2write.common.persistence.CrudDao;
import com.gezida.easy2write.crm.bean.CrmOauthBind;

/**
 * 关于CrmOauthBind第三方登录绑定的DAO接口
 * @author Tangbinqi
 * @version 2017-08-15
 */
@MyBatisDao
public interface CrmOauthBindDao extends CrudDao<CrmOauthBind> {
	
}