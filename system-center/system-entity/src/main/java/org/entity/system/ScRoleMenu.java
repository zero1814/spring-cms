package org.entity.system;

import org.zero.spring.mybatis.BaseEntity;

/**
 * 
 * 类: ScRoleMenu <br>
 * 描述: 角色菜单关系表 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午1:25:27
 */
public class ScRoleMenu extends BaseEntity {

	private static final long serialVersionUID = -783370351959442637L;

	/**
	 * 角色编码
	 */
	private String roleCode;

	/**
	 * 菜单编码
	 */
	private String menuCode;

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

}