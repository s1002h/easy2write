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
import com.gezida.easy2write.order.bean.OrderPay;
import com.gezida.easy2write.order.service.OrderPayService;

/**
 * 关于OrderPay订单账户支付表的Controller
 * @author Tangbinqi
 * @version 2017-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/order/orderPay")
public class OrderPayController extends BaseController {

	@Autowired
	private OrderPayService orderPayService;
	
	@ModelAttribute
	public OrderPay get(@RequestParam(required=false) String id) {
		OrderPay entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = orderPayService.get(id);
		}
		if (entity == null){
			entity = new OrderPay();
		}
		return entity;
	}
	
	@RequiresPermissions("order:orderPay:view")
	@RequestMapping(value = {"list", ""})
	public String list(OrderPay orderPay, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OrderPay> page = orderPayService.findPage(new Page<OrderPay>(request, response), orderPay); 
		model.addAttribute("page", page);
		return "easy2write/order/orderPayList";
	}

	@RequiresPermissions("order:orderPay:view")
	@RequestMapping(value = "form")
	public String form(OrderPay orderPay, Model model) {
		model.addAttribute("orderPay", orderPay);
		return "easy2write/order/orderPayForm";
	}

	@RequiresPermissions("order:orderPay:edit")
	@RequestMapping(value = "save")
	public String save(OrderPay orderPay, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, orderPay)){
			return form(orderPay, model);
		}
		orderPayService.save(orderPay);
		addMessage(redirectAttributes, "保存OrderPay订单账户支付表成功");
		return "redirect:"+Global.getAdminPath()+"/order/orderPay/?repage";
	}
	
	@RequiresPermissions("order:orderPay:edit")
	@RequestMapping(value = "delete")
	public String delete(OrderPay orderPay, RedirectAttributes redirectAttributes) {
		orderPayService.delete(orderPay);
		addMessage(redirectAttributes, "删除OrderPay订单账户支付表成功");
		return "redirect:"+Global.getAdminPath()+"/order/orderPay/?repage";
	}

}