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
import com.gezida.easy2write.crm.bean.CrmFollow;
import com.gezida.easy2write.crm.service.CrmFollowService;

/**
 * 关于CrmFollow用户关注表的Controller
 * @author Tangbinqi
 * @version 2017-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/crm/crmFollow")
public class CrmFollowController extends BaseController {

	@Autowired
	private CrmFollowService crmFollowService;
	
	@ModelAttribute
	public CrmFollow get(@RequestParam(required=false) String id) {
		CrmFollow entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = crmFollowService.get(id);
		}
		if (entity == null){
			entity = new CrmFollow();
		}
		return entity;
	}
	
	@RequiresPermissions("crm:crmFollow:view")
	@RequestMapping(value = {"list", ""})
	public String list(CrmFollow crmFollow, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CrmFollow> page = crmFollowService.findPage(new Page<CrmFollow>(request, response), crmFollow); 
		model.addAttribute("page", page);
		return "easy2write/crm/crmFollowList";
	}

	@RequiresPermissions("crm:crmFollow:view")
	@RequestMapping(value = "form")
	public String form(CrmFollow crmFollow, Model model) {
		model.addAttribute("crmFollow", crmFollow);
		return "easy2write/crm/crmFollowForm";
	}

	@RequiresPermissions("crm:crmFollow:edit")
	@RequestMapping(value = "save")
	public String save(CrmFollow crmFollow, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, crmFollow)){
			return form(crmFollow, model);
		}
		crmFollowService.save(crmFollow);
		addMessage(redirectAttributes, "保存CrmFollow用户关注表成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmFollow/?repage";
	}
	
	@RequiresPermissions("crm:crmFollow:edit")
	@RequestMapping(value = "delete")
	public String delete(CrmFollow crmFollow, RedirectAttributes redirectAttributes) {
		crmFollowService.delete(crmFollow);
		addMessage(redirectAttributes, "删除CrmFollow用户关注表成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmFollow/?repage";
	}

}