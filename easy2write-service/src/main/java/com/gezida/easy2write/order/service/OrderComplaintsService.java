/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.order.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezida.easy2write.common.persistence.Page;
import com.gezida.easy2write.common.service.CrudService;
import com.gezida.easy2write.order.bean.OrderComplaints;
import com.gezida.easy2write.order.dao.OrderComplaintsDao;

/**
 * 关于OrderComplaints服务申述的Service
 * @author Tangbinqi
 * @version 2017-08-15
 */
@Service
@Transactional(readOnly = true)
public class OrderComplaintsService extends CrudService<OrderComplaintsDao, OrderComplaints> {

	public OrderComplaints get(String id) {
		return super.get(id);
	}
	
	public List<OrderComplaints> findList(OrderComplaints orderComplaints) {
		return super.findList(orderComplaints);
	}
	
	public Page<OrderComplaints> findPage(Page<OrderComplaints> page, OrderComplaints orderComplaints) {
		return super.findPage(page, orderComplaints);
	}
	
	@Transactional(readOnly = false)
	public void save(OrderComplaints orderComplaints) {
		super.save(orderComplaints);
	}
	
	@Transactional(readOnly = false)
	public void delete(OrderComplaints orderComplaints) {
		super.delete(orderComplaints);
	}
	
}