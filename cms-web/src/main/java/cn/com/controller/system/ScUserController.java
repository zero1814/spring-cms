package cn.com.controller.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.dto.system.ScUserDto;
import org.entity.system.ScRole;
import org.entity.system.ScUser;
import org.service.impl.system.FileService;
import org.service.system.IScUserRoleService;
import org.service.system.IScUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import cn.com.controller.BaseController;
import zero.commons.basics.helper.CodeHelper;
import zero.commons.basics.result.BaseResult;
import zero.commons.basics.result.EntityResult;
import zero.commons.basics.result.ResultType;
import zero.commons.basics.result.TransferResult;

@RestController
@RequestMapping("/system/user/")
public class ScUserController extends BaseController<ScUser, ScUserDto, IScUserService> {

	@Autowired
	private IScUserService service;
	@Autowired
	private FileService fileService;

	@Autowired
	private IScUserRoleService urService;

	@Value("${system.user.header.path}")
	private String headerPath;
	@Value("${system.user.header.url}")
	private String headerUrl;

	/**
	 * 
	 * 方法: index <br>
	 * 描述: 列表页 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月18日 下午3:56:11
	 * 
	 * @return
	 */
	@GetMapping("index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("system/user/index");
		view.addObject("type", service.types());
		view.addObject("status", service.status());
		return view;
	}

	/**
	 * 
	 * 方法: insertIndex <br>
	 * 描述: 添加用户界面 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月18日 下午3:56:02
	 * 
	 * @return
	 */
	@GetMapping("index/insert")
	public ModelAndView insertIndex() {
		ModelAndView view = new ModelAndView("system/user/insert");
		String code = CodeHelper.getCode("SU");
		view.addObject("code", code);
		view.addObject("type", service.types());
		view.addObject("status", service.status());
		return view;
	}

	/**
	 * 
	 * 方法: updateIndex <br>
	 * 描述: 编辑用户页面 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月18日 下午3:55:53
	 * 
	 * @param code
	 * @return
	 */
	@GetMapping("update/{code}")
	public ModelAndView updateIndex(@PathVariable("code") String code) {
		EntityResult<ScUser> result = service.select(code);
		ModelAndView view = new ModelAndView();
		if (result.getCode() == ResultType.SUCCESS) {
			view.setViewName("system/user/update");
			view.addObject("user", result.getEntity());
			view.addObject("type", service.types());
			view.addObject("status", service.status());
		} else if (result.getCode() == ResultType.ERROR) {
			view.setViewName("error/500");
		} else {
			view.setViewName("error/404");
		}
		return view;
	}

	/**
	 * 
	 * 方法: updatePasswordIndex <br>
	 * 描述: 修改密码页面 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月18日 下午3:55:44
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("update/password")
	public ModelAndView updatePasswordIndex(HttpSession session) {
		ModelAndView view = new ModelAndView();
		ScUser user = (ScUser) session.getAttribute("user");
		if (user != null) {
			view.setViewName("system/user/password");
			view.addObject("user", user);
		} else {
			view.setViewName("error/404");
		}
		return view;
	}

	/**
	 * 
	 * 方法: updatePassword <br>
	 * 描述: 修改密码 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月18日 下午3:55:33
	 * 
	 * @param session
	 * @param password
	 * @return
	 */
	@PostMapping(value = "update/password", consumes = "application/json")
	public BaseResult updatePassword(HttpSession session, @RequestBody JSONObject password) {
		ScUser user = (ScUser) session.getAttribute("user");
		return service.updatePassword(user, password.getString("password"));
	}

	/**
	 * 
	 * 方法: uploadHeader <br>
	 * 描述: 头像上传 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月18日 下午3:55:25
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("header/upload")
	public BaseResult uploadHeader(HttpServletRequest request) {
		return fileService.upload(request, headerPath, headerUrl);
	}

	/**
	 * 
	 * 方法: transferRolesIndex <br>
	 * 描述: 根据用户编码查询用户角色列表页面 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月18日 下午3:55:22
	 * 
	 * @param userCode
	 * @return
	 */
	@GetMapping("role/{userCode}")
	public ModelAndView transferRolesIndex(@PathVariable("userCode") String userCode) {
		ModelAndView view = new ModelAndView();
		return view;
	}

	/**
	 * 
	 * 方法: transferRoles <br>
	 * 描述: 根据用户编码查询用户角色列表数据集 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月18日 下午3:56:28
	 * 
	 * @param userCode
	 * @return
	 */
	@PostMapping("role/data/{userCode}")
	public TransferResult<ScRole> transferRoles(@PathVariable("userCode") String userCode) {
		return urService.userRoles(userCode);
	}
}
