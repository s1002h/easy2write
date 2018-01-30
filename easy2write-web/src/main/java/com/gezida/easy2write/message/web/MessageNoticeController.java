/**
 * Copyright &copy; 2012-2017 All rights reserved.
 */
package com.gezida.easy2write.message.web;

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
import com.gezida.easy2write.message.bean.MessageNotice;
import com.gezida.easy2write.message.service.MessageNoticeService;

/**
 * 关于MessageNotice通知的Controller
 * @author Tangbinqi
 * @version 2017-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/message/messageNotice")
public class MessageNoticeController extends BaseController {

	@Autowired
	private MessageNoticeService messageNoticeService;
	
	@ModelAttribute
	public MessageNotice get(@RequestParam(required=false) String id) {
		MessageNotice entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = messageNoticeService.get(id);
		}
		if (entity == null){
			entity = new MessageNotice();
		}
		return entity;
	}
	
	@RequiresPermissions("message:messageNotice:view")
	@RequestMapping(value = {"list", ""})
	public String list(MessageNotice messageNotice, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<MessageNotice> page = messageNoticeService.findPage(new Page<MessageNotice>(request, response), messageNotice); 
		model.addAttribute("page", page);
		return "easy2write/message/messageNoticeList";
	}

	@RequiresPermissions("message:messageNotice:view")
	@RequestMapping(value = "form")
	public String form(MessageNotice messageNotice, Model model) {
		model.addAttribute("messageNotice", messageNotice);
		return "easy2write/message/messageNoticeForm";
	}

	@RequiresPermissions("message:messageNotice:edit")
	@RequestMapping(value = "save")
	public String save(MessageNotice messageNotice, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, messageNotice)){
			return form(messageNotice, model);
		}
		messageNoticeService.save(messageNotice);
		addMessage(redirectAttributes, "保存MessageNotice通知成功");
		return "redirect:"+Global.getAdminPath()+"/message/messageNotice/?repage";
	}
	
	@RequiresPermissions("message:messageNotice:edit")
	@RequestMapping(value = "delete")
	public String delete(MessageNotice messageNotice, RedirectAttributes redirectAttributes) {
		messageNoticeService.delete(messageNotice);
		addMessage(redirectAttributes, "删除MessageNotice通知成功");
		return "redirect:"+Global.getAdminPath()+"/message/messageNotice/?repage";
	}

}