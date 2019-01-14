package cn.com.controller.system;

import org.dto.system.ScMenuDto;
import org.entity.system.ScMenu;
import org.service.system.IScMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.com.controller.BaseController;
import zero.commons.basics.helper.CodeHelper;
import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.EntityResult;
import zero.commons.basics.result.ResultType;

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

	@GetMapping("index/insert")
	public ModelAndView insertIndex() {
		ModelAndView view = new ModelAndView("system/menu/insert");
		String code = CodeHelper.getCode("SM");
		view.addObject("parent", service.parent());
		view.addObject("status", service.status());
		view.addObject("code", code);
		return view;
	}

	@GetMapping("update/{code}")
	public ModelAndView updateIndex(@PathVariable("code") String code) {
		EntityResult<ScMenu> result = service.select(code);
		ModelAndView view = new ModelAndView();
		if (result.getCode() == ResultType.SUCCESS) {
			view.setViewName("system/menu/update");
			view.addObject("parent", service.parent());
			view.addObject("status", service.status());
			view.addObject("menu", result.getEntity());
		} else if (result.getCode() == ResultType.ERROR) {
			view.setViewName("error/500");
		} else {
			view.setViewName("error/404");
		}
		return view;
	}
}
