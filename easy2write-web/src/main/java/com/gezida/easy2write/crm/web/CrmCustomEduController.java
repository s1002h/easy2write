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
import com.gezida.easy2write.crm.bean.CrmCustomEdu;
import com.gezida.easy2write.crm.service.CrmCustomEduService;

/**
 * 关于CrmCustomEdu用户教育情况记录表的Controller
 * @author Tangbinqi
 * @version 2017-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/crm/crmCustomEdu")
public class CrmCustomEduController extends BaseController {

	@Autowired
	private CrmCustomEduService crmCustomEduService;
	
	@ModelAttribute
	public CrmCustomEdu get(@RequestParam(required=false) String id) {
		CrmCustomEdu entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = crmCustomEduService.get(id);
		}
		if (entity == null){
			entity = new CrmCustomEdu();
		}
		return entity;
	}
	
	@RequiresPermissions("crm:crmCustomEdu:view")
	@RequestMapping(value = {"list", ""})
	public String list(CrmCustomEdu crmCustomEdu, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CrmCustomEdu> page = crmCustomEduService.findPage(new Page<CrmCustomEdu>(request, response), crmCustomEdu); 
		model.addAttribute("page", page);
		return "easy2write/crm/crmCustomEduList";
	}

	@RequiresPermissions("crm:crmCustomEdu:view")
	@RequestMapping(value = "form")
	public String form(CrmCustomEdu crmCustomEdu, Model model) {
		model.addAttribute("crmCustomEdu", crmCustomEdu);
		return "easy2write/crm/crmCustomEduForm";
	}

	@RequiresPermissions("crm:crmCustomEdu:edit")
	@RequestMapping(value = "save")
	public String save(CrmCustomEdu crmCustomEdu, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, crmCustomEdu)){
			return form(crmCustomEdu, model);
		}
		crmCustomEduService.save(crmCustomEdu);
		addMessage(redirectAttributes, "保存CrmCustomEdu用户教育情况记录表成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmCustomEdu/?repage";
	}
	
	@RequiresPermissions("crm:crmCustomEdu:edit")
	@RequestMapping(value = "delete")
	public String delete(CrmCustomEdu crmCustomEdu, RedirectAttributes redirectAttributes) {
		crmCustomEduService.delete(crmCustomEdu);
		addMessage(redirectAttributes, "删除CrmCustomEdu用户教育情况记录表成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmCustomEdu/?repage";
	}

}