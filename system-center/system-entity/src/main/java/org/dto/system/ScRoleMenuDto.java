package org.dto.system;

import org.zero.spring.mybatis.BaseDto;

/**
 * 
 * 类: ScRoleMenuDto <br>
 * 描述: 角色菜单关系表参数类 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午2:01:34
 */
public class ScRoleMenuDto extends BaseDto {

	private static final long serialVersionUID = 6619127257447931432L;

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
