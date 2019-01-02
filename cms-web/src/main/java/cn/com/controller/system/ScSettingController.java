package cn.com.controller.system;

import org.dto.system.ScSettingDto;
import org.entity.system.ScSetting;
import org.service.system.IScSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.com.controller.BaseController;
import zero.commons.basics.helper.CodeHelper;
import zero.commons.basics.result.DataResult;
import zero.commons.basics.result.EntityResult;
import zero.commons.basics.result.ResultType;

@RestController
@RequestMapping("/system/setting/")
public class ScSettingController extends BaseController<ScSetting, ScSettingDto, IScSettingService> {

	@Autowired
	private IScSettingService service;

	@RequestMapping("index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("system/setting/index");
		return view;
	}

	/**
	 * 
	 * 方法: tree <br>
	 * 描述: 树形菜单 <br>
	 * 作者: zhy<br>
	 * 时间: 2018年12月29日 下午3:54:20
	 * 
	 * @param dto
	 * @return
	 */
	@PostMapping("tree")
	public DataResult<ScSetting> tree(ScSettingDto dto) {
		return service.tree(dto);
	}

	/**
	 * 
	 * 方法: detail <br>
	 * 描述: 查询配置信息 <br>
	 * 作者: zhy<br>
	 * 时间: 2018年12月29日 下午3:54:08
	 * 
	 * @param code
	 * @return
	 */
	@GetMapping("{code}")
	public ModelAndView detail(@PathVariable("code") String code) {
		ModelAndView view = new ModelAndView();
		EntityResult<ScSetting> result = service.select(code);
		if (result.getCode() == ResultType.SUCCESS) {
			view.setViewName("system/setting/detail");
			view.addObject("entity", service.select(code).getEntity());
		} else if (result.getCode() == ResultType.NULL) {
			view.setViewName(nullUrl);
		} else {
			view.setViewName(errorUrl);
		}
		return view;
	}

	@GetMapping("insert/{code}")
	public ModelAndView insertIndex(@PathVariable("code") String code) {
		ModelAndView view = new ModelAndView("system/setting/insert");
		view.addObject("code", CodeHelper.getCode("SS"));
		view.addObject("parentCode", code);
		return view;
	}

	@GetMapping("update/{code}")
	public ModelAndView update(@PathVariable("code") String code) {
		ModelAndView view = new ModelAndView();
		EntityResult<ScSetting> result = service.select(code);
		if (result.getCode() == ResultType.SUCCESS) {
			view.setViewName("system/setting/update");
			view.addObject("entity", result.getEntity());
		} else if (result.getCode() == ResultType.NULL) {
			view.setViewName(nullUrl);
		} else {
			view.setViewName(errorUrl);
		}
		return view;
	}
}
