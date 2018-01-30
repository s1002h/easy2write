/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.account.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezida.easy2write.common.persistence.Page;
import com.gezida.easy2write.common.service.CrudService;
import com.gezida.easy2write.account.bean.AccountFree;
import com.gezida.easy2write.account.dao.AccountFreeDao;

/**
 * 关于AccountFree免费额度获取记录表的Service
 * @author Tangbinqi
 * @version 2017-08-15
 */
@Service
@Transactional(readOnly = true)
public class AccountFreeService extends CrudService<AccountFreeDao, AccountFree> {

	public AccountFree get(String id) {
		return super.get(id);
	}
	
	public List<AccountFree> findList(AccountFree accountFree) {
		return super.findList(accountFree);
	}
	
	public Page<AccountFree> findPage(Page<AccountFree> page, AccountFree accountFree) {
		return super.findPage(page, accountFree);
	}
	
	@Transactional(readOnly = false)
	public void save(AccountFree accountFree) {
		super.save(accountFree);
	}
	
	@Transactional(readOnly = false)
	public void delete(AccountFree accountFree) {
		super.delete(accountFree);
	}
	
}