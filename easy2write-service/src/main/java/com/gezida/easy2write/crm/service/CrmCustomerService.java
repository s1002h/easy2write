/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.crm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezida.easy2write.common.persistence.Page;
import com.gezida.easy2write.common.service.CrudService;
import com.gezida.easy2write.crm.bean.CrmCustomer;
import com.gezida.easy2write.crm.dao.CrmCustomerDao;

/**
 * 关于CrmCustomer用户表的Service
 * @author Tangbinqi
 * @version 2017-08-15
 */
@Service
@Transactional(readOnly = true)
public class CrmCustomerService extends CrudService<CrmCustomerDao, CrmCustomer> {

	public CrmCustomer get(String id) {
		return super.get(id);
	}
	
	public List<CrmCustomer> findList(CrmCustomer crmCustomer) {
		return super.findList(crmCustomer);
	}
	
	public Page<CrmCustomer> findPage(Page<CrmCustomer> page, CrmCustomer crmCustomer) {
		return super.findPage(page, crmCustomer);
	}
	
	@Transactional(readOnly = false)
	public void save(CrmCustomer crmCustomer) {
		super.save(crmCustomer);
	}
	
	@Transactional(readOnly = false)
	public void delete(CrmCustomer crmCustomer) {
		super.delete(crmCustomer);
	}
	
}