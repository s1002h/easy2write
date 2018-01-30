/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.order.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezida.easy2write.common.persistence.Page;
import com.gezida.easy2write.common.service.CrudService;
import com.gezida.easy2write.order.bean.OrderBase;
import com.gezida.easy2write.order.dao.OrderBaseDao;

/**
 * 关于OrderBase订单表的Service
 * @author Tangbinqi
 * @version 2017-08-15
 */
@Service
@Transactional(readOnly = true)
public class OrderBaseService extends CrudService<OrderBaseDao, OrderBase> {

	public OrderBase get(String id) {
		return super.get(id);
	}
	
	public List<OrderBase> findList(OrderBase orderBase) {
		return super.findList(orderBase);
	}
	
	public Page<OrderBase> findPage(Page<OrderBase> page, OrderBase orderBase) {
		return super.findPage(page, orderBase);
	}
	
	@Transactional(readOnly = false)
	public void save(OrderBase orderBase) {
		super.save(orderBase);
	}
	
	@Transactional(readOnly = false)
	public void delete(OrderBase orderBase) {
		super.delete(orderBase);
	}
	
}