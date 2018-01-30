/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.common.web;

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
import com.gezida.easy2write.common.bean.CommonParameter;
import com.gezida.easy2write.common.service.CommonParameterService;

/**
 * 关于CommonParameter系统参数表的Controller
 * @author Tangbinqi
 * @version 2017-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/common/commonParameter")
public class CommonParameterController extends BaseController {

	@Autowired
	private CommonParameterService commonParameterService;
	
	@ModelAttribute
	public CommonParameter get(@RequestParam(required=false) String id) {
		CommonParameter entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = commonParameterService.get(id);
		}
		if (entity == null){
			entity = new CommonParameter();
		}
		return entity;
	}
	
	@RequiresPermissions("common:commonParameter:view")
	@RequestMapping(value = {"list", ""})
	public String list(CommonParameter commonParameter, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CommonParameter> page = commonParameterService.findPage(new Page<CommonParameter>(request, response), commonParameter); 
		model.addAttribute("page", page);
		return "easy2write/common/commonParameterList";
	}

	@RequiresPermissions("common:commonParameter:view")
	@RequestMapping(value = "form")
	public String form(CommonParameter commonParameter, Model model) {
		model.addAttribute("commonParameter", commonParameter);
		return "easy2write/common/commonParameterForm";
	}

	@RequiresPermissions("common:commonParameter:edit")
	@RequestMapping(value = "save")
	public String save(CommonParameter commonParameter, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, commonParameter)){
			return form(commonParameter, model);
		}
		commonParameterService.save(commonParameter);
		addMessage(redirectAttributes, "保存CommonParameter系统参数表成功");
		return "redirect:"+Global.getAdminPath()+"/common/commonParameter/?repage";
	}
	
	@RequiresPermissions("common:commonParameter:edit")
	@RequestMapping(value = "delete")
	public String delete(CommonParameter commonParameter, RedirectAttributes redirectAttributes) {
		commonParameterService.delete(commonParameter);
		addMessage(redirectAttributes, "删除CommonParameter系统参数表成功");
		return "redirect:"+Global.getAdminPath()+"/common/commonParameter/?repage";
	}

}