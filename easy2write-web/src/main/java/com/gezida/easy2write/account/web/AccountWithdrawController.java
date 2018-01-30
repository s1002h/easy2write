/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.account.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gezida.easy2write.common.config.Global;
import com.gezida.easy2write.common.persistence.Page;
import com.gezida.easy2write.common.web.BaseController;
import com.gezida.easy2write.common.utils.StringUtils;
import com.gezida.easy2write.account.bean.AccountWithdraw;
import com.gezida.easy2write.account.service.AccountWithdrawService;

/**
 * 关于AccountWithdraw账户提现记录表的Controller
 * @author Tangbinqi
 * @version 2017-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/account/accountWithdraw")
public class AccountWithdrawController extends BaseController {

	@Autowired
	private AccountWithdrawService accountWithdrawService;
	
	@ModelAttribute
	public AccountWithdraw get(@RequestParam(required=false) String id) {
		AccountWithdraw entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = accountWithdrawService.get(id);
		}
		if (entity == null){
			entity = new AccountWithdraw();
		}
		return entity;
	}
	
	@RequiresPermissions("account:accountWithdraw:view")
	@RequestMapping(value = {"list", ""})
	public String list(AccountWithdraw accountWithdraw, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AccountWithdraw> page = accountWithdrawService.findPage(new Page<AccountWithdraw>(request, response), accountWithdraw); 
		model.addAttribute("page", page);
		return "easy2write/account/accountWithdrawList";
	}

	@RequiresPermissions("account:accountWithdraw:view")
	@RequestMapping(value = "form")
	public String form(AccountWithdraw accountWithdraw, Model model) {
		model.addAttribute("accountWithdraw", accountWithdraw);
		return "easy2write/account/accountWithdrawForm";
	}

	@RequiresPermissions("account:accountWithdraw:edit")
	@RequestMapping(value = "save")
	public String save(AccountWithdraw accountWithdraw, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, accountWithdraw)){
			return form(accountWithdraw, model);
		}
		accountWithdrawService.save(accountWithdraw);
		addMessage(redirectAttributes, "保存AccountWithdraw账户提现记录表成功");
		return "redirect:"+Global.getAdminPath()+"/account/accountWithdraw/?repage";
	}
	
	@RequiresPermissions("account:accountWithdraw:edit")
	@RequestMapping(value = "delete")
	public String delete(AccountWithdraw accountWithdraw, RedirectAttributes redirectAttributes) {
		accountWithdrawService.delete(accountWithdraw);
		addMessage(redirectAttributes, "删除AccountWithdraw账户提现记录表成功");
		return "redirect:"+Global.getAdminPath()+"/account/accountWithdraw/?repage";
	}

}