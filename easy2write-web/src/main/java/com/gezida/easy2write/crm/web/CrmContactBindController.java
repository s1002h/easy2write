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
import com.gezida.easy2write.crm.bean.CrmContactBind;
import com.gezida.easy2write.crm.service.CrmContactBindService;

/**
 * 关于CrmContactBind联系方式绑定的Controller
 * @author Tangbinqi
 * @version 2017-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/crm/crmContactBind")
public class CrmContactBindController extends BaseController {

	@Autowired
	private CrmContactBindService crmContactBindService;
	
	@ModelAttribute
	public CrmContactBind get(@RequestParam(required=false) String id) {
		CrmContactBind entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = crmContactBindService.get(id);
		}
		if (entity == null){
			entity = new CrmContactBind();
		}
		return entity;
	}
	
	@RequiresPermissions("crm:crmContactBind:view")
	@RequestMapping(value = {"list", ""})
	public String list(CrmContactBind crmContactBind, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CrmContactBind> page = crmContactBindService.findPage(new Page<CrmContactBind>(request, response), crmContactBind); 
		model.addAttribute("page", page);
		return "easy2write/crm/crmContactBindList";
	}

	@RequiresPermissions("crm:crmContactBind:view")
	@RequestMapping(value = "form")
	public String form(CrmContactBind crmContactBind, Model model) {
		model.addAttribute("crmContactBind", crmContactBind);
		return "easy2write/crm/crmContactBindForm";
	}

	@RequiresPermissions("crm:crmContactBind:edit")
	@RequestMapping(value = "save")
	public String save(CrmContactBind crmContactBind, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, crmContactBind)){
			return form(crmContactBind, model);
		}
		crmContactBindService.save(crmContactBind);
		addMessage(redirectAttributes, "保存CrmContactBind联系方式绑定成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmContactBind/?repage";
	}
	
	@RequiresPermissions("crm:crmContactBind:edit")
	@RequestMapping(value = "delete")
	public String delete(CrmContactBind crmContactBind, RedirectAttributes redirectAttributes) {
		crmContactBindService.delete(crmContactBind);
		addMessage(redirectAttributes, "删除CrmContactBind联系方式绑定成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmContactBind/?repage";
	}

}