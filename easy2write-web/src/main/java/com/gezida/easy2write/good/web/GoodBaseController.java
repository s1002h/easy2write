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
import com.gezida.easy2write.good.bean.GoodBase;
import com.gezida.easy2write.good.service.GoodBaseService;

/**
 * 关于GoodBase商品信息表的Controller
 * @author Tangbinqi
 * @version 2017-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/good/goodBase")
public class GoodBaseController extends BaseController {

	@Autowired
	private GoodBaseService goodBaseService;
	
	@ModelAttribute
	public GoodBase get(@RequestParam(required=false) String id) {
		GoodBase entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = goodBaseService.get(id);
		}
		if (entity == null){
			entity = new GoodBase();
		}
		return entity;
	}
	
	@RequiresPermissions("good:goodBase:view")
	@RequestMapping(value = {"list", ""})
	public String list(GoodBase goodBase, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<GoodBase> page = goodBaseService.findPage(new Page<GoodBase>(request, response), goodBase); 
		model.addAttribute("page", page);
		return "easy2write/good/goodBaseList";
	}

	@RequiresPermissions("good:goodBase:view")
	@RequestMapping(value = "form")
	public String form(GoodBase goodBase, Model model) {
		model.addAttribute("goodBase", goodBase);
		return "easy2write/good/goodBaseForm";
	}

	@RequiresPermissions("good:goodBase:edit")
	@RequestMapping(value = "save")
	public String save(GoodBase goodBase, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, goodBase)){
			return form(goodBase, model);
		}
		goodBaseService.save(goodBase);
		addMessage(redirectAttributes, "保存GoodBase商品信息表成功");
		return "redirect:"+Global.getAdminPath()+"/good/goodBase/?repage";
	}
	
	@RequiresPermissions("good:goodBase:edit")
	@RequestMapping(value = "delete")
	public String delete(GoodBase goodBase, RedirectAttributes redirectAttributes) {
		goodBaseService.delete(goodBase);
		addMessage(redirectAttributes, "删除GoodBase商品信息表成功");
		return "redirect:"+Global.getAdminPath()+"/good/goodBase/?repage";
	}

}