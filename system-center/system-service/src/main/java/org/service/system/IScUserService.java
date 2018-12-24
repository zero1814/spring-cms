package org.service.system;

import org.dto.system.ScUserDto;
import org.entity.system.ScUser;
import org.zero.spring.mybatis.IBaseService;

/**
 * 
 * 类: ScUserInfo <br>
 * 描述: 管理员表 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午1:34:06
 */
public interface IScUserService extends IBaseService<ScUser, ScUserDto> {
}