package cn.com.controller.system;

import org.dto.system.ScTimeTaskDto;
import org.entity.system.ScTimeTask;
import org.service.system.IScTimeTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.com.controller.BaseController;
import zero.commons.basics.result.EntityResult;
import zero.commons.basics.result.ResultType;

@RestController
@RequestMapping("/system/timetask/")
public class ScTimeTaskController extends BaseController<ScTimeTask, ScTimeTaskDto, IScTimeTaskService> {

	@Autowired
	private IScTimeTaskService service;

	@RequestMapping("index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("system/timetask/index");
		view.addObject("type", service.types());
		view.addObject("status", service.status());
		return view;
	}

	@RequestMapping("index/insert")
	public ModelAndView insert() {
		ModelAndView view = new ModelAndView("system/timetask/insert");
		view.addObject("type", service.types());
		view.addObject("status", service.status());
		return view;
	}

	@RequestMapping("index/update/{code}")
	public ModelAndView update(@PathVariable("code") String code) {
		ModelAndView view = new ModelAndView();
		EntityResult<ScTimeTask> result = service.select(code);
		if (result.getCode() == ResultType.SUCCESS) {
			view.setViewName("system/timetask/update");
			view.addObject("entity", result.getEntity());
			view.addObject("type", service.types());
			view.addObject("status", service.status());
		} else if (result.getCode() == ResultType.NULL) {
			view.setViewName("error/404");
		} else {
			view.setViewName("error/500");
		}
		return view;
	}
}
