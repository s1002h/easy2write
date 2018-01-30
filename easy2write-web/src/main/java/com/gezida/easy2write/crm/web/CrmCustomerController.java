/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.crm.web;

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
import com.gezida.easy2write.crm.bean.CrmCustomer;
import com.gezida.easy2write.crm.service.CrmCustomerService;

/**
 * 关于CrmCustomer用户表的Controller
 * @author Tangbinqi
 * @version 2017-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/crm/crmCustomer")
public class CrmCustomerController extends BaseController {

	@Autowired
	private CrmCustomerService crmCustomerService;
	
	@ModelAttribute
	public CrmCustomer get(@RequestParam(required=false) String id) {
		CrmCustomer entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = crmCustomerService.get(id);
		}
		if (entity == null){
			entity = new CrmCustomer();
		}
		return entity;
	}
	
	@RequiresPermissions("crm:crmCustomer:view")
	@RequestMapping(value = {"list", ""})
	public String list(CrmCustomer crmCustomer, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CrmCustomer> page = crmCustomerService.findPage(new Page<CrmCustomer>(request, response), crmCustomer); 
		model.addAttribute("page", page);
		return "easy2write/crm/crmCustomerList";
	}

	@RequiresPermissions("crm:crmCustomer:view")
	@RequestMapping(value = "form")
	public String form(CrmCustomer crmCustomer, Model model) {
		model.addAttribute("crmCustomer", crmCustomer);
		return "easy2write/crm/crmCustomerForm";
	}

	@RequiresPermissions("crm:crmCustomer:edit")
	@RequestMapping(value = "save")
	public String save(CrmCustomer crmCustomer, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, crmCustomer)){
			return form(crmCustomer, model);
		}
		crmCustomerService.save(crmCustomer);
		addMessage(redirectAttributes, "保存CrmCustomer用户表成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmCustomer/?repage";
	}
	
	@RequiresPermissions("crm:crmCustomer:edit")
	@RequestMapping(value = "delete")
	public String delete(CrmCustomer crmCustomer, RedirectAttributes redirectAttributes) {
		crmCustomerService.delete(crmCustomer);
		addMessage(redirectAttributes, "删除CrmCustomer用户表成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmCustomer/?repage";
	}

}