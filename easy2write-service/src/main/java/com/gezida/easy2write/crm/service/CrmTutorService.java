/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.crm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezida.easy2write.common.persistence.Page;
import com.gezida.easy2write.common.service.CrudService;
import com.gezida.easy2write.crm.bean.CrmTutor;
import com.gezida.easy2write.crm.dao.CrmTutorDao;

/**
 * 关于CrmTutor导师的Service
 * @author Tangbinqi
 * @version 2017-08-15
 */
@Service
@Transactional(readOnly = true)
public class CrmTutorService extends CrudService<CrmTutorDao, CrmTutor> {

	public CrmTutor get(String id) {
		return super.get(id);
	}
	
	public List<CrmTutor> findList(CrmTutor crmTutor) {
		return super.findList(crmTutor);
	}
	
	public Page<CrmTutor> findPage(Page<CrmTutor> page, CrmTutor crmTutor) {
		return super.findPage(page, crmTutor);
	}
	
	@Transactional(readOnly = false)
	public void save(CrmTutor crmTutor) {
		super.save(crmTutor);
	}
	
	@Transactional(readOnly = false)
	public void delete(CrmTutor crmTutor) {
		super.delete(crmTutor);
	}
	
}