/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.order.dao;

import com.gezida.easy2write.common.annotation.MyBatisDao;
import com.gezida.easy2write.common.persistence.CrudDao;
import com.gezida.easy2write.order.bean.OrderBase;

/**
 * 关于OrderBase订单表的DAO接口
 * @author Tangbinqi
 * @version 2017-08-15
 */
@MyBatisDao
public interface OrderBaseDao extends CrudDao<OrderBase> {
	
}