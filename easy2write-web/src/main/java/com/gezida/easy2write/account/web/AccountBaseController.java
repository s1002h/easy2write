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
import com.gezida.easy2write.account.bean.AccountBase;
import com.gezida.easy2write.account.service.AccountBaseService;

/**
 * 关于AccountBase账户额度表的Controller
 * @author Tangbinqi
 * @version 2017-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/account/accountBase")
public class AccountBaseController extends BaseController {

	@Autowired
	private AccountBaseService accountBaseService;
	
	@ModelAttribute
	public AccountBase get(@RequestParam(required=false) String id) {
		AccountBase entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = accountBaseService.get(id);
		}
		if (entity == null){
			entity = new AccountBase();
		}
		return entity;
	}
	
	@RequestMapping(value = {"index"})
	public String testIndex(){
		return "easy2write/account/index";
	}
	
	@RequiresPermissions("account:accountBase:view")
	@RequestMapping(value = {"list", ""})
	public String list(AccountBase accountBase, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AccountBase> page = accountBaseService.findPage(new Page<AccountBase>(request, response), accountBase); 
		model.addAttribute("page", page);
		return "easy2write/account/accountBaseList";
	}

	@RequiresPermissions("account:accountBase:view")
	@RequestMapping(value = "form")
	public String form(AccountBase accountBase, Model model) {
		model.addAttribute("accountBase", accountBase);
		return "easy2write/account/accountBaseForm";
	}

	@RequiresPermissions("account:accountBase:edit")
	@RequestMapping(value = "save")
	public String save(AccountBase accountBase, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, accountBase)){
			return form(accountBase, model);
		}
		accountBaseService.save(accountBase);
		addMessage(redirectAttributes, "保存AccountBase账户额度表成功");
		return "redirect:"+Global.getAdminPath()+"/account/accountBase/?repage";
	}
	
	@RequiresPermissions("account:accountBase:edit")
	@RequestMapping(value = "delete")
	public String delete(AccountBase accountBase, RedirectAttributes redirectAttributes) {
		accountBaseService.delete(accountBase);
		addMessage(redirectAttributes, "删除AccountBase账户额度表成功");
		return "redirect:"+Global.getAdminPath()+"/account/accountBase/?repage";
	}

}