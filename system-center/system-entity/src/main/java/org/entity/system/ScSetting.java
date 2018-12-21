package org.entity.system;

import org.zero.spring.mybatis.BaseEntity;

/**
 * 
 * 类: ScSetting <br>
 * 描述: 系统相关配置表 <br>
 * 作者: zhy<br>
 * 时间: 2018年12月21日 下午1:31:19
 */
public class ScSetting extends BaseEntity {

	private static final long serialVersionUID = 995115281156833727L;

	/**
	 * 父级编码
	 */
	private String parentCode;

	/**
	 * 名称
	 */
	private String name;

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}