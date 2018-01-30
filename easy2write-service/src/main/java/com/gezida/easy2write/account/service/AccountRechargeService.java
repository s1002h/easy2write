/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.account.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezida.easy2write.common.persistence.Page;
import com.gezida.easy2write.common.service.CrudService;
import com.gezida.easy2write.account.bean.AccountRecharge;
import com.gezida.easy2write.account.dao.AccountRechargeDao;

/**
 * 关于AccountRecharge充值记录表的Service
 * @author Tangbinqi
 * @version 2017-08-15
 */
@Service
@Transactional(readOnly = true)
public class AccountRechargeService extends CrudService<AccountRechargeDao, AccountRecharge> {

	public AccountRecharge get(String id) {
		return super.get(id);
	}
	
	public List<AccountRecharge> findList(AccountRecharge accountRecharge) {
		return super.findList(accountRecharge);
	}
	
	public Page<AccountRecharge> findPage(Page<AccountRecharge> page, AccountRecharge accountRecharge) {
		return super.findPage(page, accountRecharge);
	}
	
	@Transactional(readOnly = false)
	public void save(AccountRecharge accountRecharge) {
		super.save(accountRecharge);
	}
	
	@Transactional(readOnly = false)
	public void delete(AccountRecharge accountRecharge) {
		super.delete(accountRecharge);
	}
	
}