/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.account.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezida.easy2write.common.persistence.Page;
import com.gezida.easy2write.common.service.CrudService;
import com.gezida.easy2write.account.bean.AccountWithdraw;
import com.gezida.easy2write.account.dao.AccountWithdrawDao;

/**
 * 关于AccountWithdraw账户提现记录表的Service
 * @author Tangbinqi
 * @version 2017-08-15
 */
@Service
@Transactional(readOnly = true)
public class AccountWithdrawService extends CrudService<AccountWithdrawDao, AccountWithdraw> {

	public AccountWithdraw get(String id) {
		return super.get(id);
	}
	
	public List<AccountWithdraw> findList(AccountWithdraw accountWithdraw) {
		return super.findList(accountWithdraw);
	}
	
	public Page<AccountWithdraw> findPage(Page<AccountWithdraw> page, AccountWithdraw accountWithdraw) {
		return super.findPage(page, accountWithdraw);
	}
	
	@Transactional(readOnly = false)
	public void save(AccountWithdraw accountWithdraw) {
		super.save(accountWithdraw);
	}
	
	@Transactional(readOnly = false)
	public void delete(AccountWithdraw accountWithdraw) {
		super.delete(accountWithdraw);
	}
	
}