/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.crm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezida.easy2write.common.persistence.Page;
import com.gezida.easy2write.common.service.CrudService;
import com.gezida.easy2write.crm.bean.CrmFollow;
import com.gezida.easy2write.crm.dao.CrmFollowDao;

/**
 * 关于CrmFollow用户关注表的Service
 * @author Tangbinqi
 * @version 2017-08-15
 */
@Service
@Transactional(readOnly = true)
public class CrmFollowService extends CrudService<CrmFollowDao, CrmFollow> {

	public CrmFollow get(String id) {
		return super.get(id);
	}
	
	public List<CrmFollow> findList(CrmFollow crmFollow) {
		return super.findList(crmFollow);
	}
	
	public Page<CrmFollow> findPage(Page<CrmFollow> page, CrmFollow crmFollow) {
		return super.findPage(page, crmFollow);
	}
	
	@Transactional(readOnly = false)
	public void save(CrmFollow crmFollow) {
		super.save(crmFollow);
	}
	
	@Transactional(readOnly = false)
	public void delete(CrmFollow crmFollow) {
		super.delete(crmFollow);
	}
	
}