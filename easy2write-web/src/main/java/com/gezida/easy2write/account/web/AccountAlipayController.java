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
import com.gezida.easy2write.account.bean.AccountAlipay;
import com.gezida.easy2write.account.service.AccountAlipayService;

/**
 * 关于AccountAlipay绑定支付宝的Controller
 * @author Tangbinqi
 * @version 2017-08-10
 */
@Controller
//@RequestMapping(value = "${adminPath}/account/accountAlipay")
@RequestMapping(value = "${adminPath}/account/accountAlipay")
public class AccountAlipayController extends BaseController {

	@Autowired
	private AccountAlipayService accountAlipayService;
	
	@ModelAttribute
	public AccountAlipay get(@RequestParam(required=false) String id) {
		AccountAlipay entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = accountAlipayService.get(id);
		}
		if (entity == null){
			entity = new AccountAlipay();
		}
		return entity;
	}
	
	@RequiresPermissions("account:accountAlipay:view")
	@RequestMapping(value = {"list", ""})
	public String list(AccountAlipay accountAlipay, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AccountAlipay> page = accountAlipayService.findPage(new Page<AccountAlipay>(request, response), accountAlipay); 
		model.addAttribute("page", page);
		return "easy2write/account/accountAlipayList";
	}

	@RequiresPermissions("account:accountAlipay:view")
	@RequestMapping(value = "form")
	public String form(AccountAlipay accountAlipay, Model model) {
		model.addAttribute("accountAlipay", accountAlipay);
		return "easy2write/account/accountAlipayForm";
	}

	@RequiresPermissions("account:accountAlipay:edit")
	@RequestMapping(value = "save")
	public String save(AccountAlipay accountAlipay, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, accountAlipay)){
			return form(accountAlipay, model);
		}
		accountAlipayService.save(accountAlipay);
		addMessage(redirectAttributes, "保存AccountAlipay绑定支付宝成功");
		return "redirect:"+Global.getAdminPath()+"/account/accountAlipay/?repage";
	}
	
	@RequiresPermissions("account:accountAlipay:edit")
	@RequestMapping(value = "delete")
	public String delete(AccountAlipay accountAlipay, RedirectAttributes redirectAttributes) {
		accountAlipayService.delete(accountAlipay);
		addMessage(redirectAttributes, "删除AccountAlipay绑定支付宝成功");
		return "redirect:"+Global.getAdminPath()+"/account/accountAlipay/?repage";
	}

}