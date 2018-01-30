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
import com.gezida.easy2write.account.bean.AccountRecharge;
import com.gezida.easy2write.account.service.AccountRechargeService;

/**
 * 关于AccountRecharge充值记录表的Controller
 * @author Tangbinqi
 * @version 2017-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/account/accountRecharge")
public class AccountRechargeController extends BaseController {

	@Autowired
	private AccountRechargeService accountRechargeService;
	
	@ModelAttribute
	public AccountRecharge get(@RequestParam(required=false) String id) {
		AccountRecharge entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = accountRechargeService.get(id);
		}
		if (entity == null){
			entity = new AccountRecharge();
		}
		return entity;
	}
	
	@RequiresPermissions("account:accountRecharge:view")
	@RequestMapping(value = {"list", ""})
	public String list(AccountRecharge accountRecharge, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AccountRecharge> page = accountRechargeService.findPage(new Page<AccountRecharge>(request, response), accountRecharge); 
		model.addAttribute("page", page);
		return "easy2write/account/accountRechargeList";
	}

	@RequiresPermissions("account:accountRecharge:view")
	@RequestMapping(value = "form")
	public String form(AccountRecharge accountRecharge, Model model) {
		model.addAttribute("accountRecharge", accountRecharge);
		return "easy2write/account/accountRechargeForm";
	}

	@RequiresPermissions("account:accountRecharge:edit")
	@RequestMapping(value = "save")
	public String save(AccountRecharge accountRecharge, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, accountRecharge)){
			return form(accountRecharge, model);
		}
		accountRechargeService.save(accountRecharge);
		addMessage(redirectAttributes, "保存AccountRecharge充值记录表成功");
		return "redirect:"+Global.getAdminPath()+"/account/accountRecharge/?repage";
	}
	
	@RequiresPermissions("account:accountRecharge:edit")
	@RequestMapping(value = "delete")
	public String delete(AccountRecharge accountRecharge, RedirectAttributes redirectAttributes) {
		accountRechargeService.delete(accountRecharge);
		addMessage(redirectAttributes, "删除AccountRecharge充值记录表成功");
		return "redirect:"+Global.getAdminPath()+"/account/accountRecharge/?repage";
	}

}