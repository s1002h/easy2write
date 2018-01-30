/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.order.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezida.easy2write.common.persistence.Page;
import com.gezida.easy2write.common.service.CrudService;
import com.gezida.easy2write.order.bean.OrderPay;
import com.gezida.easy2write.order.dao.OrderPayDao;

/**
 * 关于OrderPay订单账户支付表的Service
 * @author Tangbinqi
 * @version 2017-08-15
 */
@Service
@Transactional(readOnly = true)
public class OrderPayService extends CrudService<OrderPayDao, OrderPay> {

	public OrderPay get(String id) {
		return super.get(id);
	}
	
	public List<OrderPay> findList(OrderPay orderPay) {
		return super.findList(orderPay);
	}
	
	public Page<OrderPay> findPage(Page<OrderPay> page, OrderPay orderPay) {
		return super.findPage(page, orderPay);
	}
	
	@Transactional(readOnly = false)
	public void save(OrderPay orderPay) {
		super.save(orderPay);
	}
	
	@Transactional(readOnly = false)
	public void delete(OrderPay orderPay) {
		super.delete(orderPay);
	}
	
}