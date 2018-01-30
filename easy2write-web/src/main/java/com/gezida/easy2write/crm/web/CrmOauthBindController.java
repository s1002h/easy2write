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
import com.gezida.easy2write.crm.bean.CrmOauthBind;
import com.gezida.easy2write.crm.service.CrmOauthBindService;

/**
 * 关于CrmOauthBind第三方登录绑定的Controller
 * @author Tangbinqi
 * @version 2017-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/crm/crmOauthBind")
public class CrmOauthBindController extends BaseController {

	@Autowired
	private CrmOauthBindService crmOauthBindService;
	
	@ModelAttribute
	public CrmOauthBind get(@RequestParam(required=false) String id) {
		CrmOauthBind entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = crmOauthBindService.get(id);
		}
		if (entity == null){
			entity = new CrmOauthBind();
		}
		return entity;
	}
	
	@RequiresPermissions("crm:crmOauthBind:view")
	@RequestMapping(value = {"list", ""})
	public String list(CrmOauthBind crmOauthBind, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CrmOauthBind> page = crmOauthBindService.findPage(new Page<CrmOauthBind>(request, response), crmOauthBind); 
		model.addAttribute("page", page);
		return "easy2write/crm/crmOauthBindList";
	}

	@RequiresPermissions("crm:crmOauthBind:view")
	@RequestMapping(value = "form")
	public String form(CrmOauthBind crmOauthBind, Model model) {
		model.addAttribute("crmOauthBind", crmOauthBind);
		return "easy2write/crm/crmOauthBindForm";
	}

	@RequiresPermissions("crm:crmOauthBind:edit")
	@RequestMapping(value = "save")
	public String save(CrmOauthBind crmOauthBind, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, crmOauthBind)){
			return form(crmOauthBind, model);
		}
		crmOauthBindService.save(crmOauthBind);
		addMessage(redirectAttributes, "保存CrmOauthBind第三方登录绑定成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmOauthBind/?repage";
	}
	
	@RequiresPermissions("crm:crmOauthBind:edit")
	@RequestMapping(value = "delete")
	public String delete(CrmOauthBind crmOauthBind, RedirectAttributes redirectAttributes) {
		crmOauthBindService.delete(crmOauthBind);
		addMessage(redirectAttributes, "删除CrmOauthBind第三方登录绑定成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmOauthBind/?repage";
	}

}