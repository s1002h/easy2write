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
import com.gezida.easy2write.good.bean.GoodServiceFlow;
import com.gezida.easy2write.good.service.GoodServiceFlowService;

/**
 * 关于GoodServiceFlow服务流程配置表的Controller
 * @author Tangbinqi
 * @version 2017-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/good/goodServiceFlow")
public class GoodServiceFlowController extends BaseController {

	@Autowired
	private GoodServiceFlowService goodServiceFlowService;
	
	@ModelAttribute
	public GoodServiceFlow get(@RequestParam(required=false) String id) {
		GoodServiceFlow entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = goodServiceFlowService.get(id);
		}
		if (entity == null){
			entity = new GoodServiceFlow();
		}
		return entity;
	}
	
	@RequiresPermissions("good:goodServiceFlow:view")
	@RequestMapping(value = {"list", ""})
	public String list(GoodServiceFlow goodServiceFlow, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<GoodServiceFlow> page = goodServiceFlowService.findPage(new Page<GoodServiceFlow>(request, response), goodServiceFlow); 
		model.addAttribute("page", page);
		return "easy2write/good/goodServiceFlowList";
	}

	@RequiresPermissions("good:goodServiceFlow:view")
	@RequestMapping(value = "form")
	public String form(GoodServiceFlow goodServiceFlow, Model model) {
		model.addAttribute("goodServiceFlow", goodServiceFlow);
		return "easy2write/good/goodServiceFlowForm";
	}

	@RequiresPermissions("good:goodServiceFlow:edit")
	@RequestMapping(value = "save")
	public String save(GoodServiceFlow goodServiceFlow, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, goodServiceFlow)){
			return form(goodServiceFlow, model);
		}
		goodServiceFlowService.save(goodServiceFlow);
		addMessage(redirectAttributes, "保存GoodServiceFlow服务流程配置表成功");
		return "redirect:"+Global.getAdminPath()+"/good/goodServiceFlow/?repage";
	}
	
	@RequiresPermissions("good:goodServiceFlow:edit")
	@RequestMapping(value = "delete")
	public String delete(GoodServiceFlow goodServiceFlow, RedirectAttributes redirectAttributes) {
		goodServiceFlowService.delete(goodServiceFlow);
		addMessage(redirectAttributes, "删除GoodServiceFlow服务流程配置表成功");
		return "redirect:"+Global.getAdminPath()+"/good/goodServiceFlow/?repage";
	}

}