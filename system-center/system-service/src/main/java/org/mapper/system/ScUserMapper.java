package org.mapper.system;

import org.dto.system.ScUserDto;
import org.entity.system.ScUser;
import org.zero.spring.mybatis.IBaseMapper;

/**
 * 
 * 类: ScUserInfoMapper <br>
 * 描述: 管理员表数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午2:28:39
 */
public interface ScUserMapper extends IBaseMapper<ScUser, ScUserDto> {

	/**
	 * 
	 * 方法: login <br>
	 * 描述: 登录查询 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月8日 下午2:43:05
	 * 
	 * @param dto
	 * @return
	 */
	ScUser login(ScUserDto dto);

	/**
	 * 
	 * 方法: verify <br>
	 * 描述: 验证用户是否已存在 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月14日 下午2:04:06
	 * 
	 * @param dto
	 * @return
	 */
	ScUser verify(ScUserDto dto);
}