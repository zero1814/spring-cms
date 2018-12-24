package org.dto.system;

import org.zero.spring.mybatis.BaseDto;

/**
 * 
 * 类: ScRolePermissionDto <br>
 * 描述: 角色权限参数类 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午2:02:03
 */
public class ScRolePermissionDto extends BaseDto {

	private static final long serialVersionUID = 2545902924884945504L;

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
