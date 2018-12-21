package org.service.impl.system;

import org.dto.system.ScRoleMenuDto;
import org.entity.system.ScRoleMenu;
import org.mapper.system.ScRoleMenuMapper;
import org.service.system.IScRoleMenuService;
import org.springframework.stereotype.Service;
import org.zero.spring.mybatis.BaseServiceImpl;

/**
 * 
 * 类: ScRoleMenuServiceImpl <br>
 * 描述: 角色菜单关系表业务接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午1:25:27
 */
@Service
public class ScRoleMenuServiceImpl extends BaseServiceImpl<ScRoleMenu, ScRoleMenuMapper, ScRoleMenuDto>
		implements IScRoleMenuService {
}