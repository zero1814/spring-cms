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
public interface ScUserMapper extends IBaseMapper<ScUser, ScUserDto>{}