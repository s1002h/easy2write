/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.order.web;

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
import com.gezida.easy2write.order.bean.OrderBase;
import com.gezida.easy2write.order.service.OrderBaseService;

/**
 * 关于OrderBase订单表的Controller
 * @author Tangbinqi
 * @version 2017-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/order/orderBase")
public class OrderBaseController extends BaseController {

	@Autowired
	private OrderBaseService orderBaseService;
	
	@ModelAttribute
	public OrderBase get(@RequestParam(required=false) String id) {
		OrderBase entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = orderBaseService.get(id);
		}
		if (entity == null){
			entity = new OrderBase();
		}
		return entity;
	}
	
	@RequiresPermissions("order:orderBase:view")
	@RequestMapping(value = {"list", ""})
	public String list(OrderBase orderBase, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OrderBase> page = orderBaseService.findPage(new Page<OrderBase>(request, response), orderBase); 
		model.addAttribute("page", page);
		return "easy2write/order/orderBaseList";
	}

	@RequiresPermissions("order:orderBase:view")
	@RequestMapping(value = "form")
	public String form(OrderBase orderBase, Model model) {
		model.addAttribute("orderBase", orderBase);
		return "easy2write/order/orderBaseForm";
	}

	@RequiresPermissions("order:orderBase:edit")
	@RequestMapping(value = "save")
	public String save(OrderBase orderBase, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, orderBase)){
			return form(orderBase, model);
		}
		orderBaseService.save(orderBase);
		addMessage(redirectAttributes, "保存OrderBase订单表成功");
		return "redirect:"+Global.getAdminPath()+"/order/orderBase/?repage";
	}
	
	@RequiresPermissions("order:orderBase:edit")
	@RequestMapping(value = "delete")
	public String delete(OrderBase orderBase, RedirectAttributes redirectAttributes) {
		orderBaseService.delete(orderBase);
		addMessage(redirectAttributes, "删除OrderBase订单表成功");
		return "redirect:"+Global.getAdminPath()+"/order/orderBase/?repage";
	}

}