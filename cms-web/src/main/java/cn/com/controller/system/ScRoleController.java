package cn.com.controller.system;

import org.dto.system.ScRoleDto;
import org.entity.system.ScRole;
import org.service.system.IScRoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.com.controller.BaseController;
import zero.commons.basics.helper.CodeHelper;

@RestController
@RequestMapping("/system/role/")
public class ScRoleController extends BaseController<ScRole, ScRoleDto, IScRoleService> {

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

	@GetMapping("index/update")
	public ModelAndView updateIndex() {
		ModelAndView view = new ModelAndView("system/role/update");
		return view;
	}
}
