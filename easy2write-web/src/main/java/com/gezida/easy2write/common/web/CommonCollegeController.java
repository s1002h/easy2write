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
import com.gezida.easy2write.common.bean.CommonCollege;
import com.gezida.easy2write.common.service.CommonCollegeService;

/**
 * 关于CommonCollege高校表的Controller
 * @author Tangbinqi
 * @version 2017-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/common/commonCollege")
public class CommonCollegeController extends BaseController {

	@Autowired
	private CommonCollegeService commonCollegeService;
	
	@ModelAttribute
	public CommonCollege get(@RequestParam(required=false) String id) {
		CommonCollege entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = commonCollegeService.get(id);
		}
		if (entity == null){
			entity = new CommonCollege();
		}
		return entity;
	}
	
	@RequiresPermissions("common:commonCollege:view")
	@RequestMapping(value = {"list", ""})
	public String list(CommonCollege commonCollege, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CommonCollege> page = commonCollegeService.findPage(new Page<CommonCollege>(request, response), commonCollege); 
		model.addAttribute("page", page);
		return "easy2write/common/commonCollegeList";
	}

	@RequiresPermissions("common:commonCollege:view")
	@RequestMapping(value = "form")
	public String form(CommonCollege commonCollege, Model model) {
		model.addAttribute("commonCollege", commonCollege);
		return "easy2write/common/commonCollegeForm";
	}

	@RequiresPermissions("common:commonCollege:edit")
	@RequestMapping(value = "save")
	public String save(CommonCollege commonCollege, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, commonCollege)){
			return form(commonCollege, model);
		}
		commonCollegeService.save(commonCollege);
		addMessage(redirectAttributes, "保存CommonCollege高校表成功");
		return "redirect:"+Global.getAdminPath()+"/common/commonCollege/?repage";
	}
	
	@RequiresPermissions("common:commonCollege:edit")
	@RequestMapping(value = "delete")
	public String delete(CommonCollege commonCollege, RedirectAttributes redirectAttributes) {
		commonCollegeService.delete(commonCollege);
		addMessage(redirectAttributes, "删除CommonCollege高校表成功");
		return "redirect:"+Global.getAdminPath()+"/common/commonCollege/?repage";
	}

}