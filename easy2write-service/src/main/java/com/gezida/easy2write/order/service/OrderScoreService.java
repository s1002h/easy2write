/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.order.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezida.easy2write.common.persistence.Page;
import com.gezida.easy2write.common.service.CrudService;
import com.gezida.easy2write.order.bean.OrderScore;
import com.gezida.easy2write.order.dao.OrderScoreDao;

/**
 * 关于OrderScore服务订单评分表的Service
 * @author Tangbinqi
 * @version 2017-08-15
 */
@Service
@Transactional(readOnly = true)
public class OrderScoreService extends CrudService<OrderScoreDao, OrderScore> {

	public OrderScore get(String id) {
		return super.get(id);
	}
	
	public List<OrderScore> findList(OrderScore orderScore) {
		return super.findList(orderScore);
	}
	
	public Page<OrderScore> findPage(Page<OrderScore> page, OrderScore orderScore) {
		return super.findPage(page, orderScore);
	}
	
	@Transactional(readOnly = false)
	public void save(OrderScore orderScore) {
		super.save(orderScore);
	}
	
	@Transactional(readOnly = false)
	public void delete(OrderScore orderScore) {
		super.delete(orderScore);
	}
	
}