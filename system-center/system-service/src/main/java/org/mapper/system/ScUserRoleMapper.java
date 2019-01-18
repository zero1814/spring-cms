package org.mapper.system;

import java.util.List;

import org.dto.system.ScUserRoleDto;
import org.entity.system.ScRole;
import org.entity.system.ScUser;
import org.entity.system.ScUserRole;
import org.zero.spring.mybatis.IBaseMapper;

/**
 * 
 * 类: ScUserRoleMapper <br>
 * 描述: 用户角色关系表数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午2:29:00
 */
public interface ScUserRoleMapper extends IBaseMapper<ScUserRole, ScUserRoleDto> {

	/**
	 * 
	 * 方法: selectUserRoles <br>
	 * 描述: 根据用户编码查询角色列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月18日 下午3:25:02
	 * 
	 * @param userCode
	 * @return
	 */
	List<ScRole> selectUserRoles(String userCode);

	/**
	 * 
	 * 方法: selectUserNotRoles <br>
	 * 描述: 根据用户编码查询没有此用户的角色列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月18日 下午3:25:13
	 * 
	 * @param userCode
	 * @return
	 */
	List<ScRole> selectUserNotRoles(String userCode);

	/**
	 * 
	 * 方法: selectRoleUsers <br>
	 * 描述: 根据角色编码查询用户列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月18日 下午3:25:38
	 * 
	 * @param roleCode
	 * @return
	 */
	List<ScUser> selectRoleUsers(String roleCode);

	/**
	 * 
	 * 方法: selectRoleNotUsers <br>
	 * 描述: 根据角色编码查询没有此角色的用户列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月18日 下午3:25:52
	 * 
	 * @param roleCode
	 * @return
	 */
	List<ScUser> selectRoleNotUsers(String roleCode);

}