package org.dto.system;

import org.zero.spring.mybatis.BaseDto;

/**
 * 
 * 类: ScUserRoleDto <br>
 * 描述: 用户角色关系表 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午2:11:30
 */
public class ScUserRoleDto extends BaseDto {

	private static final long serialVersionUID = -5791129833822544776L;

	/**
	 * 用户编码
	 */
	private String userCode;

	/**
	 * 角色编码
	 */
	private String roleCode;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

}
