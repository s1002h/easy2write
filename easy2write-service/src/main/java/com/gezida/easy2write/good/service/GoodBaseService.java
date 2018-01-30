/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.good.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezida.easy2write.common.persistence.Page;
import com.gezida.easy2write.common.service.CrudService;
import com.gezida.easy2write.good.bean.GoodBase;
import com.gezida.easy2write.good.dao.GoodBaseDao;

/**
 * 关于GoodBase商品信息表的Service
 * @author Tangbinqi
 * @version 2017-08-15
 */
@Service
@Transactional(readOnly = true)
public class GoodBaseService extends CrudService<GoodBaseDao, GoodBase> {

	public GoodBase get(String id) {
		return super.get(id);
	}
	
	public List<GoodBase> findList(GoodBase goodBase) {
		return super.findList(goodBase);
	}
	
	public Page<GoodBase> findPage(Page<GoodBase> page, GoodBase goodBase) {
		return super.findPage(page, goodBase);
	}
	
	@Transactional(readOnly = false)
	public void save(GoodBase goodBase) {
		super.save(goodBase);
	}
	
	@Transactional(readOnly = false)
	public void delete(GoodBase goodBase) {
		super.delete(goodBase);
	}
	
}