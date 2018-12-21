package cn.com.controller.system;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/system/menu/")
public class ScMenuController {

	@GetMapping("index")
	public ModelAndView index() {

		return new ModelAndView("system/menu/index");
	}
}
