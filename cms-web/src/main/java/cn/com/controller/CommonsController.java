package cn.com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CommonsController {

	@RequestMapping("index")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	@RequestMapping("main")
	public ModelAndView main() {
		return new ModelAndView("main");
	}
}
