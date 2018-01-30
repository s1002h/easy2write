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
import com.gezida.easy2write.common.bean.CommonMajor;
import com.gezida.easy2write.common.service.CommonMajorService;

/**
 * 关于CommonMajor专业的Controller
 * @author Tangbinqi
 * @version 2017-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/common/commonMajor")
public class CommonMajorController extends BaseController {

	@Autowired
	private CommonMajorService commonMajorService;
	
	@ModelAttribute
	public CommonMajor get(@RequestParam(required=false) String id) {
		CommonMajor entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = commonMajorService.get(id);
		}
		if (entity == null){
			entity = new CommonMajor();
		}
		return entity;
	}
	
	@RequiresPermissions("common:commonMajor:view")
	@RequestMapping(value = {"list", ""})
	public String list(CommonMajor commonMajor, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CommonMajor> page = commonMajorService.findPage(new Page<CommonMajor>(request, response), commonMajor); 
		model.addAttribute("page", page);
		return "easy2write/common/commonMajorList";
	}

	@RequiresPermissions("common:commonMajor:view")
	@RequestMapping(value = "form")
	public String form(CommonMajor commonMajor, Model model) {
		model.addAttribute("commonMajor", commonMajor);
		return "easy2write/common/commonMajorForm";
	}

	@RequiresPermissions("common:commonMajor:edit")
	@RequestMapping(value = "save")
	public String save(CommonMajor commonMajor, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, commonMajor)){
			return form(commonMajor, model);
		}
		commonMajorService.save(commonMajor);
		addMessage(redirectAttributes, "保存CommonMajor专业成功");
		return "redirect:"+Global.getAdminPath()+"/common/commonMajor/?repage";
	}
	
	@RequiresPermissions("common:commonMajor:edit")
	@RequestMapping(value = "delete")
	public String delete(CommonMajor commonMajor, RedirectAttributes redirectAttributes) {
		commonMajorService.delete(commonMajor);
		addMessage(redirectAttributes, "删除CommonMajor专业成功");
		return "redirect:"+Global.getAdminPath()+"/common/commonMajor/?repage";
	}

}