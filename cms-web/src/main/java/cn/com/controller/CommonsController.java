package cn.com.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.dto.system.ScUserDto;
import org.entity.system.ScUser;
import org.service.system.IScUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import zero.commons.basics.result.BaseResult;
import zero.commons.basics.result.EntityResult;
import zero.commons.basics.result.ResultType;

@RestController
public class CommonsController {

	@Autowired
	private IScUserService userService;

	/**
	 * 
	 * 方法: index <br>
	 * 描述: 系统首页 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月8日 下午3:19:23
	 * 
	 * @return
	 */
	@GetMapping("index")
	public ModelAndView index(HttpSession session) {
		ModelAndView view = new ModelAndView("index");
		ScUser user = (ScUser) session.getAttribute("user");
		if (user == null) {
			return new ModelAndView("error/500");
		}
		view.addObject("user", user);
		return view;
	}

	/**
	 * 
	 * 方法: main <br>
	 * 描述: 访问主页 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月8日 下午3:19:32
	 * 
	 * @return
	 */
	@RequestMapping("main")
	public ModelAndView main() {
		return new ModelAndView("main");
	}

	/**
	 * 
	 * 方法: loginIndex <br>
	 * 描述: 登录页 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月8日 下午3:19:43
	 * 
	 * @return
	 */
	@GetMapping("login/index")
	public ModelAndView loginIndex() {
		return new ModelAndView("login");
	}

	@PostMapping(value = "login", consumes = "application/json")
	public BaseResult login(@RequestBody ScUserDto dto, HttpSession session) {
		EntityResult<ScUser> result = userService.login(dto);
		if (result.getCode() == ResultType.SUCCESS) {
			// 将用户信息保存到session中
			session.setAttribute("user", result.getEntity());
			// 添加shiro验证
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken();
			token.setUsername(dto.getUserName());
			char[] password = dto.getPassword().toCharArray();
			token.setPassword(password);
			subject.login(token);
		}
		return result;
	}

	/**
	 * 
	 * 方法: loginOut <br>
	 * 描述: 登出接口 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月9日 下午4:57:55
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("loginout")
	public ModelAndView loginOut(HttpSession session) {
		session.removeAttribute("user");
		return new ModelAndView("login");
	}

	/**
	 * 
	 * 方法: nullPage <br>
	 * 描述: 404错误页面 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月8日 下午3:19:50
	 * 
	 * @return
	 */
	@GetMapping("error/404")
	public ModelAndView nullPage() {
		return new ModelAndView("error/404");
	}

	/**
	 * 
	 * 方法: errorPage <br>
	 * 描述: 500错误页面 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月8日 下午3:20:00
	 * 
	 * @return
	 */
	@GetMapping("error/500")
	public ModelAndView errorPage() {
		return new ModelAndView("error/500");
	}

	/**
	 * 
	 * 方法: permissionErrorPage <br>
	 * 描述: 无权限错误页面 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月8日 下午3:20:09
	 * 
	 * @return
	 */
	@GetMapping("error/permission")
	public ModelAndView permissionErrorPage() {
		return new ModelAndView("error/500");
	}

}
