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
import com.gezida.easy2write.account.bean.AccountFree;
import com.gezida.easy2write.account.service.AccountFreeService;

/**
 * 关于AccountFree免费额度获取记录表的Controller
 * @author Tangbinqi
 * @version 2017-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/account/accountFree")
public class AccountFreeController extends BaseController {

	@Autowired
	private AccountFreeService accountFreeService;
	
	@ModelAttribute
	public AccountFree get(@RequestParam(required=false) String id) {
		AccountFree entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = accountFreeService.get(id);
		}
		if (entity == null){
			entity = new AccountFree();
		}
		return entity;
	}
	
	@RequiresPermissions("account:accountFree:view")
	@RequestMapping(value = {"list", ""})
	public String list(AccountFree accountFree, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AccountFree> page = accountFreeService.findPage(new Page<AccountFree>(request, response), accountFree); 
		model.addAttribute("page", page);
		return "easy2write/account/accountFreeList";
	}

	@RequiresPermissions("account:accountFree:view")
	@RequestMapping(value = "form")
	public String form(AccountFree accountFree, Model model) {
		model.addAttribute("accountFree", accountFree);
		return "easy2write/account/accountFreeForm";
	}

	@RequiresPermissions("account:accountFree:edit")
	@RequestMapping(value = "save")
	public String save(AccountFree accountFree, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, accountFree)){
			return form(accountFree, model);
		}
		accountFreeService.save(accountFree);
		addMessage(redirectAttributes, "保存AccountFree免费额度获取记录表成功");
		return "redirect:"+Global.getAdminPath()+"/account/accountFree/?repage";
	}
	
	@RequiresPermissions("account:accountFree:edit")
	@RequestMapping(value = "delete")
	public String delete(AccountFree accountFree, RedirectAttributes redirectAttributes) {
		accountFreeService.delete(accountFree);
		addMessage(redirectAttributes, "删除AccountFree免费额度获取记录表成功");
		return "redirect:"+Global.getAdminPath()+"/account/accountFree/?repage";
	}

}