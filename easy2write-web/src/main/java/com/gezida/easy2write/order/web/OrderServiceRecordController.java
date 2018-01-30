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
import com.gezida.easy2write.order.bean.OrderServiceRecord;
import com.gezida.easy2write.order.service.OrderServiceRecordService;

/**
 * 关于OrderServiceRecord订单服务流程记录表的Controller
 * @author Tangbinqi
 * @version 2017-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/order/orderServiceRecord")
public class OrderServiceRecordController extends BaseController {

	@Autowired
	private OrderServiceRecordService orderServiceRecordService;
	
	@ModelAttribute
	public OrderServiceRecord get(@RequestParam(required=false) String id) {
		OrderServiceRecord entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = orderServiceRecordService.get(id);
		}
		if (entity == null){
			entity = new OrderServiceRecord();
		}
		return entity;
	}
	
	@RequiresPermissions("order:orderServiceRecord:view")
	@RequestMapping(value = {"list", ""})
	public String list(OrderServiceRecord orderServiceRecord, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OrderServiceRecord> page = orderServiceRecordService.findPage(new Page<OrderServiceRecord>(request, response), orderServiceRecord); 
		model.addAttribute("page", page);
		return "easy2write/order/orderServiceRecordList";
	}

	@RequiresPermissions("order:orderServiceRecord:view")
	@RequestMapping(value = "form")
	public String form(OrderServiceRecord orderServiceRecord, Model model) {
		model.addAttribute("orderServiceRecord", orderServiceRecord);
		return "easy2write/order/orderServiceRecordForm";
	}

	@RequiresPermissions("order:orderServiceRecord:edit")
	@RequestMapping(value = "save")
	public String save(OrderServiceRecord orderServiceRecord, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, orderServiceRecord)){
			return form(orderServiceRecord, model);
		}
		orderServiceRecordService.save(orderServiceRecord);
		addMessage(redirectAttributes, "保存OrderServiceRecord订单服务流程记录表成功");
		return "redirect:"+Global.getAdminPath()+"/order/orderServiceRecord/?repage";
	}
	
	@RequiresPermissions("order:orderServiceRecord:edit")
	@RequestMapping(value = "delete")
	public String delete(OrderServiceRecord orderServiceRecord, RedirectAttributes redirectAttributes) {
		orderServiceRecordService.delete(orderServiceRecord);
		addMessage(redirectAttributes, "删除OrderServiceRecord订单服务流程记录表成功");
		return "redirect:"+Global.getAdminPath()+"/order/orderServiceRecord/?repage";
	}

}