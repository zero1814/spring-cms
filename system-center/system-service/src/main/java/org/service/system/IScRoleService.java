package org.service.system;

import org.dto.system.ScRoleDto;
import org.entity.system.ScMenu;
import org.entity.system.ScRole;
import org.entity.system.ScUser;
import org.zero.spring.mybatis.IBaseService;

import zero.commons.basics.result.PageResult;

/**
 * 
 * 类: ScRole <br>
 * 描述: 角色表 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午1:24:52
 */
public interface IScRoleService extends IBaseService<ScRole, ScRoleDto> {
	/**
	 * 
	 * 方法: roleUsers <br>
	 * 描述: 根据角色编码查询角色下的所有用户列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月15日 上午11:38:45
	 * 
	 * @param code
	 * @return
	 */
	PageResult<ScUser> roleUsers(ScRoleDto dto);

	/**
	 * 
	 * 方法: roleMenus <br>
	 * 描述: 根据角色编码查询角色下的所有菜单列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月15日 上午11:39:03
	 * 
	 * @param code
	 * @return
	 */
	PageResult<ScMenu> roleMenus(ScRoleDto dto);
}