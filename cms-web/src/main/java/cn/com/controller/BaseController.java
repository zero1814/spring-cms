package cn.com.controller;

import javax.servlet.http.HttpSession;

import org.entity.system.ScUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.zero.spring.mybatis.BaseDto;
import org.zero.spring.mybatis.BaseEntity;
import org.zero.spring.mybatis.IBaseService;

import zero.commons.basics.result.BaseResult;
import zero.commons.basics.result.EntityResult;
import zero.commons.basics.result.PageResult;

public class BaseController<T extends BaseEntity, D extends BaseDto, S extends IBaseService<T, D>> {

	private String code;

	protected String nullUrl;

	protected String errorUrl;

	@Autowired
	private S service;

	@PostMapping(value = "insert", consumes = "application/json")
	public BaseResult insert(@RequestBody T entity, HttpSession session) {
		if (session.getAttribute("user") != null) {
			ScUser user = (ScUser) session.getAttribute("user");
			entity.setCreateUser(user.getCode());
		}
		return service.insert(entity);
	}

	@PostMapping("update")
	public BaseResult update(T entity, HttpSession session) {
		if (session.getAttribute("user") != null) {
			ScUser user = (ScUser) session.getAttribute("user");
			entity.setCreateUser(user.getCode());
		}
		return service.update(entity);
	}

	@GetMapping("get/{code}")
	public EntityResult<T> select(@PathVariable("code") String code) {
		return service.select(code);
	}

	@PostMapping("get")
	public EntityResult<T> select(D dto) {
		return service.select(dto);
	}

	@PostMapping("page")
	public PageResult<T> page(D dto) {
		return service.page(dto);
	}

	@GetMapping("del/{code}")
	public BaseResult delete(@PathVariable("code") String code) {
		return service.delete(code);
	}

	@PostMapping("del")
	public BaseResult delete(D dto) {
		return service.delete(dto);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
