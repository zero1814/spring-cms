package org.entity.system;

import org.zero.spring.mybatis.BaseEntity;

/**
 * 
 * 类: ScRolePermission <br>
 * 描述: 角色权限关系表 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午1:30:31
 */
public class ScRolePermission extends BaseEntity {

	private static final long serialVersionUID = -3317451753709011392L;

	/**
	 * 角色编码
	 */
	private String roleCode;

	/**
	 * 权限编码
	 */
	private String permissionCode;

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getPermissionCode() {
		return permissionCode;
	}

	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}

}