package cn.com.controller;

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

	protected String nullUrl;

	protected String errorUrl;

	@Autowired
	private S service;

	@PostMapping("insert")
	public BaseResult insert(T entity) {
		return service.insert(entity);
	}

	@PostMapping("update")
	public BaseResult update(T entity) {
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
	public PageResult<T> page(@RequestBody D dto) {
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
}
