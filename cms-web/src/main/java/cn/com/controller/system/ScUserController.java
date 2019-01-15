package cn.com.controller.system;

import javax.servlet.http.HttpServletRequest;

import org.dto.system.ScUserDto;
import org.entity.system.ScUser;
import org.service.impl.system.FileService;
import org.service.system.IScUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.com.controller.BaseController;
import zero.commons.basics.helper.CodeHelper;
import zero.commons.basics.result.BaseResult;
import zero.commons.basics.result.EntityResult;
import zero.commons.basics.result.ResultType;

@RestController
@RequestMapping("/system/user/")
public class ScUserController extends BaseController<ScUser, ScUserDto, IScUserService> {

	@Autowired
	private IScUserService service;
	@Autowired
	private FileService fileService;

	@Value("${system.user.header.path}")
	private String headerPath;
	@Value("${system.user.header.url}")
	private String headerUrl;

	@GetMapping("index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("system/user/index");
		view.addObject("type", service.types());
		view.addObject("status", service.status());
		return view;
	}

	@GetMapping("index/insert")
	public ModelAndView insertIndex() {
		ModelAndView view = new ModelAndView("system/user/insert");
		String code = CodeHelper.getCode("SU");
		view.addObject("code", code);
		view.addObject("type", service.types());
		view.addObject("status", service.status());
		return view;
	}

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

	@RequestMapping("header/upload")
	public BaseResult uploadHeader(HttpServletRequest request) {
		return fileService.upload(request, headerPath,headerUrl);
	}
}
