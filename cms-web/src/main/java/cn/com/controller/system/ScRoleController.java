package cn.com.controller.system;

import org.dto.system.ScRoleDto;
import org.entity.system.ScRole;
import org.service.system.IScRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.com.controller.BaseController;
import zero.commons.basics.helper.CodeHelper;
import zero.commons.basics.result.EntityResult;
import zero.commons.basics.result.ResultType;

@RestController
@RequestMapping("/system/role/")
public class ScRoleController extends BaseController<ScRole, ScRoleDto, IScRoleService> {

	@Autowired
	private IScRoleService service;

	@RequestMapping("index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("system/role/index");
		return view;
	}

	@GetMapping("index/insert")
	public ModelAndView insertIndex() {
		ModelAndView view = new ModelAndView("system/role/insert");
		String code = CodeHelper.getCode("SU");
		view.addObject("code", code);
		return view;
	}

	@GetMapping("update/{code}")
	public ModelAndView updateIndex(@PathVariable("code") String code) {
		EntityResult<ScRole> result = service.select(code);
		ModelAndView view = new ModelAndView();
		if (result.getCode() == ResultType.SUCCESS) {
			view.setViewName("system/role/update");
			view.addObject("role", result.getEntity());
		} else if (result.getCode() == ResultType.ERROR) {
			view.setViewName("error/500");
		} else {
			view.setViewName("error/404");
		}
		return view;
	}
}
