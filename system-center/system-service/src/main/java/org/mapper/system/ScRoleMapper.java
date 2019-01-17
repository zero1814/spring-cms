package org.mapper.system;

import java.util.List;

import org.dto.system.ScRoleDto;
import org.entity.system.ScMenu;
import org.entity.system.ScRole;
import org.entity.system.ScUser;
import org.zero.spring.mybatis.IBaseMapper;

/**
 * 
 * 类: ScRoleMapper <br>
 * 描述: 角色数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午2:13:25
 */
public interface ScRoleMapper extends IBaseMapper<ScRole, ScRoleDto> {

	/**
	 * 
	 * 方法: findRoleUsers <br>
	 * 描述: 根据角色编码查询角色下的所有用户列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月15日 上午11:23:38
	 * 
	 * @param code
	 * @return
	 */
	List<ScUser> findRoleUsers(String code);

	/**
	 * 
	 * 方法: findRoleMenus <br>
	 * 描述: 根据角色编码查询角色下的所有菜单列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月15日 上午11:24:47
	 * 
	 * @param code
	 * @return
	 */
	List<ScMenu> findRoleMenus(String code);
}