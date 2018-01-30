/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.account.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gezida.easy2write.common.persistence.Page;
import com.gezida.easy2write.common.service.CrudService;
import com.gezida.easy2write.account.bean.AccountAlipay;
import com.gezida.easy2write.account.dao.AccountAlipayDao;

/**
 * 关于AccountAlipay绑定支付宝的Service
 * @author Tangbinqi
 * @version 2017-08-15
 */
@Service
@Transactional(readOnly = true)
public class AccountAlipayService extends CrudService<AccountAlipayDao, AccountAlipay> {

	public AccountAlipay get(String id) {
		return super.get(id);
	}
	
	public List<AccountAlipay> findList(AccountAlipay accountAlipay) {
		return super.findList(accountAlipay);
	}
	
	public Page<AccountAlipay> findPage(Page<AccountAlipay> page, AccountAlipay accountAlipay) {
		return super.findPage(page, accountAlipay);
	}
	
	@Transactional(readOnly = false)
	public void save(AccountAlipay accountAlipay) {
		super.save(accountAlipay);
	}
	
	@Transactional(readOnly = false)
	public void delete(AccountAlipay accountAlipay) {
		super.delete(accountAlipay);
	}
	
}