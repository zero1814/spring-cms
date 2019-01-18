package org.service.impl.system;

import java.util.List;

import org.dto.system.ScUserRoleDto;
import org.entity.system.ScRole;
import org.entity.system.ScUser;
import org.entity.system.ScUserRole;
import org.mapper.system.ScUserRoleMapper;
import org.service.system.IScUserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zero.spring.mybatis.BaseServiceImpl;

import zero.commons.basics.result.ResultType;
import zero.commons.basics.result.TransferResult;

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
	private static Logger logger = LoggerFactory.getLogger(ScUserRoleServiceImpl.class);

	@Autowired
	private ScUserRoleMapper mapper;

	/**
	 * 
	 * 方法: roleUsers <br>
	 * 
	 * @param roleCode
	 * @return
	 * @see org.service.system.IScUserRoleService#roleUsers(java.lang.String)
	 */
	@Override
	public TransferResult<ScUser> roleUsers(String roleCode) {
		TransferResult<ScUser> result = new TransferResult<ScUser>();
		try {
			List<ScUser> left = mapper.selectRoleNotUsers(roleCode);
			List<ScUser> right = mapper.selectRoleUsers(roleCode);
			result.setLeft(left);
			result.setRight(right);
			result.setCode(ResultType.SUCCESS);
			result.setMessage("查询成功");
		} catch (Exception e) {
			logger.error("根据角色编码查询用户列表报错，错误原因：" + e.getMessage());
			result.setCode(ResultType.ERROR);
			result.setMessage("根据角色编码查询用户列表报错");
		}
		return result;
	}

	/**
	 * 
	 * 方法: userRoles <br>
	 * 
	 * @param userCode
	 * @return
	 * @see org.service.system.IScUserRoleService#userRoles(java.lang.String)
	 */
	@Override
	public TransferResult<ScRole> userRoles(String userCode) {
		TransferResult<ScRole> result = new TransferResult<ScRole>();
		try {
			List<ScRole> left = mapper.selectUserNotRoles(userCode);
			List<ScRole> right = mapper.selectUserRoles(userCode);
			result.setLeft(left);
			result.setRight(right);
			result.setCode(ResultType.SUCCESS);
			result.setMessage("查询成功");
		} catch (Exception e) {
			logger.error("根据角色编码查询用户列表报错，错误原因：" + e.getMessage());
			result.setCode(ResultType.ERROR);
			result.setMessage("根据角色编码查询用户列表报错");
		}
		return result;
	}

}