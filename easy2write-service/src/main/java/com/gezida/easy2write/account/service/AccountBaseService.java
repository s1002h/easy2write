/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.account.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezida.easy2write.common.persistence.Page;
import com.gezida.easy2write.common.service.CrudService;
import com.gezida.easy2write.account.bean.AccountBase;
import com.gezida.easy2write.account.dao.AccountBaseDao;

/**
 * 关于AccountBase账户额度表的Service
 * @author Tangbinqi
 * @version 2017-08-15
 */
@Service
@Transactional(readOnly = true)
public class AccountBaseService extends CrudService<AccountBaseDao, AccountBase> {

	public AccountBase get(String id) {
		return super.get(id);
	}
	
	public List<AccountBase> findList(AccountBase accountBase) {
		return super.findList(accountBase);
	}
	
	public Page<AccountBase> findPage(Page<AccountBase> page, AccountBase accountBase) {
		return super.findPage(page, accountBase);
	}
	
	@Transactional(readOnly = false)
	public void save(AccountBase accountBase) {
		super.save(accountBase);
	}
	
	@Transactional(readOnly = false)
	public void delete(AccountBase accountBase) {
		super.delete(accountBase);
	}
	
}