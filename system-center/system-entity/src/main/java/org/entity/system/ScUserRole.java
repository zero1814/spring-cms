package org.entity.system;

import org.zero.spring.mybatis.BaseEntity;

/**
 * 
 * 类: ScUserRole <br>
 * 描述: 用户角色关系表 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午1:47:47
 */
public class ScUserRole extends BaseEntity {

	private static final long serialVersionUID = -4737917756212670822L;

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