/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.good.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezida.easy2write.common.persistence.Page;
import com.gezida.easy2write.common.service.CrudService;
import com.gezida.easy2write.good.bean.GoodServiceType;
import com.gezida.easy2write.good.dao.GoodServiceTypeDao;

/**
 * 关于GoodServiceType服务类型的Service
 * @author Tangbinqi
 * @version 2017-08-15
 */
@Service
@Transactional(readOnly = true)
public class GoodServiceTypeService extends CrudService<GoodServiceTypeDao, GoodServiceType> {

	public GoodServiceType get(String id) {
		return super.get(id);
	}
	
	public List<GoodServiceType> findList(GoodServiceType goodServiceType) {
		return super.findList(goodServiceType);
	}
	
	public Page<GoodServiceType> findPage(Page<GoodServiceType> page, GoodServiceType goodServiceType) {
		return super.findPage(page, goodServiceType);
	}
	
	@Transactional(readOnly = false)
	public void save(GoodServiceType goodServiceType) {
		super.save(goodServiceType);
	}
	
	@Transactional(readOnly = false)
	public void delete(GoodServiceType goodServiceType) {
		super.delete(goodServiceType);
	}
	
}