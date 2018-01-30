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
import com.gezida.easy2write.order.bean.OrderComplaints;
import com.gezida.easy2write.order.service.OrderComplaintsService;

/**
 * 关于OrderComplaints服务申述的Controller
 * @author Tangbinqi
 * @version 2017-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/order/orderComplaints")
public class OrderComplaintsController extends BaseController {

	@Autowired
	private OrderComplaintsService orderComplaintsService;
	
	@ModelAttribute
	public OrderComplaints get(@RequestParam(required=false) String id) {
		OrderComplaints entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = orderComplaintsService.get(id);
		}
		if (entity == null){
			entity = new OrderComplaints();
		}
		return entity;
	}
	
	@RequiresPermissions("order:orderComplaints:view")
	@RequestMapping(value = {"list", ""})
	public String list(OrderComplaints orderComplaints, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OrderComplaints> page = orderComplaintsService.findPage(new Page<OrderComplaints>(request, response), orderComplaints); 
		model.addAttribute("page", page);
		return "easy2write/order/orderComplaintsList";
	}

	@RequiresPermissions("order:orderComplaints:view")
	@RequestMapping(value = "form")
	public String form(OrderComplaints orderComplaints, Model model) {
		model.addAttribute("orderComplaints", orderComplaints);
		return "easy2write/order/orderComplaintsForm";
	}

	@RequiresPermissions("order:orderComplaints:edit")
	@RequestMapping(value = "save")
	public String save(OrderComplaints orderComplaints, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, orderComplaints)){
			return form(orderComplaints, model);
		}
		orderComplaintsService.save(orderComplaints);
		addMessage(redirectAttributes, "保存OrderComplaints服务申述成功");
		return "redirect:"+Global.getAdminPath()+"/order/orderComplaints/?repage";
	}
	
	@RequiresPermissions("order:orderComplaints:edit")
	@RequestMapping(value = "delete")
	public String delete(OrderComplaints orderComplaints, RedirectAttributes redirectAttributes) {
		orderComplaintsService.delete(orderComplaints);
		addMessage(redirectAttributes, "删除OrderComplaints服务申述成功");
		return "redirect:"+Global.getAdminPath()+"/order/orderComplaints/?repage";
	}

}