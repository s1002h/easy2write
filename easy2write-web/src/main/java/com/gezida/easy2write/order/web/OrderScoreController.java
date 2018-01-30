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
import com.gezida.easy2write.order.bean.OrderScore;
import com.gezida.easy2write.order.service.OrderScoreService;

/**
 * 关于OrderScore服务订单评分表的Controller
 * @author Tangbinqi
 * @version 2017-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/order/orderScore")
public class OrderScoreController extends BaseController {

	@Autowired
	private OrderScoreService orderScoreService;
	
	@ModelAttribute
	public OrderScore get(@RequestParam(required=false) String id) {
		OrderScore entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = orderScoreService.get(id);
		}
		if (entity == null){
			entity = new OrderScore();
		}
		return entity;
	}
	
	@RequiresPermissions("order:orderScore:view")
	@RequestMapping(value = {"list", ""})
	public String list(OrderScore orderScore, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<OrderScore> page = orderScoreService.findPage(new Page<OrderScore>(request, response), orderScore); 
		model.addAttribute("page", page);
		return "easy2write/order/orderScoreList";
	}

	@RequiresPermissions("order:orderScore:view")
	@RequestMapping(value = "form")
	public String form(OrderScore orderScore, Model model) {
		model.addAttribute("orderScore", orderScore);
		return "easy2write/order/orderScoreForm";
	}

	@RequiresPermissions("order:orderScore:edit")
	@RequestMapping(value = "save")
	public String save(OrderScore orderScore, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, orderScore)){
			return form(orderScore, model);
		}
		orderScoreService.save(orderScore);
		addMessage(redirectAttributes, "保存OrderScore服务订单评分表成功");
		return "redirect:"+Global.getAdminPath()+"/order/orderScore/?repage";
	}
	
	@RequiresPermissions("order:orderScore:edit")
	@RequestMapping(value = "delete")
	public String delete(OrderScore orderScore, RedirectAttributes redirectAttributes) {
		orderScoreService.delete(orderScore);
		addMessage(redirectAttributes, "删除OrderScore服务订单评分表成功");
		return "redirect:"+Global.getAdminPath()+"/order/orderScore/?repage";
	}

}