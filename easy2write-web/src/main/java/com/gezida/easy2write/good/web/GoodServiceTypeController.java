/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.good.web;

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
import com.gezida.easy2write.good.bean.GoodServiceType;
import com.gezida.easy2write.good.service.GoodServiceTypeService;

/**
 * 关于GoodServiceType服务类型的Controller
 * @author Tangbinqi
 * @version 2017-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/good/goodServiceType")
public class GoodServiceTypeController extends BaseController {

	@Autowired
	private GoodServiceTypeService goodServiceTypeService;
	
	@ModelAttribute
	public GoodServiceType get(@RequestParam(required=false) String id) {
		GoodServiceType entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = goodServiceTypeService.get(id);
		}
		if (entity == null){
			entity = new GoodServiceType();
		}
		return entity;
	}
	
	@RequiresPermissions("good:goodServiceType:view")
	@RequestMapping(value = {"list", ""})
	public String list(GoodServiceType goodServiceType, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<GoodServiceType> page = goodServiceTypeService.findPage(new Page<GoodServiceType>(request, response), goodServiceType); 
		model.addAttribute("page", page);
		return "easy2write/good/goodServiceTypeList";
	}

	@RequiresPermissions("good:goodServiceType:view")
	@RequestMapping(value = "form")
	public String form(GoodServiceType goodServiceType, Model model) {
		model.addAttribute("goodServiceType", goodServiceType);
		return "easy2write/good/goodServiceTypeForm";
	}

	@RequiresPermissions("good:goodServiceType:edit")
	@RequestMapping(value = "save")
	public String save(GoodServiceType goodServiceType, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, goodServiceType)){
			return form(goodServiceType, model);
		}
		goodServiceTypeService.save(goodServiceType);
		addMessage(redirectAttributes, "保存GoodServiceType服务类型成功");
		return "redirect:"+Global.getAdminPath()+"/good/goodServiceType/?repage";
	}
	
	@RequiresPermissions("good:goodServiceType:edit")
	@RequestMapping(value = "delete")
	public String delete(GoodServiceType goodServiceType, RedirectAttributes redirectAttributes) {
		goodServiceTypeService.delete(goodServiceType);
		addMessage(redirectAttributes, "删除GoodServiceType服务类型成功");
		return "redirect:"+Global.getAdminPath()+"/good/goodServiceType/?repage";
	}

}