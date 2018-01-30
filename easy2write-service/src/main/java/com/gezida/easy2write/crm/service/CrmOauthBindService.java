/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.crm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezida.easy2write.common.persistence.Page;
import com.gezida.easy2write.common.service.CrudService;
import com.gezida.easy2write.crm.bean.CrmOauthBind;
import com.gezida.easy2write.crm.dao.CrmOauthBindDao;

/**
 * 关于CrmOauthBind第三方登录绑定的Service
 * @author Tangbinqi
 * @version 2017-08-15
 */
@Service
@Transactional(readOnly = true)
public class CrmOauthBindService extends CrudService<CrmOauthBindDao, CrmOauthBind> {

	public CrmOauthBind get(String id) {
		return super.get(id);
	}
	
	public List<CrmOauthBind> findList(CrmOauthBind crmOauthBind) {
		return super.findList(crmOauthBind);
	}
	
	public Page<CrmOauthBind> findPage(Page<CrmOauthBind> page, CrmOauthBind crmOauthBind) {
		return super.findPage(page, crmOauthBind);
	}
	
	@Transactional(readOnly = false)
	public void save(CrmOauthBind crmOauthBind) {
		super.save(crmOauthBind);
	}
	
	@Transactional(readOnly = false)
	public void delete(CrmOauthBind crmOauthBind) {
		super.delete(crmOauthBind);
	}
	
}