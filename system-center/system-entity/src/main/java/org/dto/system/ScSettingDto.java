package org.dto.system;

import org.zero.spring.mybatis.BaseDto;

/**
 * 
 * 类: ScSettingDto <br>
 * 描述: 系统配置参数类 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午2:07:37
 */
public class ScSettingDto extends BaseDto {

	private static final long serialVersionUID = -4547126433806422294L;
	/**
	 * 父级编码
	 */
	private String parentCode;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

}
