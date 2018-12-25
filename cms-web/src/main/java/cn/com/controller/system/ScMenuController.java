package cn.com.controller.system;

import org.dto.system.ScMenuDto;
import org.entity.system.ScMenu;
import org.service.system.IScMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.com.controller.BaseController;
import zero.commons.basics.result.DataResult;

@RestController
@RequestMapping("/system/menu/")
public class ScMenuController extends BaseController<ScMenu, ScMenuDto, IScMenuService> {

	@Autowired
	private IScMenuService service;

	@GetMapping("index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("system/menu/index");
		view.addObject("status", service.status());
		return view;
	}

	@GetMapping("navs")
	public DataResult<ScMenu> navs() {
		return service.navs();
	}
}
