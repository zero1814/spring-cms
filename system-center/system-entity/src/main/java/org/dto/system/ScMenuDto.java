package org.dto.system;

import org.zero.spring.mybatis.BaseDto;

/**
 * 
 * 类: ScMenuDto <br>
 * 描述: 菜单参数类 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午2:00:39
 */
public class ScMenuDto extends BaseDto {

	private static final long serialVersionUID = -3507182201601337619L;

	private String status;

	private String name;

	private String parentName;

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
