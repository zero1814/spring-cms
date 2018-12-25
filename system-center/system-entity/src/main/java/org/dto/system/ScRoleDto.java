package org.dto.system;

import org.zero.spring.mybatis.BaseDto;

/**
 * 
 * 类: ScRoleDto <br>
 * 描述: 角色参数类 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午2:01:10
 */
public class ScRoleDto extends BaseDto {

	private static final long serialVersionUID = 3836862548707946674L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
