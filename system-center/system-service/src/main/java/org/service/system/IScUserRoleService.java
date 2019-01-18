package org.service.system;

import org.dto.system.ScUserRoleDto;
import org.entity.system.ScRole;
import org.entity.system.ScUser;
import org.entity.system.ScUserRole;
import org.zero.spring.mybatis.IBaseService;

import zero.commons.basics.result.TransferResult;

/**
 * 
 * 类: ScUserRole <br>
 * 描述: 用户角色关系表业务处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午1:47:47
 */
public interface IScUserRoleService extends IBaseService<ScUserRole, ScUserRoleDto> {

	/**
	 * 
	 * 方法: roleUsers <br>
	 * 描述: 根据角色编码查询用户列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月18日 下午2:09:36
	 * 
	 * @param roleCode
	 * @return
	 */
	TransferResult<ScUser> roleUsers(String roleCode);

	/**
	 * 
	 * 方法: userRoles <br>
	 * 描述: 根据用户编码查询角色列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年1月18日 下午2:10:08
	 * 
	 * @param code
	 * @return
	 */
	TransferResult<ScRole> userRoles(String userCode);
}