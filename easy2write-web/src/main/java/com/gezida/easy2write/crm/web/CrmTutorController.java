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
import com.gezida.easy2write.crm.bean.CrmTutor;
import com.gezida.easy2write.crm.service.CrmTutorService;

/**
 * 关于CrmTutor导师的Controller
 * @author Tangbinqi
 * @version 2017-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/crm/crmTutor")
public class CrmTutorController extends BaseController {

	@Autowired
	private CrmTutorService crmTutorService;
	
	@ModelAttribute
	public CrmTutor get(@RequestParam(required=false) String id) {
		CrmTutor entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = crmTutorService.get(id);
		}
		if (entity == null){
			entity = new CrmTutor();
		}
		return entity;
	}
	
	@RequiresPermissions("crm:crmTutor:view")
	@RequestMapping(value = {"list", ""})
	public String list(CrmTutor crmTutor, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CrmTutor> page = crmTutorService.findPage(new Page<CrmTutor>(request, response), crmTutor); 
		model.addAttribute("page", page);
		return "easy2write/crm/crmTutorList";
	}

	@RequiresPermissions("crm:crmTutor:view")
	@RequestMapping(value = "form")
	public String form(CrmTutor crmTutor, Model model) {
		model.addAttribute("crmTutor", crmTutor);
		return "easy2write/crm/crmTutorForm";
	}

	@RequiresPermissions("crm:crmTutor:edit")
	@RequestMapping(value = "save")
	public String save(CrmTutor crmTutor, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, crmTutor)){
			return form(crmTutor, model);
		}
		crmTutorService.save(crmTutor);
		addMessage(redirectAttributes, "保存CrmTutor导师成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmTutor/?repage";
	}
	
	@RequiresPermissions("crm:crmTutor:edit")
	@RequestMapping(value = "delete")
	public String delete(CrmTutor crmTutor, RedirectAttributes redirectAttributes) {
		crmTutorService.delete(crmTutor);
		addMessage(redirectAttributes, "删除CrmTutor导师成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmTutor/?repage";
	}

}