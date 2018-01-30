/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.crm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezida.easy2write.common.persistence.Page;
import com.gezida.easy2write.common.service.CrudService;
import com.gezida.easy2write.crm.bean.CrmStudent;
import com.gezida.easy2write.crm.dao.CrmStudentDao;

/**
 * 关于CrmStudent学生信息的Service
 * @author Tangbinqi
 * @version 2017-08-15
 */
@Service
@Transactional(readOnly = true)
public class CrmStudentService extends CrudService<CrmStudentDao, CrmStudent> {

	public CrmStudent get(String id) {
		return super.get(id);
	}
	
	public List<CrmStudent> findList(CrmStudent crmStudent) {
		return super.findList(crmStudent);
	}
	
	public Page<CrmStudent> findPage(Page<CrmStudent> page, CrmStudent crmStudent) {
		return super.findPage(page, crmStudent);
	}
	
	@Transactional(readOnly = false)
	public void save(CrmStudent crmStudent) {
		super.save(crmStudent);
	}
	
	@Transactional(readOnly = false)
	public void delete(CrmStudent crmStudent) {
		super.delete(crmStudent);
	}
	
}