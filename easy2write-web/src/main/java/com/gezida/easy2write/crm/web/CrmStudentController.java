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
import com.gezida.easy2write.crm.bean.CrmStudent;
import com.gezida.easy2write.crm.service.CrmStudentService;

/**
 * 关于CrmStudent学生信息的Controller
 * @author Tangbinqi
 * @version 2017-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/crm/crmStudent")
public class CrmStudentController extends BaseController {

	@Autowired
	private CrmStudentService crmStudentService;
	
	@ModelAttribute
	public CrmStudent get(@RequestParam(required=false) String id) {
		CrmStudent entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = crmStudentService.get(id);
		}
		if (entity == null){
			entity = new CrmStudent();
		}
		return entity;
	}
	
	@RequiresPermissions("crm:crmStudent:view")
	@RequestMapping(value = {"list", ""})
	public String list(CrmStudent crmStudent, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CrmStudent> page = crmStudentService.findPage(new Page<CrmStudent>(request, response), crmStudent); 
		model.addAttribute("page", page);
		return "easy2write/crm/crmStudentList";
	}

	@RequiresPermissions("crm:crmStudent:view")
	@RequestMapping(value = "form")
	public String form(CrmStudent crmStudent, Model model) {
		model.addAttribute("crmStudent", crmStudent);
		return "easy2write/crm/crmStudentForm";
	}

	@RequiresPermissions("crm:crmStudent:edit")
	@RequestMapping(value = "save")
	public String save(CrmStudent crmStudent, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, crmStudent)){
			return form(crmStudent, model);
		}
		crmStudentService.save(crmStudent);
		addMessage(redirectAttributes, "保存CrmStudent学生信息成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmStudent/?repage";
	}
	
	@RequiresPermissions("crm:crmStudent:edit")
	@RequestMapping(value = "delete")
	public String delete(CrmStudent crmStudent, RedirectAttributes redirectAttributes) {
		crmStudentService.delete(crmStudent);
		addMessage(redirectAttributes, "删除CrmStudent学生信息成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmStudent/?repage";
	}

}