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
import com.gezida.easy2write.message.bean.MessageBoard;
import com.gezida.easy2write.message.service.MessageBoardService;

/**
 * 关于MessageBoard留言板的Controller
 * @author Tangbinqi
 * @version 2017-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/message/messageBoard")
public class MessageBoardController extends BaseController {

	@Autowired
	private MessageBoardService messageBoardService;
	
	@ModelAttribute
	public MessageBoard get(@RequestParam(required=false) String id) {
		MessageBoard entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = messageBoardService.get(id);
		}
		if (entity == null){
			entity = new MessageBoard();
		}
		return entity;
	}
	
	@RequiresPermissions("message:messageBoard:view")
	@RequestMapping(value = {"list", ""})
	public String list(MessageBoard messageBoard, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<MessageBoard> page = messageBoardService.findPage(new Page<MessageBoard>(request, response), messageBoard); 
		model.addAttribute("page", page);
		return "easy2write/message/messageBoardList";
	}

	@RequiresPermissions("message:messageBoard:view")
	@RequestMapping(value = "form")
	public String form(MessageBoard messageBoard, Model model) {
		model.addAttribute("messageBoard", messageBoard);
		return "easy2write/message/messageBoardForm";
	}

	@RequiresPermissions("message:messageBoard:edit")
	@RequestMapping(value = "save")
	public String save(MessageBoard messageBoard, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, messageBoard)){
			return form(messageBoard, model);
		}
		messageBoardService.save(messageBoard);
		addMessage(redirectAttributes, "保存MessageBoard留言板成功");
		return "redirect:"+Global.getAdminPath()+"/message/messageBoard/?repage";
	}
	
	@RequiresPermissions("message:messageBoard:edit")
	@RequestMapping(value = "delete")
	public String delete(MessageBoard messageBoard, RedirectAttributes redirectAttributes) {
		messageBoardService.delete(messageBoard);
		addMessage(redirectAttributes, "删除MessageBoard留言板成功");
		return "redirect:"+Global.getAdminPath()+"/message/messageBoard/?repage";
	}

}