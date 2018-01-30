/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.good.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezida.easy2write.common.persistence.Page;
import com.gezida.easy2write.common.service.CrudService;
import com.gezida.easy2write.good.bean.GoodServiceFlow;
import com.gezida.easy2write.good.dao.GoodServiceFlowDao;

/**
 * 关于GoodServiceFlow服务流程配置表的Service
 * @author Tangbinqi
 * @version 2017-08-15
 */
@Service
@Transactional(readOnly = true)
public class GoodServiceFlowService extends CrudService<GoodServiceFlowDao, GoodServiceFlow> {

	public GoodServiceFlow get(String id) {
		return super.get(id);
	}
	
	public List<GoodServiceFlow> findList(GoodServiceFlow goodServiceFlow) {
		return super.findList(goodServiceFlow);
	}
	
	public Page<GoodServiceFlow> findPage(Page<GoodServiceFlow> page, GoodServiceFlow goodServiceFlow) {
		return super.findPage(page, goodServiceFlow);
	}
	
	@Transactional(readOnly = false)
	public void save(GoodServiceFlow goodServiceFlow) {
		super.save(goodServiceFlow);
	}
	
	@Transactional(readOnly = false)
	public void delete(GoodServiceFlow goodServiceFlow) {
		super.delete(goodServiceFlow);
	}
	
}