/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.crm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezida.easy2write.common.persistence.Page;
import com.gezida.easy2write.common.service.CrudService;
import com.gezida.easy2write.crm.bean.CrmContactBind;
import com.gezida.easy2write.crm.dao.CrmContactBindDao;

/**
 * 关于CrmContactBind联系方式绑定的Service
 * @author Tangbinqi
 * @version 2017-08-15
 */
@Service
@Transactional(readOnly = true)
public class CrmContactBindService extends CrudService<CrmContactBindDao, CrmContactBind> {

	public CrmContactBind get(String id) {
		return super.get(id);
	}
	
	public List<CrmContactBind> findList(CrmContactBind crmContactBind) {
		return super.findList(crmContactBind);
	}
	
	public Page<CrmContactBind> findPage(Page<CrmContactBind> page, CrmContactBind crmContactBind) {
		return super.findPage(page, crmContactBind);
	}
	
	@Transactional(readOnly = false)
	public void save(CrmContactBind crmContactBind) {
		super.save(crmContactBind);
	}
	
	@Transactional(readOnly = false)
	public void delete(CrmContactBind crmContactBind) {
		super.delete(crmContactBind);
	}
	
}