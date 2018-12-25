package cn.com.controller.system;

import org.dto.system.ScUserDto;
import org.entity.system.ScUser;
import org.service.system.IScUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.com.controller.BaseController;

@RestController
@RequestMapping("/system/user/")
public class ScUserController extends BaseController<ScUser, ScUserDto, IScUserService> {

	@Autowired
	private IScUserService service;

	@RequestMapping("index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("system/user/index");
		view.addObject("type", service.types());
		view.addObject("status", service.status());
		return view;
	}
}
