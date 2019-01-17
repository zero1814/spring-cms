package cn.com.controller.system;

import org.dto.system.ScRoleDto;
import org.entity.system.ScMenu;
import org.entity.system.ScRole;
import org.entity.system.ScUser;
import org.service.system.IScRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.com.controller.BaseController;
import zero.commons.basics.helper.CodeHelper;
import zero.commons.basics.result.EntityResult;
import zero.commons.basics.result.PageResult;
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
		String code = CodeHelper.getCode("SR");
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
	
	
	@GetMapping("users/{code}")
	public ModelAndView roleUsersIndex(@PathVariable("code") String code) {
		ModelAndView view =  new ModelAndView("system/role/user");
		view.addObject("code", code);
		return view;
	}
	
	@PostMapping("users")
	public PageResult<ScUser> roleUsers(ScRoleDto dto){
		return service.roleUsers(dto);
	}
	
	@GetMapping("menus/{code}")
	public ModelAndView roleMenusIndex(@PathVariable("code") String code) {
		ModelAndView view =  new ModelAndView("system/role/menu");
		view.addObject("code", code);
		return view;
	}
	
	@PostMapping("menus")
	public PageResult<ScMenu> rolemenus(ScRoleDto dto){
		return service.roleMenus(dto);
	}
}
