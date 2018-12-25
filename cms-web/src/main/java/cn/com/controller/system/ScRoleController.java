package cn.com.controller.system;

import org.dto.system.ScRoleDto;
import org.entity.system.ScRole;
import org.service.system.IScRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.com.controller.BaseController;

@RestController
@RequestMapping("/system/role/")
public class ScRoleController extends BaseController<ScRole, ScRoleDto, IScRoleService> {

	@RequestMapping("index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("system/role/index");
		return view;
	}
}
