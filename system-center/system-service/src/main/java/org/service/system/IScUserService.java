package org.service.system;

import java.util.List;

import org.dto.system.ScUserDto;
import org.entity.system.ScSetting;
import org.entity.system.ScUser;
import org.zero.spring.mybatis.IBaseService;

import zero.commons.basics.result.EntityResult;

/**
 * 
 * 类: ScUserInfo <br>
 * 描述: 管理员表 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午1:34:06
 */
public interface IScUserService extends IBaseService<ScUser, ScUserDto> {

	/**
	 * 
	 * 方法: types <br>
	 * 描述: 用户类型 <br>
	 * 作者: zhy<br>
	 * 时间: 2018年12月25日 上午9:55:39
	 * 
	 * @return
	 */
	List<ScSetting> types();

	/**
	 * 
	 * 方法: status <br>
	 * 描述: 用户状态 <br>
	 * 作者: zhy<br>
	 * 时间: 2018年12月25日 上午9:55:46
	 * 
	 * @return
	 */
	List<ScSetting> status();

	/**
	 * 
	 * 方法: login <br>
	 * 描述: 管理员登录 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月8日 下午2:24:55
	 * 
	 * @param dto
	 * @return
	 */
	EntityResult<ScUser> login(ScUserDto dto);

	/**
	 * 
	 * 方法: updatePassword <br>
	 * 描述: 修改密码 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月15日 下午3:34:05
	 * 
	 * @param entity
	 * @param password
	 * @return
	 */
	EntityResult<ScUser> updatePassword(ScUser entity, String password);
}