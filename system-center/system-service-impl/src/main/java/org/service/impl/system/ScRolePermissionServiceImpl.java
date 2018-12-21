package org.service.impl.system;

import org.dto.system.ScRolePermissionDto;
import org.entity.system.ScRolePermission;
import org.mapper.system.ScRolePermissionMapper;
import org.service.system.IScRolePermissionService;
import org.springframework.stereotype.Service;
import org.zero.spring.mybatis.BaseServiceImpl;

/**
 * 
 * 类: ScRolePermissionServiceImpl <br>
 * 描述: 角色权限关系表业务处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午1:30:31
 */
@Service
public class ScRolePermissionServiceImpl
		extends BaseServiceImpl<ScRolePermission, ScRolePermissionMapper, ScRolePermissionDto>
		implements IScRolePermissionService {
}