/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.crm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezida.easy2write.common.persistence.Page;
import com.gezida.easy2write.common.service.CrudService;
import com.gezida.easy2write.crm.bean.CrmCustomEdu;
import com.gezida.easy2write.crm.dao.CrmCustomEduDao;

/**
 * 关于CrmCustomEdu用户教育情况记录表的Service
 * @author Tangbinqi
 * @version 2017-08-15
 */
@Service
@Transactional(readOnly = true)
public class CrmCustomEduService extends CrudService<CrmCustomEduDao, CrmCustomEdu> {

	public CrmCustomEdu get(String id) {
		return super.get(id);
	}
	
	public List<CrmCustomEdu> findList(CrmCustomEdu crmCustomEdu) {
		return super.findList(crmCustomEdu);
	}
	
	public Page<CrmCustomEdu> findPage(Page<CrmCustomEdu> page, CrmCustomEdu crmCustomEdu) {
		return super.findPage(page, crmCustomEdu);
	}
	
	@Transactional(readOnly = false)
	public void save(CrmCustomEdu crmCustomEdu) {
		super.save(crmCustomEdu);
	}
	
	@Transactional(readOnly = false)
	public void delete(CrmCustomEdu crmCustomEdu) {
		super.delete(crmCustomEdu);
	}
	
}