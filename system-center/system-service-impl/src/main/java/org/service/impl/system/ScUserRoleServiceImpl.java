package org.service.impl.system;

import org.dto.system.ScUserRoleDto;
import org.entity.system.ScUserRole;
import org.mapper.system.ScUserRoleMapper;
import org.service.system.IScUserRoleService;
import org.springframework.stereotype.Service;
import org.zero.spring.mybatis.BaseServiceImpl;

/**
 * 
 * 类: ScUserRole <br>
 * 描述: 用户角色关系表 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午1:47:47
 */
@Service
public class ScUserRoleServiceImpl extends BaseServiceImpl<ScUserRole, ScUserRoleMapper, ScUserRoleDto>
		implements IScUserRoleService {
}