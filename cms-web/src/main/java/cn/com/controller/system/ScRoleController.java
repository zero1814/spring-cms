package cn.com.controller.system;

import org.dto.system.ScRoleDto;
import org.entity.system.ScRole;
import org.entity.system.ScUser;
import org.service.system.IScRoleService;
import org.service.system.IScUserRoleService;
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
import zero.commons.basics.result.ResultType;
import zero.commons.basics.result.TransferResult;

@RestController
@RequestMapping("/system/role/")
public class ScRoleController extends BaseController<ScRole, ScRoleDto, IScRoleService> {

	@Autowired
	private IScRoleService service;
	@Autowired
	private IScUserRoleService urService;

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

	/**
	 * 
	 * 方法: transferUsersIndex <br>
	 * 描述: 查看选择当前角色包含用户页面 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月18日 下午3:54:29
	 * @param roleCode
	 * @return
	 */
	@GetMapping("user/{roleCode}")
	public ModelAndView usersIndex(@PathVariable("roleCode") String roleCode) {
		ModelAndView view = new ModelAndView("system/role/user");
		view.addObject("code", roleCode);
		return view;
	}

	/**
	 * 
	 * 方法: transferUsers <br>
	 * 描述: 查看选择当前角色包含用户的数据集 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月18日 下午3:55:07
	 * @param roleCode
	 * @return
	 */
	@PostMapping("user/data/{roleCode}")
	public TransferResult<ScUser> users(@PathVariable("roleCode") String roleCode) {
		return urService.roleUsers(roleCode);
	}
}
