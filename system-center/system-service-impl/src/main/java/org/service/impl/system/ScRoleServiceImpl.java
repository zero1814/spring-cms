package org.service.impl.system;

import org.dto.system.ScRoleDto;
import org.entity.system.ScRole;
import org.mapper.system.ScRoleMapper;
import org.service.system.IScRoleService;
import org.springframework.stereotype.Service;
import org.zero.spring.mybatis.BaseServiceImpl;

/**
 * 
 * 类: ScRoleServiceImpl <br>
 * 描述: 角色表业务接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午1:24:52
 */
@Service
public class ScRoleServiceImpl extends BaseServiceImpl<ScRole, ScRoleMapper, ScRoleDto> implements IScRoleService {

}