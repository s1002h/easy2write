/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.order.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezida.easy2write.common.persistence.Page;
import com.gezida.easy2write.common.service.CrudService;
import com.gezida.easy2write.order.bean.OrderServiceRecord;
import com.gezida.easy2write.order.dao.OrderServiceRecordDao;

/**
 * 关于OrderServiceRecord订单服务流程记录表的Service
 * @author Tangbinqi
 * @version 2017-08-15
 */
@Service
@Transactional(readOnly = true)
public class OrderServiceRecordService extends CrudService<OrderServiceRecordDao, OrderServiceRecord> {

	public OrderServiceRecord get(String id) {
		return super.get(id);
	}
	
	public List<OrderServiceRecord> findList(OrderServiceRecord orderServiceRecord) {
		return super.findList(orderServiceRecord);
	}
	
	public Page<OrderServiceRecord> findPage(Page<OrderServiceRecord> page, OrderServiceRecord orderServiceRecord) {
		return super.findPage(page, orderServiceRecord);
	}
	
	@Transactional(readOnly = false)
	public void save(OrderServiceRecord orderServiceRecord) {
		super.save(orderServiceRecord);
	}
	
	@Transactional(readOnly = false)
	public void delete(OrderServiceRecord orderServiceRecord) {
		super.delete(orderServiceRecord);
	}
	
}