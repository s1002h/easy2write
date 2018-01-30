/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.order.dao;

import com.gezida.easy2write.common.annotation.MyBatisDao;
import com.gezida.easy2write.common.persistence.CrudDao;
import com.gezida.easy2write.order.bean.OrderServiceRecord;

/**
 * 关于OrderServiceRecord订单服务流程记录表的DAO接口
 * @author Tangbinqi
 * @version 2017-08-15
 */
@MyBatisDao
public interface OrderServiceRecordDao extends CrudDao<OrderServiceRecord> {
	
}